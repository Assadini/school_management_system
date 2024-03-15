package Domaine.communication;

import Domaine.utilisateur.Utilisateur;
import java.util.ArrayList;
import java.util.Date;

import Domaine.communication.DocumentActualite;

public class Actualite {
	private int id;
	private Date date;
	private String objet;
	private String texte;
	private String priorite;
	private String etat;
	private Date dateExpiritation;
	private Utilisateur editeur;
	private ArrayList<DocumentActualite> documents = new ArrayList<DocumentActualite>();
	public Actualite() {
		super();
	}
	public Actualite(int id, Date date, String objet, String texte,
			String priorite, String etat, Date dateExpiritation,
			Utilisateur editeur) {
		super();
		this.id = id;
		this.date = date;
		this.objet = objet;
		this.texte = texte;
		this.priorite = priorite;
		this.etat = etat;
		this.dateExpiritation = dateExpiritation;
		this.editeur = editeur;
		this.documents = null;
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
	public String getPriorite() {
		return priorite;
	}
	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDateExpiritation() {
		return dateExpiritation;
	}
	public void setDateExpiritation(Date dateExpiritation) {
		this.dateExpiritation = dateExpiritation;
	}
	public Utilisateur getEditeur() {
		return editeur;
	}
	public void setEditeur(Utilisateur editeur) {
		this.editeur = editeur;
	}
	public ArrayList<DocumentActualite> getDocuments() {
		return documents;
	}
	public void addDocuments(DocumentActualite document) {
		this.documents.add(document);
	}
	@Override
	public String toString() {
		return "Actualite [id=" + id + ", date=" + date + ", objet=" + objet
				+ ", texte=" + texte + ", priorite=" + priorite + ", etat="
				+ etat + ", dateExpiritation=" + dateExpiritation
				+ ", editeur=" + editeur + ", documents=" + documents + "]";
	}
}