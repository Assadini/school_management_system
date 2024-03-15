package Domaine.projet;

import java.util.Date;

public class AvancementTache {
	private int id;
	private Date date;
	private short tempsPasse;
	private short tempsRestant;
	//Attribut dérivé non perssistant claculer en fonction du Temps Passé et du Temps Restant
	private short avancement;
	private String observation;
	private Tache tache;
	public AvancementTache() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AvancementTache(int id, Date date, short tempsPasse,
			short tempsRestant, String observation,
			Tache tache) {
		this.id = id;
		this.date = date;
		this.tempsPasse = tempsPasse;
		this.tempsRestant = tempsRestant;
		//TODO : Claculer en fonction du Temps Passé et du Temps Restant
		this.avancement = 0;
		this.observation = observation;
		this.tache = tache;
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
	public short getTempsPasse() {
		return tempsPasse;
	}
	public void setTempsPasse(short tempsPasse) {
		this.tempsPasse = tempsPasse;
	}
	public short getTempsRestant() {
		return tempsRestant;
	}
	public void setTempsRestant(short tempsRestant) {
		this.tempsRestant = tempsRestant;
	}
	public short getAvancement() {
		return avancement;
	}
	public void setAvancement(short avancement) {
		//TODO : Claculer en fonction du Temps Passé et du Temps Restant
		this.avancement = avancement;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	@Override
	public String toString() {
		return "AvancementTache [id=" + id + ", date=" + date + ", tempsPasse="
				+ tempsPasse + ", tempsRestant=" + tempsRestant
				+ ", avancement=" + avancement + ", observation=" + observation
				+ ", tache=" + tache + "]";
	}
}