package Domaine.bibliotheque;

import java.util.Date;

import Domaine.utilisateur.Utilisateur;

public class ReservationBibliotheque {
	private int id;
	private Date date;
	private String etat;
	private Utilisateur reservataire;
	private Livre livre;
	public ReservationBibliotheque() {
		super();
	}
	public ReservationBibliotheque(int id, Date date, String etat,
			Utilisateur reservataire, Livre livre) {
		super();
		this.id = id;
		this.date = date;
		this.etat = etat;
		this.reservataire = reservataire;
		this.livre = livre;
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
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Utilisateur getReservataire() {
		return reservataire;
	}
	public void setReservataire(Utilisateur reservataire) {
		this.reservataire = reservataire;
	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	@Override
	public String toString() {
		return "ReservationBibliotheque [id=" + id + ", date=" + date
				+ ", etat=" + etat + ", reservataire=" + reservataire
				+ ", livre=" + livre + "]";
	}
}