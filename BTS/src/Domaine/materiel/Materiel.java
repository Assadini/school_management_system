package Domaine.materiel;

import java.util.ArrayList;
import Domaine.materiel.ReservationMateriel;
import Domaine.materiel.Caracteristique;
import Domaine.materiel.ExemplaireMateriel;
import Domaine.materiel.DocumentMateriel;

public class Materiel {
	private int id;
	private String code;
	private TypeMateriel type;
	private String nom;
	private boolean empruntable;
	private String description;
	public ArrayList<ReservationMateriel> reservations;
	private ArrayList<Caracteristique> caracteristiques;
	private ArrayList<ExemplaireMateriel> exemplaires;
	private ArrayList<DocumentMateriel> documents;
	public Materiel() {
		super();
	}
	public Materiel(int id, String code, TypeMateriel type, String nom,
			boolean empruntable, String description) {
		super();
		this.id = id;
		this.code = code;
		this.type = type;
		this.nom = nom;
		this.empruntable = empruntable;
		this.description = description;
		this.reservations = new ArrayList<ReservationMateriel>();
		this.caracteristiques = new ArrayList<Caracteristique>();
		this.exemplaires = new ArrayList<ExemplaireMateriel>();
		this.documents = new ArrayList<DocumentMateriel>();
		
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
	public TypeMateriel getType() {
		return type;
	}
	public void setType(TypeMateriel type) {
		this.type = type;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isEmpruntable() {
		return empruntable;
	}
	public void setEmpruntable(boolean empruntable) {
		this.empruntable = empruntable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<ReservationMateriel> getReservations() {
		return reservations;
	}
	public void addReservation(ReservationMateriel reservation) {
		this.reservations.add(reservation);
	}
	public ArrayList<Caracteristique> getCaracteristiques() {
		return caracteristiques;
	}
	public void addCaracteristique(Caracteristique caracteristique) {
		this.caracteristiques.add(caracteristique);
	}
	public ArrayList<ExemplaireMateriel> getExemplaires() {
		return exemplaires;
	}
	public void addExemplaire(ExemplaireMateriel exemplaire) {
		this.exemplaires.add(exemplaire);
	}
	public ArrayList<DocumentMateriel> getDocuments() {
		return documents;
	}
	public void addDocument(DocumentMateriel document) {
		this.documents.add(document);
	}
	@Override
	public String toString() {
		return "Materiel [id=" + id + ", code=" + code + ", type=" + type
				+ ", nom=" + nom + ", empruntable=" + empruntable
				+ ", description=" + description + ", reservations="
				+ reservations + ", caracteristiques=" + caracteristiques
				+ ", exemplaires=" + exemplaires + ", documents=" + documents
				+ "]";
	}
}