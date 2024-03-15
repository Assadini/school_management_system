package Domaine.personnel;

import Domaine.emploiDuTemps.Seance;

public class AbsenceProfesseur {
	private int id;
	private boolean justification;
	private String motif;
	private DocJustifAbsPersonnel documentJustificatif;
	private Seance seance;
	private Professeur professeur;
	public AbsenceProfesseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AbsenceProfesseur(int id, boolean justification, String motif,
			DocJustifAbsPersonnel documentJustificatif, Seance seance,
			Professeur professeur) {
		this.id = id;
		this.justification = justification;
		this.motif = motif;
		this.documentJustificatif = documentJustificatif;
		this.seance = seance;
		this.professeur = professeur;
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
	public DocJustifAbsPersonnel getDocumentJustificatif() {
		return documentJustificatif;
	}
	public void setDocumentJustificatif(DocJustifAbsPersonnel documentJustificatif) {
		this.documentJustificatif = documentJustificatif;
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}	
}