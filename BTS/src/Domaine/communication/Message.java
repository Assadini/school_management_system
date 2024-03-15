package Domaine.communication;

import java.util.ArrayList;
import java.util.Date;

import Domaine.communication.DocumentMessage;
import Domaine.utilisateur.Utilisateur;

public class Message {
	private int id;
	private Date date;
	private String objet;
	private String texte;
	private String etat;
	private String lu;
	public ArrayList<DocumentMessage> piecesJointes;
	private Utilisateur expediteur;
	private Utilisateur destinataire;
	public Message() {
		super();
	}
	public Message(int id, Date date, String objet, String texte, String etat,
			String lu, Utilisateur expediteur, Utilisateur destinataire) {
		super();
		this.id = id;
		this.date = date;
		this.objet = objet;
		this.texte = texte;
		this.etat = etat;
		this.lu = lu;
		this.piecesJointes = new ArrayList<DocumentMessage>();
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
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
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
	public String getLu() {
		return lu;
	}
	public void setLu(String lu) {
		this.lu = lu;
	}
	public ArrayList<DocumentMessage> getPiecesJointes() {
		return piecesJointes;
	}
	public void addPiecesJointes(DocumentMessage pieceJointe) {
		this.piecesJointes.add(pieceJointe);
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
		return "Message [id=" + id + ", date=" + date + ", objet=" + objet
				+ ", texte=" + texte + ", etat=" + etat + ", lu=" + lu
				+ ", piecesJointes=" + piecesJointes + ", expediteur="
				+ expediteur + ", destinataire=" + destinataire + "]";
	}
}