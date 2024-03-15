package Domaine.materiel;

import java.util.Date;

import Domaine.utilisateur.Utilisateur;

public class ReservationMateriel {
	private int iD;
	private Materiel materiel;
	private Utilisateur reservataire;
	private Date date;
	private String etat;
	public ReservationMateriel() {
		super();
	}
	public ReservationMateriel(int iD, Materiel materiel,
			Utilisateur reservataire, Date date, String etat) {
		super();
		this.iD = iD;
		this.materiel = materiel;
		this.reservataire = reservataire;
		this.date = date;
		this.etat = etat;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	public Utilisateur getReservataire() {
		return reservataire;
	}
	public void setReservataire(Utilisateur reservataire) {
		this.reservataire = reservataire;
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
	@Override
	public String toString() {
		return "ReservationMateriel [iD=" + iD + ", materiel=" + materiel
				+ ", reservataire=" + reservataire + ", date=" + date
				+ ", etat=" + etat + "]";
	}
}