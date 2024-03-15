package Domaine.communication;

import Domaine.utilisateur.Utilisateur;
import java.util.ArrayList;
import java.util.Date;

import Domaine.classe.Classe;
import Domaine.communication.DocumentAnnonce;

public class Annonce {
	private int id;
	private Date date;
	private String objet;
	private String texte;
	private String priorite;
	private Date dateExpiration;
	private String etat;
	private Utilisateur annonceur;
	private ArrayList<Classe> classes ;
	private ArrayList<DocumentAnnonce> documents ;
	public Annonce() {
		super();
	}
	public Annonce(int id, Date date, String objet, String texte,
			String priorite, Date dateExpiration, String etat,
			Utilisateur annonceur) {
		super();
		this.id = id;
		this.date = date;
		this.objet = objet;
		this.texte = texte;
		this.priorite = priorite;
		this.dateExpiration = dateExpiration;
		this.etat = etat;
		this.annonceur = annonceur;
		this.classes = new ArrayList<Classe>();
		this.documents = new ArrayList<DocumentAnnonce>();
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
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Utilisateur getAnnonceur() {
		return annonceur;
	}
	public void setAnnonceur(Utilisateur annonceur) {
		this.annonceur = annonceur;
	}
	public ArrayList<Classe> getClasses() {
		return classes;
	}
	public void addClasses(Classe classe) {
		this.classes.add(classe);
	}
	public ArrayList<DocumentAnnonce> getDocuments() {
		return documents;
	}
	public void addDocuments(DocumentAnnonce document) {
		this.documents.add(document);
	}
	@Override
	public String toString() {
		return "Annonce [id=" + id + ", date=" + date + ", objet=" + objet
				+ ", texte=" + texte + ", priorite=" + priorite
				+ ", dateExpiration=" + dateExpiration + ", etat=" + etat
				+ ", annonceur=" + annonceur + ", classes=" + classes
				+ ", documents=" + documents + "]";
	}
}