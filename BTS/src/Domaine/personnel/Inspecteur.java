package Domaine.personnel;

import java.util.ArrayList;
import java.util.Date;

import Domaine.matiere.Matiere;

public class Inspecteur extends Personnel {
	private ArrayList<Matiere> matiere;
	private Specialite specialite;
	public Inspecteur() {
		super();
		this.matiere =  new ArrayList<Matiere>();
	}
	public Inspecteur(Specialite specialite) {
		super();
		this.matiere =  new ArrayList<Matiere>();
		this.specialite = specialite;
	}
	
	
	public Inspecteur(ArrayList<Matiere> matiere, Specialite specialite, 
			int id, String nom_Fr, String nom_Ar, String prenom_Fr,
			String prenom_Ar, String sexe, String cin, String nationalite,
			Date dateNais, String lieuNais_Fr, String lieuNais_Ar,
			String adresse_Fr, String adresse_Ar, String email,
			String situationF, String titre, String teleMobile,
			String teleDomicile, String photo) {
		super(id, nom_Fr, nom_Ar, prenom_Fr, prenom_Ar, sexe, cin, nationalite,
				dateNais, lieuNais_Fr, lieuNais_Ar, adresse_Fr, adresse_Ar, email,
				situationF, titre, teleMobile, teleDomicile, photo);
		this.matiere =  new ArrayList<Matiere>();
		this.specialite = specialite;
	}
	public ArrayList<Matiere> getMatiere() {
		return matiere;
	}
	public void setMatiere(ArrayList<Matiere> matiere) {
		this.matiere = matiere;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	@Override
	public String toString() {
		return "Inspecteur [matiere=" + matiere + ", specialite=" + specialite
				+ ", som=" + som + ", dateEmbauche=" + dateEmbauche
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