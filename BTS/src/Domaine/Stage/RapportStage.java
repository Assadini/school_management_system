package Domaine.Stage;

import java.util.Date;

import Domaine.document.Document;

public class RapportStage extends Document {
	private Stage stage;

	public RapportStage() {
		super();
	}

	public RapportStage(int id, String code, String nom, String emplacement,
			String type, long taille, Date dateUpload) {
		super(id, code, nom, emplacement, type, taille, dateUpload);
		// TODO Auto-generated constructor stub
	}

	public RapportStage(Stage stage) {
		this.stage = stage;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	@Override
	public String toString() {
		return "RapportStage [stage=" + stage + ", id=" + id + ", code=" + code
				+ ", nom=" + nom + ", emplacement=" + emplacement + ", type="
				+ type + ", taille=" + taille + ", dateUpload=" + dateUpload
				+ "]";
	}
}