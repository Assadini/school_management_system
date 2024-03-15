package Domaine.communication;

import Domaine.document.Document;

public class DocumentAnnonce extends Document {
	private Annonce annonce;
	public DocumentAnnonce() {
		super();
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
}