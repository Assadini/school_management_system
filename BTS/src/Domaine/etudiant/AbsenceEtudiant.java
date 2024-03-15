package Domaine.etudiant;

import Domaine.emploiDuTemps.Seance;

public class AbsenceEtudiant {
	private int id;
	private boolean justification;
	private String motif;
	private DocJustifAbsEtudiant documentJustificatif;
	private Etudiant etudiant;
	private Seance seance;
	public AbsenceEtudiant() {
		super();
	}
	public AbsenceEtudiant(int id, boolean justification, String motif,
			DocJustifAbsEtudiant documentJustificatif, Etudiant etudiant,
			Seance seance) {
		super();
		this.id = id;
		this.justification = justification;
		this.motif = motif;
		this.documentJustificatif = documentJustificatif;
		this.etudiant = etudiant;
		this.seance = seance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isJustification() {
		return justification;
	}
	public void setJustification(boolean justification) {
		this.justification = justification;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public DocJustifAbsEtudiant getDocumentJustificatif() {
		return documentJustificatif;
	}
	public void setDocumentJustificatif(DocJustifAbsEtudiant documentJustificatif) {
		this.documentJustificatif = documentJustificatif;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	@Override
	public String toString() {
		return "AbsenceEtudiant [id=" + id + ", justification=" + justification
				+ ", motif=" + motif + ", documentJustificatif="
				+ documentJustificatif + ", etudiant=" + etudiant + ", seance="
				+ seance + "]";
	}
}