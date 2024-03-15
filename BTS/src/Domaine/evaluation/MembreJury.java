package Domaine.evaluation;

import Domaine.personnel.Professeur;

public class MembreJury {
	private int id;
	protected FonctionJury fonctionJury;
	private Soutenance soutenance;
	protected Professeur membre;
	public MembreJury() {
		super();
	}
	public MembreJury(int id, FonctionJury fonctionJury, Soutenance soutenance,
			Professeur membre) {
		super();
		this.id = id;
		this.fonctionJury = fonctionJury;
		this.soutenance = soutenance;
		this.membre = membre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FonctionJury getFonctionJury() {
		return fonctionJury;
	}
	public void setFonctionJury(FonctionJury fonctionJury) {
		this.fonctionJury = fonctionJury;
	}
	public Soutenance getSoutenance() {
		return soutenance;
	}
	public void setSoutenance(Soutenance soutenance) {
		this.soutenance = soutenance;
	}
	public Professeur getMembre() {
		return membre;
	}
	public void setMembre(Professeur membre) {
		this.membre = membre;
	}
	@Override
	public String toString() {
		return "MembreJury [id=" + id + ", fonctionJury=" + fonctionJury
				+ ", soutenance=" + soutenance + ", membre=" + membre + "]";
	}
}