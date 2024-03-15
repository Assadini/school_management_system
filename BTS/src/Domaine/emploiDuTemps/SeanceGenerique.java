package Domaine.emploiDuTemps;

import Domaine.classe.Classe;
import Domaine.personnel.Professeur;
import Domaine.locaux.Salle;
import Domaine.matiere.Matiere;
import Domaine.matiere.Module;
import Domaine.matiere.Periode;

public class SeanceGenerique {
	private int id;
	private String jour;
	private String heureDebut;
	private String heureFin;
	private short duree;
	private String observation;
	private Classe classe;
	private Professeur professeur;
	private Salle salle;
	private Matiere matiere;
	private Module module;
	private Periode periode;
	public SeanceGenerique() {
		super();
	}
	public SeanceGenerique(int id, String jour, String heureDebut,
			String heureFin, short duree, String observation, Classe classe,
			Professeur professeur, Salle salle, Matiere matiere,
			Periode periode) {
		super();
		this.id = id;
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.duree = duree;
		this.observation = observation;
		this.classe = classe;
		this.professeur = professeur;
		this.salle = salle;
		this.periode = periode;
		this.matiere = matiere;
		/*
		 * Intialier pour une Matière qui ne contient pas de Modules
		 */
		this.module = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}
	public short getDuree() {
		return duree;
	}
	public void setDuree(short duree) {
		this.duree = duree;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	@Override
	public String toString() {
		return "SeanceGenerique [id=" + id + ", jour=" + jour + ", heureDebut="
				+ heureDebut + ", heureFin=" + heureFin + ", duree=" + duree
				+ ", observation=" + observation + ", classe=" + classe
				+ ", professeur=" + professeur + ", salle=" + salle
				+ ", matiere=" + matiere + ", module=" + module + ", periode="
				+ periode + "]";
	}
}