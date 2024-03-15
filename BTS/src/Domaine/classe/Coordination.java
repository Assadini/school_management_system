package Domaine.classe;

import Domaine.personnel.Professeur;

public class Coordination {
	private int id;
	private String observation;
	private Professeur professeur;
	private AnneeScolaire anneeScolaire;
	private Filiere filiere;
	public Coordination() {
		super();
	}
	public Coordination(int id, String observation, Professeur professeur,
			AnneeScolaire anneeScolaire, Filiere filiere) {
		super();
		this.id = id;
		this.observation = observation;
		this.professeur = professeur;
		this.anneeScolaire = anneeScolaire;
		this.filiere = filiere;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}
	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	@Override
	public String toString() {
		return "Coordination [id=" + id + ", observation=" + observation
				+ ", professeur=" + professeur + ", anneeScolaire="
				+ anneeScolaire + ", filiere=" + filiere + "]";
	}
}