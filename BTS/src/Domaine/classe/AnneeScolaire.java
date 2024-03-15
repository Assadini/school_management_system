package Domaine.classe;

import java.util.Date;

public class AnneeScolaire {
	private int id;
	private String code;
	private Date dateDebut;
	private Date dateFin;
	public AnneeScolaire() {
		super();
	}
	public AnneeScolaire(int id, String code) {
		super();
		this.id = id;
		this.code = code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	@Override
	public String toString() {
		return "AnneeScolaire [id=" + id + ", code=" + code + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + "]";
	}
}