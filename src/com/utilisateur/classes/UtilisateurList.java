package com.utilisateur.classes;

import java.util.ArrayList;
import java.util.List;


public class UtilisateurList  {

	List<Utilisateur> UserList;
	
	public UtilisateurList() {
		UserList = new ArrayList<Utilisateur>();
	}
	
	public boolean add(Utilisateur user){
		return UserList.add(user);
	}
	
	public int Size() {
		return UserList.size();
	}
	
	/**
	 * 
	 * @param user Utilisateur
	 * @return true si user existe dans la liste
	 *         return false sinon .
	 */
	public boolean contains(Utilisateur user) {
		for (int i=0; i<Size(); i++){
			if(UserList.get(i).getLogin().equals(user.getLogin()))
				return true;
		}
		return false;
	}
}
