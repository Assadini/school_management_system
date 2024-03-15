package Domaine.personnel;

import java.util.ArrayList;
import java.util.Date;

import Domaine.personnel.FonctionPersonnel;
import Domaine.personnel.AbsencePersonnel;
import Domaine.personnel.DiplomePersonnel;
import Domaine.personnel.Notation;
import Domaine.personnel.AvancementPersonnel;
import Domaine.utilisateur.Utilisateur;

public class Personnel extends Utilisateur {
	protected String som;
	protected Date dateEmbauche;
	protected Date dateAffectation;
	protected short nbrEnfants;
	protected String etat;
	protected String somConjoint;
	protected String numContrat;
	protected ArrayList<FonctionPersonnel> fonctions;
	protected ArrayList<AbsencePersonnel> absences;
	protected ArrayList<DiplomePersonnel> diplomes;
	protected ArrayList<Notation> notes;
	protected SituationAdministrative situationAdministrative;
	protected Cadre cadre;
	protected Fonction fonctionActuelle;
	protected ArrayList<AvancementPersonnel> avancements;
	public Personnel() {
		super();
		this.avancements = new ArrayList<AvancementPersonnel>();
		this.fonctions = new ArrayList<FonctionPersonnel>();
		this.absences = new ArrayList<AbsencePersonnel>();
		this.diplomes = new ArrayList<DiplomePersonnel>();
		this.notes = new ArrayList<Notation>();
	}
	public Personnel(int id, String nom_Fr, String nom_Ar, String prenom_Fr,
			String prenom_Ar, String sexe, String cin, String nationalite,
			Date dateNais, String lieuNais_Fr, String lieuNais_Ar,
			String adresse_Fr, String adresse_Ar, String email,
			String situationF, String titre, String teleMobile,
			String teleDomicile, String photo) {
		super(id, nom_Fr, nom_Ar, prenom_Fr, prenom_Ar, sexe, cin, nationalite,
				dateNais, lieuNais_Fr, lieuNais_Ar, adresse_Fr, adresse_Ar, email,
				situationF, titre, teleMobile, teleDomicile, photo);
		// TODO Auto-generated constructor stub
	}
	public String getSom() {
		return som;
	}
	public void setSom(String som) {
		this.som = som;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	public short getNbrEnfants() {
		return nbrEnfants;
	}
	public void setNbrEnfants(short nbrEnfants) {
		this.nbrEnfants = nbrEnfants;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getSomConjoint() {
		return somConjoint;
	}
	public void setSomConjoint(String somConjoint) {
		this.somConjoint = somConjoint;
	}
	public String getNumContrat() {
		return numContrat;
	}
	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}
	public ArrayList<FonctionPersonnel> getFonctions() {
		return fonctions;
	}
	public void addFonction(FonctionPersonnel fonction) {
		this.fonctions.add(fonction);
	}
	public ArrayList<AbsencePersonnel> getAbsences() {
		return absences;
	}
	public void addAbsence(AbsencePersonnel absence) {
		this.absences.add(absence);
	}
	public ArrayList<DiplomePersonnel> getDiplomes() {
		return diplomes;
	}
	public void addDiplome(DiplomePersonnel diplome) {
		this.diplomes.add(diplome);
	}
	public ArrayList<Notation> getNotes() {
		return notes;
	}
	public void addNote(Notation note) {
		this.notes.add(note);
	}
	public SituationAdministrative getSituationAdministrative() {
		return situationAdministrative;
	}
	public void setSituationAdministrative(
			SituationAdministrative situationAdministrative) {
		this.situationAdministrative = situationAdministrative;
	}
	public Cadre getCadre() {
		return cadre;
	}
	public void setCadre(Cadre cadre) {
		this.cadre = cadre;
	}
	public Fonction getFonctionActuelle() {
		return fonctionActuelle;
	}
	public void setFonctionActuelle(Fonction fonctionActuelle) {
		this.fonctionActuelle = fonctionActuelle;
	}
	public ArrayList<AvancementPersonnel> getAvancements() {
		return avancements;
	}
	public void addAvancement(AvancementPersonnel avancement) {
		this.avancements.add(avancement);
	}
	@Override
	public String toString() {
		return "Personnel [som=" + som + ", dateEmbauche=" + dateEmbauche
				+ ", dateAffectation=" + dateAffectation + ", nbrEnfants="
				+ nbrEnfants + ", etat=" + etat + ", somConjoint="
				+ somConjoint + ", numContrat=" + numContrat + ", fonctions="
				+ fonctions + ", absences=" + absences + ", diplomes="
				+ diplomes + ", notes=" + notes + ", situationAdministrative="
				+ situationAdministrative + ", cadre=" + cadre
				+ ", fonctionActuelle=" + fonctionActuelle + ", avancements="
				+ avancements + ", id=" + id + ", nom_Fr=" + nom_Fr
				+ ", nom_Ar=" + nom_Ar + ", prenom_Fr=" + prenom_Fr
				+ ", prenom_Ar=" + prenom_Ar + ", sexe=" + sexe + ", cin="
				+ cin + ", nationalite=" + nationalite + ", dateNais="
				+ dateNais + ", lieuNais_Fr=" + lieuNais_Fr + ", lieuNais_Ar="
				+ lieuNais_Ar + ", adresse_Fr=" + adresse_Fr + ", adresse_Ar="
				+ adresse_Ar + ", email=" + email + ", situationF="
				+ situationF + ", titre=" + titre + ", teleMobile="
				+ teleMobile + ", teleDomicile=" + teleDomicile + ", contacts="
				+ contacts + ", comptes=" + comptes + ", photo=" + photo + "]";
	}
}