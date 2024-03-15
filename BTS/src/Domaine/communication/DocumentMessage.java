package Domaine.communication;

import Domaine.document.Document;

public class DocumentMessage extends Document {
	private Message message;
	public DocumentMessage() {
		super();
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
}