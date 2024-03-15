package Domaine.reproductionDocument;

import java.util.Date;

import Domaine.document.Document;

public class DocumentPhotocopie extends Document {
	private DemandePhotocopie demandePhotocopie;
	public DocumentPhotocopie() {
		super();
	}

	public DocumentPhotocopie(int id, String code, String nom,
			String emplacement, String type, long taille, Date dateUpload) {
		super(id, code, nom, emplacement, type, taille, dateUpload);
	}
	
	public DemandePhotocopie getDemandePhotocopie() {
		return demandePhotocopie;
	}

	public void setDemandePhotocopie(DemandePhotocopie demandePhotocopie) {
		this.demandePhotocopie = demandePhotocopie;
	}

	@Override
	public String toString() {
		return "DocumentPhotocopie [id=" + id + ", code=" + code + ", nom="
				+ nom + ", emplacement=" + emplacement + ", type=" + type
				+ ", taille=" + taille + ", dateUpload=" + dateUpload + "]";
	}
}