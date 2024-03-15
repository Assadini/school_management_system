package Domaine.materiel;

import Domaine.locaux.Salle;
import java.util.ArrayList;
import Domaine.materiel.EmpruntMateriel;

public class ExemplaireMateriel {
	private int id;
	private String code;
	private String numInventaire;
	private String etat;
	private String description;
	private Salle affectation;
	private Materiel materiel;
	private ArrayList<EmpruntMateriel> emprunts ;
	public ExemplaireMateriel() {
		super();
	}
	public ExemplaireMateriel(int id, String code, String numInventaire,
			String etat, String description, Salle affectation,
			Materiel materiel) {
		super();
		this.id = id;
		this.code = code;
		this.numInventaire = numInventaire;
		this.etat = etat;
		this.description = description;
		this.affectation = affectation;
		this.materiel = materiel;
		this.emprunts = new ArrayList<EmpruntMateriel>();
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
	public String getNumInventaire() {
		return numInventaire;
	}
	public void setNumInventaire(String numInventaire) {
		this.numInventaire = numInventaire;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Salle getAffectation() {
		return affectation;
	}
	public void setAffectation(Salle affectation) {
		this.affectation = affectation;
	}
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	public ArrayList<EmpruntMateriel> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(ArrayList<EmpruntMateriel> emprunts) {
		this.emprunts = emprunts;
	}
	@Override
	public String toString() {
		return "ExemplaireMateriel [id=" + id + ", code=" + code
				+ ", numInventaire=" + numInventaire + ", etat=" + etat
				+ ", description=" + description + ", affectation="
				+ affectation + ", materiel=" + materiel + ", emprunts="
				+ emprunts + "]";
	}
}