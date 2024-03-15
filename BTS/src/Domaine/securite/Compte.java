package Domaine.securite;

import java.util.Date;

import Domaine.utilisateur.Utilisateur;

public class Compte {
	private int id;
	private String login;
	private String motPass;
	private Date dateCreation;
	private String etat;
	private boolean onLine;
	private String statut;		//Enligne, Occupe, Absent, HorsLigne
	private Role role;
	private String codeRecuperation ;
	private Utilisateur utilisateur;
	public Compte() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotPass() {
		return motPass;
	}
	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public boolean isOnLine() {
		return onLine;
	}
	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getCodeRecuperation() {
		return codeRecuperation;
	}
	public void genererCodeRecuperation(String codeRecuperation) {
		//TODO : utiliser un algorithme de generation de code aleatoires
		this.codeRecuperation = " ExempleCode";
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public void setCodeRecuperation(String codeRecuperation) {
		this.codeRecuperation = codeRecuperation;
	}
	
}