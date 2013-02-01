package com.utilisateur.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.utilisateur.classes.Utilisateur;
import com.utilisateur.model.UtilisateurController;

public class UtilisateurTest {

	UtilisateurController userC ;
	
	public UtilisateurTest() {
		userC = new UtilisateurController();
	}
	
	@Test
	public void nouvelUtilisateurTest() throws IOException{
		Assert.assertNotNull(userC.nouvelUtilisateur("Login","motdepasse"));
	}
	
	public void EncryptDecryptTest() throws IOException{
		Utilisateur user = userC.nouvelUtilisateur("login","motdepasse");
		
		String Encryptedpassword = userC.EncryptPassword(user.getMotDePasse());
		String Decryptedpassword = userC.DecryptPassword(Encryptedpassword);
		
		Assert.assertEquals(user.getMotDePasse(), Decryptedpassword);
	}
}
