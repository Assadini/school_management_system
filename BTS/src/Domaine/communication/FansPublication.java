package Domaine.communication;

import java.util.Date;

import Domaine.utilisateur.Utilisateur;

public class FansPublication {
	private int id;
	private Date date;
	private Publication publication;
	private Utilisateur fan;
	public FansPublication() {
		super();
	}
	public FansPublication(int id, Date date, Publication publication,
			Utilisateur fan) {
		super();
		this.id = id;
		this.date = date;
		this.publication = publication;
		this.fan = fan;
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
	public Publication getPublication() {
		return publication;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public Utilisateur getFan() {
		return fan;
	}
	public void setFan(Utilisateur fan) {
		this.fan = fan;
	}
	@Override
	public String toString() {
		return "FansPublication [id=" + id + ", date=" + date
				+ ", publication=" + publication + ", fan=" + fan + "]";
	}	
}