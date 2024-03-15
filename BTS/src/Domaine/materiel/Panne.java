package Domaine.materiel;

import java.util.Date;

import Domaine.personnel.Professeur;

public class Panne {
	private int id;
	private Date date;
	private String description;
	private Professeur declareur;
	private ExemplaireMateriel exemplaire;
	private Reparartion reparation;
	public Panne() {
		super();
	}
	public Panne(int id, Date date, String description, Professeur declareur,
			ExemplaireMateriel exemplaire) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.declareur = declareur;
		this.exemplaire = exemplaire;
		this.reparation = null;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Professeur getDeclareur() {
		return declareur;
	}
	public void setDeclareur(Professeur declareur) {
		this.declareur = declareur;
	}
	public ExemplaireMateriel getExemplaire() {
		return exemplaire;
	}
	public void setExemplaire(ExemplaireMateriel exemplaire) {
		this.exemplaire = exemplaire;
	}
	public Reparartion getReparation() {
		return reparation;
	}
	public void setReparation(Reparartion reparation) {
		this.reparation = reparation;
	}
	@Override
	public String toString() {
		return "Panne [id=" + id + ", date=" + date + ", description="
				+ description + ", declareur=" + declareur + ", exemplaire="
				+ exemplaire + ", reparation=" + reparation + "]";
	}
}