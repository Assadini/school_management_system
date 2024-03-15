package Domaine.projet;

import java.util.ArrayList;
import java.util.Date;

import Domaine.projet.AvancementTache;

public class Tache {
	private int id;
	private String nom;
	private Date dateDebut;
	private Date dateFin;
	private short duree;
	private String etat;
	private String description;
	private Phase phase;
	private ArrayList<AvancementTache> avancements;
	public Tache() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tache(int id, String nom, Date dateDebut, Date dateFin, short duree,
			String etat, String description, Phase phase) {
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.etat = etat;
		this.description = description;
		this.phase = phase;
		this.avancements = new ArrayList<AvancementTache>();
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
	public Phase getPhase() {
		return phase;
	}
	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	public ArrayList<AvancementTache> getAvancements() {
		return avancements;
	}
	public void addAvancement(AvancementTache avancement) {
		this.avancements.add(avancement);
	}
	@Override
	public String toString() {
		return "Tache [id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", duree=" + duree + ", etat="
				+ etat + ", description=" + description + ", phase=" + phase
				+ ", avancements=" + avancements + "]";
	}
}