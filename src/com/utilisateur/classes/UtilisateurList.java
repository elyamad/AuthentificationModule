package com.utilisateur.classes;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurList {

	List<Utilisateur> UserList;
	
	public UtilisateurList() {
		UserList = new ArrayList<Utilisateur>();
	}
	
	public void add(Utilisateur user){
		UserList.add(user);
	}
}
