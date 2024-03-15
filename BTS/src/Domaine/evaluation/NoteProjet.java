package Domaine.evaluation;

import Domaine.projet.Projet;
import Domaine.etudiant.Etudiant;

public class NoteProjet {
	private int id;
	private Projet projet;
	private Etudiant etudiant;
	private float note;
	private boolean valide;
	private String observation;
	public NoteProjet() {
		super();
	}
	public NoteProjet(int id, Projet projet, Etudiant etudiant, float note,
			boolean valide, String observation) {
		super();
		this.id = id;
		this.projet = projet;
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
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
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
		return "NoteProjet [id=" + id + ", projet=" + projet + ", etudiant="
				+ etudiant + ", note=" + note + ", valide=" + valide
				+ ", observation=" + observation + "]";
	}
}