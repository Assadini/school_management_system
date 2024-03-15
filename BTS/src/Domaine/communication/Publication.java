package Domaine.communication;

import Domaine.personnel.Professeur;
import Domaine.classe.Classe;
import java.util.ArrayList;
import java.util.Date;

import Domaine.communication.FansPublication;

public class Publication {
	private int id;
	private Date date;
	private String objet;
	private String texte;
	private String etat;
	private Professeur publicateur;
	private Classe classe;
	public ArrayList<FansPublication> fans ;
	public ArrayList<Commentaire> commentaires;
	private DocumentPublication document;
	public Publication() {
		super();
	}
	public Publication(int id, Date date, String objet, String texte,
			String etat, Professeur publicateur, Classe classe, DocumentPublication document) {
		super();
		this.id = id;
		this.date = date;
		this.objet = objet;
		this.texte = texte;
		this.etat = etat;
		this.publicateur = publicateur;
		this.classe = classe;
		this.fans = new ArrayList<FansPublication>();
		this.commentaires = new ArrayList<Commentaire>();
		this.document = document;
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
	public Professeur getPublicateur() {
		return publicateur;
	}
	public void setPublicateur(Professeur publicateur) {
		this.publicateur = publicateur;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public ArrayList<FansPublication> getFans() {
		return fans;
	}
	public void addFans(FansPublication fan) {
		this.fans.add(fan);
	}
	public DocumentPublication getDocument() {
		return document;
	}
	public void setDocument(DocumentPublication document) {
		this.document = document;
	}
	
	public ArrayList<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void addCommentaire(Commentaire commentaire) {
		this.commentaires.add(commentaire);
	}
	@Override
	public String toString() {
		return "Publication [id=" + id + ", date=" + date + ", objet=" + objet
				+ ", texte=" + texte + ", etat=" + etat + ", publicateur="
				+ publicateur + ", classe=" + classe + ", fans=" + fans
				+ ", commentaires=" + commentaires 
				+ ", document=" + document + "]";
	}
}