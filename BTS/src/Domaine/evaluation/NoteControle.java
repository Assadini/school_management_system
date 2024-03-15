package Domaine.evaluation;

import Domaine.etudiant.Etudiant;

public class NoteControle {
	private int id;
	private Controle controle;
	private Etudiant etudiant;
	private float note;
	private boolean valide;
	private String observation;
	
	public NoteControle() {
		super();
	}

	public NoteControle(int id, Controle controle, Etudiant etudiant,
			float note, boolean valide, String observation) {
		super();
		this.id = id;
		this.controle = controle;
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

	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
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
		return "NoteControle [id=" + id + ", controle=" + controle
				+ ", etudiant=" + etudiant + ", note=" + note + ", valide="
				+ valide + ", observation=" + observation + "]";
	}	
}