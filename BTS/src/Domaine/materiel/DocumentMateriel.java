package Domaine.materiel;

import java.util.Date;

import Domaine.document.Document;

public class DocumentMateriel extends Document {
	private Materiel materiel;

	public DocumentMateriel() {
		super();
	}

	public DocumentMateriel(int id, String code, String nom,
			String emplacement, String type, long taille, Date dateUpload,Materiel materiel) {
		super(id, code, nom, emplacement, type, taille, dateUpload);
		// TODO Auto-generated constructor stub
		this.materiel=materiel;
	}

	public DocumentMateriel(Materiel materiel) {
		super();
		this.materiel = materiel;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	@Override
	public String toString() {
		return "DocumentMateriel [materiel=" + materiel + ", id=" + id
				+ ", code=" + code + ", nom=" + nom + ", emplacement="
				+ emplacement + ", type=" + type + ", taille=" + taille
				+ ", dateUpload=" + dateUpload + "]";
	}
}