package Domaine.communication;

import java.util.Date;

import Domaine.utilisateur.Utilisateur;

public class Invitation {
	private int id;
	private Date date;
	private String etat;
	private String lu;
	private Utilisateur expediteur;
	private Utilisateur destinataire;
	public Invitation() {
		super();
	}
	public Invitation(int id, Date date, String etat, String lu,
			Utilisateur expediteur, Utilisateur destinataire) {
		super();
		this.id = id;
		this.date = date;
		this.etat = etat;
		this.lu = lu;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getLu() {
		return lu;
	}
	public void setLu(String lu) {
		this.lu = lu;
	}
	public Utilisateur getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(Utilisateur expediteur) {
		this.expediteur = expediteur;
	}
	public Utilisateur getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}
	@Override
	public String toString() {
		return "Invitation [id=" + id + ", date=" + date + ", etat=" + etat
				+ ", lu=" + lu + ", expediteur=" + expediteur
				+ ", destinataire=" + destinataire + "]";
	}
}