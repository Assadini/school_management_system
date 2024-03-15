package Domaine.projet;

import java.util.ArrayList;
import java.util.Date;

import Domaine.projet.Tache;

public class Phase {
	private int id;
	private String nom;
	private Date dateDebut;
	private Date dateFin;
	private short duree;
	private String etat;
	private String description;
	private Projet projet;
	private ArrayList<Tache> taches;
	public Phase() {
		super();
	}
	public Phase(int id, String nom, Date dateDebut, Date dateFin, short duree,
			String etat, String description, Projet projet) {
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.etat = etat;
		this.description = description;
		this.projet = projet;
		this.taches = new ArrayList<Tache>();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public short getDuree() {
		return duree;
	}
	public void setDuree(short duree) {
		this.duree = duree;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
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
	public ArrayList<Tache> getTaches() {
		return taches;
	}
	public void setTaches(ArrayList<Tache> taches) {
		this.taches = taches;
	}
	@Override
	public String toString() {
		return "Phase [id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", duree=" + duree + ", etat="
				+ etat + ", description=" + description + ", projet=" + projet
				+ ", taches=" + taches + "]";
	}
}