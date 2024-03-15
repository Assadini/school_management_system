package Domaine.personnel;

import java.util.Date;

public class AvancementPersonnel {
	private int id;
	private Date date;
	private String echelle;
	private String echelon;
	private String observation;
	private Personnel personnel;
	public AvancementPersonnel() {
		super();
	}
	public AvancementPersonnel(int id, Date date, String echelle,
			String echelon, String observation, Personnel personnel) {
		this.id = id;
		this.date = date;
		this.echelle = echelle;
		this.echelon = echelon;
		this.observation = observation;
		this.personnel = personnel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEchelle() {
		return echelle;
	}
	public void setEchelle(String echelle) {
		this.echelle = echelle;
	}
	public String getEchelon() {
		return echelon;
	}
	public void setEchelon(String echelon) {
		this.echelon = echelon;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	@Override
	public String toString() {
		return "AvancementPersonnel [id=" + id + ", date=" + date
				+ ", echelle=" + echelle + ", echelon=" + echelon
				+ ", observation=" + observation + ", personnel=" + personnel
				+ "]";
	}
}