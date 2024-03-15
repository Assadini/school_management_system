package Domaine.etudiant;

import java.util.Date;

public class Avertissement {
	private int id;
	private Date date;
	private String objet;
	private String desciption;
	private Etudiant etudiant;
	public Avertissement() {
		super();
	}
	public Avertissement(int id, Date date, String objet, String desciption,
			Etudiant etudiant) {
		super();
		this.id = id;
		this.date = date;
		this.objet = objet;
		this.desciption = desciption;
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
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	@Override
	public String toString() {
		return "Avertissement [id=" + id + ", date=" + date + ", objet="
				+ objet + ", desciption=" + desciption + ", etudiant="
				+ etudiant + "]";
	}
}