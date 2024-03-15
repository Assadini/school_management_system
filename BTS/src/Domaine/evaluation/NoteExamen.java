package Domaine.evaluation;

import Domaine.etudiant.Etudiant;

public class NoteExamen {
	private int id;
	private Examen examen;
	private Etudiant etudiant;
	private float note;
	private boolean valide;
	private String observation;
	public NoteExamen() {
		super();
	}
	public NoteExamen(int id, Examen examen, Etudiant etudiant, float note,
			boolean valide, String observation) {
		super();
		this.id = id;
		this.examen = examen;
		this.etudiant = etudiant;
		this.note = note;
		this.valide = valide;
		this.observation = observation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Examen getExamen() {
		return examen;
	}
	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	@Override
	public String toString() {
		return "NoteExamen [id=" + id + ", examen=" + examen + ", etudiant="
				+ etudiant + ", note=" + note + ", valide=" + valide
				+ ", observation=" + observation + "]";
	}
}