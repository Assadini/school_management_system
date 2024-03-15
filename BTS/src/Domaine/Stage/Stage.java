package Domaine.Stage;

import Domaine.classe.Classe;
import java.util.ArrayList;
import java.util.Date;

import Domaine.evaluation.Soutenance;
import Domaine.etudiant.Etudiant;
import Domaine.personnel.Professeur;

public class Stage {
	private int id;
	private Date dateDebut;
	private Date dateFin;
	private String etat;
	private String observation;
	private Classe classe;
	private RapportStage rapportStage;
	private Organisme organisme;
	private Etudiant etudiant;
	private TypeStage type;
	private Soutenance soutenance;
	private ArrayList<Professeur> tuteurs;
	private EncadrantStage encadrantStage;
	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stage(int id, Date dateDebut, Date dateFin, String etat,
			String observation, Classe classe, RapportStage rapportStage,
			Organisme organisme, Etudiant etudiant,
			TypeStage type, 
			EncadrantStage encadrantStage,Soutenance soutenance) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etat = etat;
		this.observation = observation;
		this.classe = classe;
		this.rapportStage = rapportStage;
		this.organisme = organisme;
		this.etudiant = etudiant;
		this.type = type;
		this.tuteurs = new ArrayList<Professeur>();
		this.encadrantStage = encadrantStage;
		this.soutenance=soutenance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
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
	public RapportStage getRapportStage() {
		return rapportStage;
	}
	public void setRapportStage(RapportStage rapportStage) {
		this.rapportStage = rapportStage;
	}
	public Organisme getOrganisme() {
		return organisme;
	}
	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public TypeStage getType() {
		return type;
	}
	public void setType(TypeStage type) {
		this.type = type;
	}
	public ArrayList<Professeur> getTuteurs() {
		return tuteurs;
	}
	public void addTuteurs(Professeur tuteur) {
		this.tuteurs.add(tuteur);
	}
	public EncadrantStage getEncadrantStage() {
		return encadrantStage;
	}
	public void setEncadrantStage(EncadrantStage encadrantStage) {
		this.encadrantStage = encadrantStage;
	}
	
	public Soutenance getSoutenance() {
		return soutenance;
	}
	public void setSoutenance(Soutenance soutenance) {
		this.soutenance = soutenance;
	}
	@Override
	public String toString() {
		return "Stage [id=" + id + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", etat=" + etat + ", observation=" + observation
				+ ", classe=" + classe + ", rapportStage=" + rapportStage
				+ ", organisme=" + organisme
				+ ", etudiant=" + etudiant + ", type=" + type + ", soutenance="
				+ soutenance + ", tuteurs=" + tuteurs + ", encadrantStage="
				+ encadrantStage + "]";
	}
}