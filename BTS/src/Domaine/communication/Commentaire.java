package Domaine.communication;

import java.util.Date;

import Domaine.utilisateur.Utilisateur;

public class Commentaire {
	private int id;
	private Date date;
	private String texte;
	private String etat;
	private Publication publication;
	private Utilisateur commentateur;
	public Commentaire() {
		super();
	}
	public Commentaire(int id, Date date, String texte, String etat,
			Publication publication, Utilisateur commentateur) {
		super();
		this.id = id;
		this.date = date;
		this.texte = texte;
		this.etat = etat;
		this.publication = publication;
		this.commentateur = commentateur;
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
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Utilisateur getCommentateur() {
		return commentateur;
	}
	public void setCommentateur(Utilisateur commentateur) {
		this.commentateur = commentateur;
	}
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", date=" + date + ", texte=" + texte
				+ ", etat=" + etat + ", publication=" + publication
				+ ", commentateur=" + commentateur + "]";
	}
}