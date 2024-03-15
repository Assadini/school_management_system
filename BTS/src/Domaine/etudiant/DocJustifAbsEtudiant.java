package Domaine.etudiant;

import java.util.Date;

import Domaine.document.Document;

public class DocJustifAbsEtudiant extends Document {
	private Date dateDepot;
	private Date dateDebut;
	private Date dateFin;
	private String observation;
	public DocJustifAbsEtudiant() {
		super();
	}
	public DocJustifAbsEtudiant(int id, String code, String nom,
			String emplacement, String type, long taille, Date dateUpload,
			Date dateDepot, Date dateDebut, Date dateFin,String observation ) {
		super(id, code, nom, emplacement, type, taille, dateUpload);
		// TODO Auto-generated constructor stub
		this.dateDepot=dateDepot;
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.observation=observation;
	}
	
	
	public Date getDateDepot() {
		return dateDepot;
	}
	
	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	@Override
	public String toString() {
		return "DocJustifAbsEtudiant [dateDepot=" + dateDepot + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", observation="
				+ observation + ", id=" + id + ", code=" + code + ", nom="
				+ nom + ", emplacement=" + emplacement + ", type=" + type
				+ ", taille=" + taille + ", dateUpload=" + dateUpload + "]";
	}
}