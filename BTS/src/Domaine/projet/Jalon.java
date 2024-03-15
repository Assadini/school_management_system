package Domaine.projet;

import java.util.ArrayList;
import java.util.Date;

import Domaine.projet.LivrableProjet;

public class Jalon {
	private int id;
	private Date date;
	private String nom;
	private String description;
	private Projet projet;
	private ArrayList<LivrableProjet> livrableProjets;
	public Jalon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jalon(int id, Date date, String nom, String description,
			Projet projet) {
		this.id = id;
		this.date = date;
		this.nom = nom;
		this.description = description;
		this.projet = projet;
		this.livrableProjets = new ArrayList<LivrableProjet>();
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public ArrayList<LivrableProjet> getLivrableProjets() {
		return livrableProjets;
	}
	public void addLivrableProjets(LivrableProjet livrableProjet) {
		this.livrableProjets.add(livrableProjet);
	}
	@Override
	public String toString() {
		return "Jalon [id=" + id + ", date=" + date + ", nom=" + nom
				+ ", description=" + description + ", projet=" + projet
				+ ", livrableProjets=" + livrableProjets + "]";
	}
}