package Domaine.documentAdministratif;


import Domaine.personnel.Personnel;

public class DemandeDocPersonnel extends DemandeDocument {
	private TypeDocumentPersonnel type;
	private Personnel personnel;
	public DemandeDocPersonnel() {
		super();
	}
	public TypeDocumentPersonnel getType() {
		return type;
	}
	public void setType(TypeDocumentPersonnel type) {
		this.type = type;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	@Override
	public String toString() {
		return "DemandeDocPersonnel [type=" + type + ", personnel=" + personnel
				+ ", id=" + id + ", date=" + date + ", etat=" + etat
				+ ", dateRetrait=" + dateRetrait + ", observation="
				+ observation + "]";
	}
}