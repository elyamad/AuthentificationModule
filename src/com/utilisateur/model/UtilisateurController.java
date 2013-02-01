package com.utilisateur.model;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jasypt.util.text.BasicTextEncryptor;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.utilisateur.classes.Utilisateur;
import com.utilisateur.classes.UtilisateurList;

public class UtilisateurController {
	
	String XmlPath ;
	UtilisateurList UserList ;
	
	public UtilisateurController() {
	    UserList =  new UtilisateurList();	
		XmlPath = "./users/users.xml";
	}
	
	/**
	 * Création d'un nouvel Utilisateur
	 * 
	 * @param login le login
	 * @param moDePasse le mot de passe en clair 
	 * @return le nouvel Utilisateur ou <code>null</code> si la création a échoué
	 * @throws IOException 
	 */
	public Utilisateur nouvelUtilisateur(String login, String motDePasse) throws IOException {
		Utilisateur user = new Utilisateur(login, motDePasse);
		user.setMotDePasse(EncryptPassword(motDePasse));
		AddToXML(user);
		return user ;
	}
	
	public String EncryptPassword(String password){
		String key = "key";
		
		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		
		//création d'un Encryptor avec une clé de cryptage
        textEncryptor.setPassword(key);
        
        // Mot de passe encrypted
        return textEncryptor.encrypt(password);

	}
	
	public String DecryptPassword(String passwordEncrypted){
		String key = "key";

		BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
		
		//création d'un Encryptor avec une clé de cryptage
        textEncryptor.setPassword(key);
        return textEncryptor.decrypt(passwordEncrypted);
        
	}
	
	public boolean AddToXML(Utilisateur user) throws IOException {
		try {
			 XStream xstream = new XStream(new DomDriver());
			 xstream.alias("Utilisateur", Utilisateur.class);
			 xstream.alias("Utilisateurs", UtilisateurList.class);
			 xstream.addImplicitCollection(UtilisateurList.class, "UserList");
			 
			 FileInputStream  fis = new FileInputStream (XmlPath);
			 UserList = (UtilisateurList) xstream.fromXML(fis) ;
			 
			 if(!UserList.contains(user)) UserList.add(user);
			 
			 FileOutputStream fos = new FileOutputStream(XmlPath);
			 
			 try {
				// Sérialisation de l'objet user
				 xstream.toXML(UserList, fos);
		    } finally {
		    	// On s'assure de fermer le flux quoi qu'il arrive
		    	fos.close();
		    }
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	
	
}
