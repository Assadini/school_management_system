package Domaine.personnel;

public class Notation {
	private int id;
	private float note;
	private String annee;
	private String observation;
	private TypeNote type;
	private Personnel personnel;
	public Notation() {
		super();
	}
	public Notation(int id, float note, String annee, String observation,
			TypeNote type, Personnel personnel ) {
		this.id = id;
		this.note = note;
		this.annee = annee;
		this.observation = observation;
		this.type = type;
		this.personnel= personnel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public TypeNote getType() {
		return type;
	}
	public void setType(TypeNote type) {
		this.type = type;
	}
	
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	@Override
	public String toString() {
		return "Notation [id=" + id + ", note=" + note + ", annee=" + annee
				+ ", observation=" + observation + ", type=" + type + ", personnel=" + personnel+ "]";
	}
}