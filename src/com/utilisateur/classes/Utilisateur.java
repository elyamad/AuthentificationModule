package com.utilisateur.classes;

public class Utilisateur {

	private String login;
	private String motDePasse;

	public Utilisateur(String log, String mdp) {
		login = log; 
		motDePasse = mdp ;
	}
	
	public Utilisateur() {}

	public String getLogin() {
		return this.login;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMotDePasse(String modepasse) {
		this.motDePasse = modepasse;
	}
	
	
}
