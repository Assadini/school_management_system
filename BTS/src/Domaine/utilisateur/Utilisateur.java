package Domaine.utilisateur;

import java.util.ArrayList;
import java.util.Date;

import Domaine.communication.Contact;
import Domaine.securite.Compte;

public class Utilisateur {
	protected int id;
	protected String nom_Fr;
	protected String nom_Ar;
	protected String prenom_Fr;
	protected String prenom_Ar;
	protected String sexe;
	protected String cin;
	protected String nationalite;
	protected Date dateNais;
	protected String lieuNais_Fr;
	protected String lieuNais_Ar;
	protected String adresse_Fr;
	protected String adresse_Ar;
	protected String email;
	protected String situationF;
	protected String titre;
	protected String teleMobile;
	protected String teleDomicile;
	protected ArrayList<Contact> contacts ;
	protected ArrayList<Compte> comptes ;
	protected String photo;
	public Utilisateur() {
		super();
		this.contacts = new ArrayList<Contact>();
		this.comptes = new ArrayList<Compte>();
	}
	public Utilisateur(int id, String nom_Fr, String nom_Ar, String prenom_Fr,
			String prenom_Ar, String sexe, String cin, String nationalite,
			Date dateNais, String lieuNais_Fr, String lieuNais_Ar,
			String adresse_Fr, String adresse_Ar, String email,
			String situationF, String titre, String teleMobile,
			String teleDomicile, String photo) {
		super();
		this.id = id;
		this.nom_Fr = nom_Fr;
		this.nom_Ar = nom_Ar;
		this.prenom_Fr = prenom_Fr;
		this.prenom_Ar = prenom_Ar;
		this.sexe = sexe;
		this.cin = cin;
		this.nationalite = nationalite;
		this.dateNais = dateNais;
		this.lieuNais_Fr = lieuNais_Fr;
		this.lieuNais_Ar = lieuNais_Ar;
		this.adresse_Fr = adresse_Fr;
		this.adresse_Ar = adresse_Ar;
		this.email = email;
		this.situationF = situationF;
		this.titre = titre;
		this.teleMobile = teleMobile;
		this.teleDomicile = teleDomicile;
		this.photo = photo;
		//Initialiser les Contacts et les Comptes a null lors de la création d'un Utilisateur
		this.contacts = null;
		this.comptes = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_Fr() {
		return nom_Fr;
	}
	public void setNom_Fr(String nom_Fr) {
		this.nom_Fr = nom_Fr;
	}
	public String getNom_Ar() {
		return nom_Ar;
	}
	public void setNom_Ar(String nom_Ar) {
		this.nom_Ar = nom_Ar;
	}
	public String getPrenom_Fr() {
		return prenom_Fr;
	}
	public void setPrenom_Fr(String prenom_Fr) {
		this.prenom_Fr = prenom_Fr;
	}
	public String getPrenom_Ar() {
		return prenom_Ar;
	}
	public void setPrenom_Ar(String prenom_Ar) {
		this.prenom_Ar = prenom_Ar;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public Date getDateNais() {
		return dateNais;
	}
	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}
	public String getLieuNais_Fr() {
		return lieuNais_Fr;
	}
	public void setLieuNais_Fr(String lieuNais_Fr) {
		this.lieuNais_Fr = lieuNais_Fr;
	}
	public String getLieuNais_Ar() {
		return lieuNais_Ar;
	}
	public void setLieuNais_Ar(String lieuNais_Ar) {
		this.lieuNais_Ar = lieuNais_Ar;
	}
	public String getAdresse_Fr() {
		return adresse_Fr;
	}
	public void setAdresse_Fr(String adresse_Fr) {
		this.adresse_Fr = adresse_Fr;
	}
	public String getAdresse_Ar() {
		return adresse_Ar;
	}
	public void setAdresse_Ar(String adresse_Ar) {
		this.adresse_Ar = adresse_Ar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSituationF() {
		return situationF;
	}
	public void setSituationF(String situationF) {
		this.situationF = situationF;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTeleMobile() {
		return teleMobile;
	}
	public void setTeleMobile(String teleMobile) {
		this.teleMobile = teleMobile;
	}
	public String getTeleDomicile() {
		return teleDomicile;
	}
	public void setTeleDomicile(String teleDomicile) {
		this.teleDomicile = teleDomicile;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public ArrayList<Contact> getContacts() {
		return contacts;
	}
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}
	public ArrayList<Compte> getComptes() {
		return comptes;
	}
	public void addCompte(Compte compte) {
		this.comptes.add(compte);
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom_Fr=" + nom_Fr + ", nom_Ar="
				+ nom_Ar + ", prenom_Fr=" + prenom_Fr + ", prenom_Ar="
				+ prenom_Ar + ", sexe=" + sexe + ", cin=" + cin
				+ ", nationalite=" + nationalite + ", dateNais=" + dateNais
				+ ", lieuNais_Fr=" + lieuNais_Fr + ", lieuNais_Ar="
				+ lieuNais_Ar + ", adresse_Fr=" + adresse_Fr + ", adresse_Ar="
				+ adresse_Ar + ", email=" + email + ", situationF="
				+ situationF + ", titre=" + titre + ", teleMobile="
				+ teleMobile + ", teleDomicile=" + teleDomicile + ", contacts="
				+ contacts + ", comptes=" + comptes + ", photo=" + photo + "]";
	}
	
}