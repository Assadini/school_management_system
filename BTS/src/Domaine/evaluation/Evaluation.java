package Domaine.evaluation;

import java.util.Date;

import Domaine.classe.Classe;
import Domaine.locaux.Salle;
import Domaine.matiere.Matiere;
import Domaine.personnel.Professeur;

public class Evaluation {
	protected int id;
	protected String code;
	protected Classe classe;
	protected Matiere matiere;
	protected String description;
	protected FormeEvaluation formeEvaluation;
	protected short duree;
	protected Salle salle;
	protected Date datePlanifiee;
	protected Date datePassage;
	protected Date dateDepotNotes;
	protected Professeur professeur;
	protected String etat;
	protected String observation;
	protected DocumentEvaluation sujet;
	protected DocumentEvaluation corrige;
	
	public Evaluation() {
		super();
	}

	public Evaluation(int id, String code, Classe classe, Matiere matiere,
			String description, FormeEvaluation formeEvaluation, short duree,
			Salle salle, Date datePlanifiee, Date datePassage,
			Date dateDepotNotes, Professeur professeur, String etat,
			String observation, DocumentEvaluation sujet,
			DocumentEvaluation corrige) {
		super();
		//TODO : Initialier à Null les attributs non disponibles lors de la création
		this.id = id;
		this.code = code;
		this.classe = classe;
		this.matiere = matiere;
		this.description = description;
		this.formeEvaluation = formeEvaluation;
		this.duree = duree;
		this.salle = salle;
		this.datePlanifiee = datePlanifiee;
		this.datePassage = datePassage;
		this.dateDepotNotes = dateDepotNotes;
		this.professeur = professeur;
		this.etat = etat;
		this.observation = observation;
		this.sujet = sujet;
		this.corrige = corrige;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FormeEvaluation getFormeEvaluation() {
		return formeEvaluation;
	}

	public void setFormeEvaluation(FormeEvaluation formeEvaluation) {
		this.formeEvaluation = formeEvaluation;
	}

	public short getDuree() {
		return duree;
	}

	public void setDuree(short duree) {
		this.duree = duree;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Date getDatePlanifiee() {
		return datePlanifiee;
	}

	public void setDatePlanifiee(Date datePlanifiee) {
		this.datePlanifiee = datePlanifiee;
	}

	public Date getDatePassage() {
		return datePassage;
	}

	public void setDatePassage(Date datePassage) {
		this.datePassage = datePassage;
	}

	public Date getDateDepotNotes() {
		return dateDepotNotes;
	}

	public void setDateDepotNotes(Date dateDepotNotes) {
		this.dateDepotNotes = dateDepotNotes;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
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

	public DocumentEvaluation getSujet() {
		return sujet;
	}

	public void setSujet(DocumentEvaluation sujet) {
		this.sujet = sujet;
	}

	public DocumentEvaluation getCorrige() {
		return corrige;
	}

	public void setCorrige(DocumentEvaluation corrige) {
		this.corrige = corrige;
	}

	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", code=" + code + ", classe=" + classe
				+ ", matiere=" + matiere + ", description=" + description
				+ ", formeEvaluation=" + formeEvaluation + ", duree=" + duree
				+ ", salle=" + salle + ", datePlanifiee=" + datePlanifiee
				+ ", datePassage=" + datePassage + ", dateDepotNotes="
				+ dateDepotNotes + ", professeur=" + professeur + ", etat="
				+ etat + ", observation=" + observation + ", sujet=" + sujet
				+ ", corrige=" + corrige + "]";
	}
}