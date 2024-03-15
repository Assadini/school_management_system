package Domaine.communication;

import Domaine.document.Document;

public class DocumentPublication extends Document {
	private Publication publication;
	public DocumentPublication() {
		super();
	}
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
}