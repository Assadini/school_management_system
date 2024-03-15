package Domaine.materiel;

import java.util.Date;

public class Reparartion {
	private int id;
	private Panne panne;
	private Date date;
	private String description;
	public Reparartion() {
		super();
	}
	public Reparartion(int id, Panne panne, Date date, String description) {
		super();
		this.id = id;
		this.panne = panne;
		this.date = date;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Panne getPanne() {
		return panne;
	}
	public void setPanne(Panne panne) {
		this.panne = panne;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Reparartion [id=" + id + ", panne=" + panne + ", date=" + date
				+ ", description=" + description + "]";
	}
}