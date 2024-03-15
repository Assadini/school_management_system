package Domaine.bibliotheque;

import java.util.Date;

import Domaine.utilisateur.Utilisateur;

public class EmpruntBibliotheque {
	private int id;
	private Utilisateur emprunteur;
	private ExemplaireLivre exemplaireLivre;
	private Date dateEmprunt;
	private Date dateRetour;
	private String observation;
	private String etat;
	public EmpruntBibliotheque() {
		super();
	}
	public EmpruntBibliotheque(int id, Utilisateur emprunteur,
			ExemplaireLivre exemplaireLivre, Date dateEmprunt,
			String observation, String etat) {
		super();
		this.id = id;
		this.emprunteur = emprunteur;
		this.exemplaireLivre = exemplaireLivre;
		this.dateEmprunt = dateEmprunt;
		this.observation = observation;
		this.etat = etat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}
	public ExemplaireLivre getExemplaireLivre() {
		return exemplaireLivre;
	}
	public void setExemplaireLivre(ExemplaireLivre exemplaireLivre) {
		this.exemplaireLivre = exemplaireLivre;
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
		return "EmpruntBibliotheque [iD=" + id + ", emprunteur=" + emprunteur
				+ ", exemplaireLivre=" + exemplaireLivre + ", dateEmprunt="
				+ dateEmprunt + ", dateRetour=" + dateRetour + ", observation="
				+ observation + ", etat=" + etat + "]";
	}
}