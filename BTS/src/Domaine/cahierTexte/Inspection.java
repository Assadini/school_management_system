package Domaine.cahierTexte;

import java.util.Date;

import Domaine.personnel.Inspecteur;

public class Inspection {
	private int id;
	private Date date;
	private String observation;
	private String etat;
	private Inspecteur inspecteur;
	private CahierTexte cahierTexte;
	public Inspection() {
		super();
	}
	public Inspection(int id, Date date, String observation, String etat,
			Inspecteur inspecteur, CahierTexte cahierTexte) {
		super();
		this.id = id;
		this.date = date;
		this.observation = observation;
		this.etat = etat;
		this.inspecteur = inspecteur;
		this.cahierTexte = cahierTexte;
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
	public Inspecteur getInspecteur() {
		return inspecteur;
	}
	public void setInspecteur(Inspecteur inspecteur) {
		this.inspecteur = inspecteur;
	}
	public CahierTexte getCahierTexte() {
		return cahierTexte;
	}
	public void setCahierTexte(CahierTexte cahierTexte) {
		this.cahierTexte = cahierTexte;
	}
	@Override
	public String toString() {
		return "Inspection [id=" + id + ", date=" + date + ", observation="
				+ observation + ", etat=" + etat + ", inspecteur=" + inspecteur
				+ ", cahierTexte=" + cahierTexte + "]";
	}
}