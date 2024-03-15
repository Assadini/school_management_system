package Domaine.bibliotheque;

import java.util.ArrayList;
import Domaine.bibliotheque.ReservationBibliotheque;
import Domaine.bibliotheque.ExemplaireLivre;

public class Livre {
	private int id;
	private String isbn;
	private String titre;
	private String auteur;
	private String maisonEdit;
	private String emplacement;
	private String description;
	private boolean empruntable;
	private DomaineLivre domaine;
	public ArrayList<ReservationBibliotheque> reservations = new ArrayList<ReservationBibliotheque>();
	private ArrayList<ExemplaireLivre> exemplaires = new ArrayList<ExemplaireLivre>();
	private CouvertureLivre couverture;
	public Livre() {
		super();
	}
	public Livre(int id, String isbn, String titre, String auteur,
			String maisonEdit, String emplacement, String description,
			boolean empruntable, DomaineLivre domaine,
			CouvertureLivre couverture) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titre = titre;
		this.auteur = auteur;
		this.maisonEdit = maisonEdit;
		this.emplacement = emplacement;
		this.description = description;
		this.empruntable = empruntable;
		this.domaine = domaine;
		this.couverture = couverture;
		//Initialier la liste des exemplaires d'un live à NULL lors de sa création
		this.exemplaires=null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getMaisonEdit() {
		return maisonEdit;
	}
	public void setMaisonEdit(String maisonEdit) {
		this.maisonEdit = maisonEdit;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isEmpruntable() {
		return empruntable;
	}
	public void setEmpruntable(boolean empruntable) {
		this.empruntable = empruntable;
	}
	public DomaineLivre getDomaine() {
		return domaine;
	}
	public void setDomaine(DomaineLivre domaine) {
		this.domaine = domaine;
	}
	public ArrayList<ReservationBibliotheque> getReservation() {
		return reservations;
	}
	/*
	 * Ajouter une reservation
	 */
	public void addReservation(ReservationBibliotheque reservation) {
		this.reservations.add(reservation);
	}
	public ArrayList<ExemplaireLivre> getExemplaires() {
		return exemplaires;
	}
	/*
	 * Ajouter un exemplaire
	 */
	public void addExemplaires(ExemplaireLivre exemplaire) {
		this.exemplaires.add(exemplaire);
	}
	public CouvertureLivre getCouverture() {
		return couverture;
	}
	public void setCouverture(CouvertureLivre couverture) {
		this.couverture = couverture;
	}
	@Override
	public String toString() {
		return "Livre [iD=" + id + ", isbn=" + isbn + ", titre=" + titre
				+ ", auteur=" + auteur + ", maisonEdit=" + maisonEdit
				+ ", emplacement=" + emplacement + ", description="
				+ description + ", empruntable=" + empruntable + ", domaine="
				+ domaine + ", reservation=" + reservations + ", exemplaires="
				+ exemplaires + ", couverture=" + couverture + "]";
	}
}