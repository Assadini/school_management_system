package Domaine.etudiant;

import java.util.Date;

public class Engagement {
	private int id;
	private Date date;
	private String objet;
	private String description;
	private Etudiant etudiant;
	public Engagement() {
		super();
	}
	public Engagement(int id, Date date, String objet, String description,
			Etudiant etudiant) {
		super();
		this.id = id;
		this.date = date;
		this.objet = objet;
		this.description = description;
		this.etudiant = etudiant;
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
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	@Override
	public String toString() {
		return "Engagement [id=" + id + ", date=" + date + ", objet=" + objet
				+ ", description=" + description + ", etudiant=" + etudiant
				+ "]";
	}
}