package Domaine.personnel;

public class DiplomePersonnel {
	private int id;
	private String annee;
	private String etablissement;
	private Specialite specialite;
	protected Personnel personnel;
	protected Diplome diplome;
	public DiplomePersonnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiplomePersonnel(int id, String annee, String etablissement,
			Specialite specialite, Personnel personnel, Diplome diplome) {
		this.id = id;
		this.annee = annee;
		this.etablissement = etablissement;
		this.specialite = specialite;
		this.personnel = personnel;
		this.diplome = diplome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public Diplome getDiplome() {
		return diplome;
	}
	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}
	@Override
	public String toString() {
		return "DiplomePersonnel [id=" + id + ", annee=" + annee
				+ ", etablissement=" + etablissement + ", specialite="
				+ specialite + ", personnel=" + personnel + ", diplome="
				+ diplome + "]";
	}
}