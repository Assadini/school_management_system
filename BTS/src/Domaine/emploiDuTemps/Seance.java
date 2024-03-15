package Domaine.emploiDuTemps;

import java.util.Date;

public class Seance {
	private int id;
	private Date date;
	private String etat;
	private String observation;
	private SeanceGenerique seanceGenerique;
	public Seance() {
		super();
	}
	public Seance(int id, Date date, String etat, String observation,
			SeanceGenerique seanceGenerique) {
		super();
		this.id = id;
		this.date = date;
		this.etat = etat;
		this.observation = observation;
		this.seanceGenerique = seanceGenerique;
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
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public SeanceGenerique getSeanceGenerique() {
		return seanceGenerique;
	}
	public void setSeanceGenerique(SeanceGenerique seanceGenerique) {
		this.seanceGenerique = seanceGenerique;
	}
	@Override
	public String toString() {
		return "Seance [id=" + id + ", date=" + date + ", etat=" + etat
				+ ", observation=" + observation + ", seanceGenerique="
				+ seanceGenerique + "]";
	}
}