package Domaine.etudiant;

import java.util.Date;
import Domaine.utilisateur.Utilisateur;

public class Parent extends Utilisateur {
	private String lienParente;

	public Parent() {
		super();
	}

	public Parent(int id, String nom_Fr, String nom_Ar, String prenom_Fr,
			String prenom_Ar, String sexe, String cin, String nationalite,
			Date dateNais, String lieuNais_Fr, String lieuNais_Ar,
			String adresse_Fr, String adresse_Ar, String email,
			String situationF, String titre, String teleMobile,
			String teleDomicile, String photo, String lienParente) {
		super(id, nom_Fr, nom_Ar, prenom_Fr, prenom_Ar, sexe, cin, nationalite,
				dateNais, lieuNais_Fr, lieuNais_Ar, adresse_Fr, adresse_Ar, email,
				situationF, titre, teleMobile, teleDomicile, photo);
		// TODO Auto-generated constructor stub
		this.lienParente=lienParente;
	}

	public String getLienParente() {
		return lienParente;
	}

	public void setLienParente(String lienParente) {
		this.lienParente = lienParente;
	}

	@Override
	public String toString() {
		return "Parent [lienParente=" + lienParente + ", id=" + id
				+ ", nom_Fr=" + nom_Fr + ", nom_Ar=" + nom_Ar + ", prenom_Fr="
				+ prenom_Fr + ", prenom_Ar=" + prenom_Ar + ", sexe=" + sexe
				+ ", cin=" + cin + ", nationalite=" + nationalite
				+ ", dateNais=" + dateNais + ", lieuNais_Fr=" + lieuNais_Fr
				+ ", lieuNais_Ar=" + lieuNais_Ar + ", adresse_Fr=" + adresse_Fr
				+ ", adresse_Ar=" + adresse_Ar + ", email=" + email
				+ ", situationF=" + situationF + ", titre=" + titre
				+ ", teleMobile=" + teleMobile + ", teleDomicile="
				+ teleDomicile + ", contacts=" + contacts + "]";
	}	
}