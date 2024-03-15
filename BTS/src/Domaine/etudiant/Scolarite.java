package Domaine.etudiant;

import java.util.Date;

import Domaine.classe.Classe;

public class Scolarite {
	private int id;
	private Etudiant etudiant;
	private Classe classe;
	private Date dateInscription;
	private String etat;
	private String decisionFinAnnee;
	private float moyenne;
	private Mention mention;
	private String observation;
	public Scolarite() {
		super();
	}
	public Scolarite(int id, Etudiant etudiant, Classe classe,
			Date dateInscription, String etat, String decisionFinAnnee,
			float moyenne, Mention mention, String observation) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.classe = classe;
		this.dateInscription = dateInscription;
		this.etat = etat;
		this.decisionFinAnnee = decisionFinAnnee;
		this.moyenne = moyenne;
		this.mention = mention;
		this.observation = observation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDecisionFinAnnee() {
		return decisionFinAnnee;
	}
	public void setDecisionFinAnnee(String decisionFinAnnee) {
		this.decisionFinAnnee = decisionFinAnnee;
	}
	public float getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}
	public Mention getMention() {
		return mention;
	}
	public void setMention(Mention mention) {
		this.mention = mention;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	@Override
	public String toString() {
		return "Scolarite [id=" + id + ", etudiant=" + etudiant + ", classe="
				+ classe + ", dateInscription=" + dateInscription + ", etat="
				+ etat + ", decisionFinAnnee=" + decisionFinAnnee
				+ ", moyenne=" + moyenne + ", mention=" + mention
				+ ", observation=" + observation + "]";
	}
}