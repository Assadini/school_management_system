package Domaine.documentAdministratif;

import java.util.Date;

public class DemandeDocument {
	protected int id;
	protected Date date;
	protected String etat;
	protected Date dateRetrait;
	protected String observation;
	public DemandeDocument() {
		super();
	}
	public DemandeDocument(int id, Date date, String etat,
			String observation) {
		super();
		this.id = id;
		this.date = date;
		this.etat = etat;
		this.observation = observation;
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
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDateRetrait() {
		return dateRetrait;
	}
	public void setDateRetrait(Date dateRetrait) {
		this.dateRetrait = dateRetrait;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	@Override
	public String toString() {
		return "DemandeDocument [id=" + id + ", date=" + date + ", etat="
				+ etat + ", dateRetrait=" + dateRetrait + ", observation="
				+ observation + "]";
	}
}