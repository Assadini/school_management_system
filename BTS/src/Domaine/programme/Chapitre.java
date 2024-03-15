package Domaine.programme;

import java.util.ArrayList;
import Domaine.programme.Concept;
import Domaine.matiere.Module;
import Domaine.matiere.Matiere;

public class Chapitre {
	private int id;
	private Matiere matiere;
	private Module module;
	private String nom;
	private String description;
	private ArrayList<Concept> concepts;
	public Chapitre() {
		super();
	}
	public Chapitre(int id, Matiere matiere, Module module, String nom,
			String description) {
		super();
		this.id = id;
		this.matiere = matiere;
		this.module = module;
		this.nom = nom;
		this.description = description;
		this.concepts = new ArrayList<Concept>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Concept> getConcepts() {
		return concepts;
	}
	public void addConcept(Concept concept) {
		this.concepts.add(concept);
	}
	@Override
	public String toString() {
		return "Chapitre [id=" + id + ", matiere=" + matiere + ", module="
				+ module + ", nom=" + nom + ", description=" + description
				+ ", concepts=" + concepts + "]";
	}
}