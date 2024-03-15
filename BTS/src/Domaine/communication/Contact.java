package Domaine.communication;

import java.util.Date;

import Domaine.utilisateur.Utilisateur;

public class Contact {
	private int id;
	private Date date;
	private String etat;
	private Utilisateur utilisateur2;
	private Utilisateur utilisateur1;
	public Contact() {
		super();
	}
	public Contact(int id, Date date, String etat, Utilisateur utilisateur2,
			Utilisateur utilisateur1) {
		super();
		this.id = id;
		this.date = date;
		this.etat = etat;
		this.utilisateur2 = utilisateur2;
		this.utilisateur1 = utilisateur1;
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
	public Utilisateur getUtilisateur2() {
		return utilisateur2;
	}
	public void setUtilisateur2(Utilisateur utilisateur2) {
		this.utilisateur2 = utilisateur2;
	}
	public Utilisateur getUtilisateur1() {
		return utilisateur1;
	}
	public void setUtilisateur1(Utilisateur utilisateur1) {
		this.utilisateur1 = utilisateur1;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", date=" + date + ", etat=" + etat
				+ ", utilisateur2=" + utilisateur2 + ", utilisateur1="
				+ utilisateur1 + "]";
	}
}