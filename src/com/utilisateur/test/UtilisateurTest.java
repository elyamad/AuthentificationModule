package com.utilisateur.test;

import org.junit.Assert;
import org.junit.Test;

import com.utilisateur.classes.Utilisateur;
import com.utilisateur.model.UtilisateurModel;

public class UtilisateurTest {

	UtilisateurModel userM = new UtilisateurModel();
	
	@Test
	public void nouvelUtilisateurTest(){
		Utilisateur NewUser = userM.nouvelUtilisateur("login","motdepasse");
		Assert.assertNotNull(NewUser);
	}
	
	@Test
	public void EncryptDecryptTest(){
		Utilisateur NewUser = userM.nouvelUtilisateur("login","motdepasse");
		
		String Encryptedpassword = userM.EncryptPassword(NewUser.getMotDePasse());
		String Decryptedpassword = userM.DecryptPassword(Encryptedpassword);
		
		Assert.assertEquals(NewUser.getMotDePasse(), Decryptedpassword);
	}
}
