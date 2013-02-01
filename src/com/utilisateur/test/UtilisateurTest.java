package com.utilisateur.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.utilisateur.classes.Utilisateur;
import com.utilisateur.model.UtilisateurController;

public class UtilisateurTest {

	Utilisateur user = new Utilisateur();
	UtilisateurController userM = new UtilisateurController(user);
	
	@Test
	public void nouvelUtilisateurTest() throws IOException{
		userM.nouvelUtilisateur("login","motdepasse");
		Assert.assertNotNull(user);
	}
	
	@Test
	public void EncryptDecryptTest() throws IOException{
		Utilisateur NewUser = userM.nouvelUtilisateur("login","motdepasse");
		
		String Encryptedpassword = userM.EncryptPassword(NewUser.getMotDePasse());
		String Decryptedpassword = userM.DecryptPassword(Encryptedpassword);
		
		Assert.assertEquals(NewUser.getMotDePasse(), Decryptedpassword);
	}
}
