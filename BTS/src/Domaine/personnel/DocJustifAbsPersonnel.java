package Domaine.personnel;

import java.util.Date;

import Domaine.document.Document;

public class DocJustifAbsPersonnel extends Document {
	private Date dateDepot;
	private String observation;
	public DocJustifAbsPersonnel() {
		super();
	}
	public DocJustifAbsPersonnel(Date dateDepot, String observation ,int id, String code, String nom,
			String emplacement, String type, long taille, Date dateUpload) {
		super(id, code, nom, emplacement, type, taille, dateUpload);
		// TODO Auto-generated constructor stub
		this.dateDepot = dateDepot;
		this.observation = observation;
	}
	public Date getDateDepot() {
		return dateDepot;
	}
	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	@Override
	public String toString() {
		return "DocJustifAbsPersonnel [dateDepot=" + dateDepot
				+ ", observation=" + observation + ", id=" + id + ", code="
				+ code + ", nom=" + nom + ", emplacement=" + emplacement
				+ ", type=" + type + ", taille=" + taille + ", dateUpload="
				+ dateUpload + "]";
	}
}