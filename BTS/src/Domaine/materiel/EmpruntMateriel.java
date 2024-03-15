package Domaine.materiel;

import java.util.Date;

import Domaine.utilisateur.Utilisateur;

public class EmpruntMateriel {
	private int id;
	private ExemplaireMateriel exemplaireMateriel;
	private Utilisateur emprunteur;
	private Date dateEmprunt;
	private Date dateRetour;
	private String observation;
	private String etat;
	public EmpruntMateriel() {
		super();
	}
	public EmpruntMateriel(int id, ExemplaireMateriel exemplaireMateriel,Utilisateur emprunteur, Date dateEmprunt, Date dateRetour,
			String observation, String etat) {
		super();
		this.id = id;
		this.exemplaireMateriel=exemplaireMateriel;
		this.emprunteur=emprunteur;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.observation = observation;
		this.etat = etat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ExemplaireMateriel getExemplaireMateriel() {
		return exemplaireMateriel;
	}
	public void setExemplaireMateriel(ExemplaireMateriel exemplaireMateriel) {
		this.exemplaireMateriel = exemplaireMateriel;
	}
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "EmpruntMateriel [id=" + id + ", exemplaireMateriel="
				+ exemplaireMateriel + ", Emprunteur=" + emprunteur
				+ ", dateEmprunt=" + dateEmprunt + ", dateRetour=" + dateRetour
				+ ", observation=" + observation + ", etat=" + etat + "]";
	}
}