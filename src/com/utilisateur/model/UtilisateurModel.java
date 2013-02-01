package com.utilisateur.model;

import java.util.ArrayList;
import java.util.List;

import org.jasypt.util.text.BasicTextEncryptor;

import com.utilisateur.classes.Utilisateur;

public class UtilisateurModel {
	
	Utilisateur user ;
	
	List<Utilisateur> UserList =  new ArrayList<Utilisateur>();
	List<Utilisateur> UserSingleton = new ArrayList<Utilisateur>();
	
	
	
	public void setUser(Utilisateur user){
		this.user = user;
	}
	
	public List<Utilisateur> getUserList() {
		return UserList;
	}
	
	/**
	 * Création d'un nouvel Utilisateur
	 * 
	 * @param login le login
	 * @param moDePasse le mot de passe en clair 
	 * @return le nouvel Utilisateur ou <code>null</code> si la création a échoué
	 */
	public Utilisateur nouvelUtilisateur(String login, String motDePasse) {
		Utilisateur user = new Utilisateur();
		user.setLogin(login);
		user.setMotDePasse(EncryptPassword(motDePasse));
		UserList.add(user);
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
	
}
