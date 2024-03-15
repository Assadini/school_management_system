package Domaine.projet;

import Domaine.classe.Classe;
import java.util.ArrayList;
import java.util.Date;

import Domaine.personnel.Professeur;
import Domaine.evaluation.Soutenance;
import Domaine.projet.Phase;
import Domaine.etudiant.Etudiant;
import Domaine.projet.Jalon;

public class Projet {
	private int iD;
	private String code;
	private String titre;
	private Date dateDebut;
	private Date dateFin;
	private String description;
	private Classe classe;
	private ArrayList<Professeur> encadrants;
	private Soutenance soutenance;
	private ArrayList<Phase> phases;
	private ArrayList<Etudiant> etudiant;
	private ArrayList<Jalon> jalons;
	private RapportProjet rapportProjet;
	private CahierChargeProjet cahierCharge;
	private Discipline discipline;
	
	public Projet() {
		super();
	}

	public Projet(int iD, String code, String titre, Date dateDebut,
			Date dateFin, String description, Classe classe,
			Soutenance soutenance,
			RapportProjet rapportProjet,
			CahierChargeProjet cahierCharge, Discipline discipline) {
		this.iD = iD;
		this.code = code;
		this.titre = titre;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
		this.classe = classe;
		this.encadrants = new ArrayList<Professeur>();
		this.soutenance = soutenance;
		this.phases = new ArrayList<Phase>();
		this.etudiant = new ArrayList<Etudiant>();
		this.jalons = new ArrayList<Jalon>();
		this.rapportProjet = rapportProjet;
		this.cahierCharge = cahierCharge;
		this.discipline = discipline;
		// TODO Auto-generated constructor stub
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public ArrayList<Professeur> getEncadrants() {
		return encadrants;
	}

	public void setEncadrants(ArrayList<Professeur> encadrants) {
		this.encadrants = encadrants;
	}

	public Soutenance getSoutenance() {
		return soutenance;
	}

	public void setSoutenance(Soutenance soutenance) {
		this.soutenance = soutenance;
	}

	public ArrayList<Phase> getPhases() {
		return phases;
	}

	public void setPhases(ArrayList<Phase> phases) {
		this.phases = phases;
	}

	public ArrayList<Etudiant> getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(ArrayList<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}

	public ArrayList<Jalon> getJalons() {
		return jalons;
	}

	public void setJalons(ArrayList<Jalon> jalons) {
		this.jalons = jalons;
	}

	public RapportProjet getRapportProjet() {
		return rapportProjet;
	}

	public void setRapportProjet(RapportProjet rapportProjet) {
		this.rapportProjet = rapportProjet;
	}

	public CahierChargeProjet getCahierCharge() {
		return cahierCharge;
	}

	public void setCahierCharge(CahierChargeProjet cahierCharge) {
		this.cahierCharge = cahierCharge;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	@Override
	public String toString() {
		return "Projet [iD=" + iD + ", code=" + code + ", titre=" + titre
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", description=" + description + ", classe=" + classe
				+ ", encadrants=" + encadrants + ", soutenance=" + soutenance
				+ ", phases=" + phases + ", etudiant=" + etudiant + ", jalons="
				+ jalons + ", rapportProjet=" + rapportProjet
				+ ", cahierCharge=" + cahierCharge + ", discipline="
				+ discipline + "]";
	}
}