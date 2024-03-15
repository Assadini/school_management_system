package Domaine.classe;

import java.util.ArrayList;
import Domaine.classe.Classe;

public class ClasseGenerique {
	private int id;
	//Attribut d�riv� non perssistant : Construit � partir du : Code Niveau + Code Cycle + Code Filiere
	private String code;
	private String description;
	private Cycle cycle;
	private Filiere filiere;
	private Niveau niveau;
	//TODO : Revoir peut etre cette association perssistante
	/*
	 * La remplacer par une association : ClasseGenerique----->Unite
	 * */
	//private ArrayList<ClasseGUnite> classeGUnite = new ArrayList<ClasseGUnite>();
	
	public ClasseGenerique() {
		super();
	}
	public ClasseGenerique(int id, String description,
			Cycle cycle, Filiere filiere, Niveau niveau) {
		super();
		this.id = id;
		this.description = description;
		this.cycle = cycle;
		this.filiere = filiere;
		this.niveau = niveau;
		this.code = this.niveau.getCode()+"-"+this.cycle.getCode()+"-"+this.filiere.getCode();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return this.code = this.niveau.getCode()+"-"+this.cycle.getCode()+"-"+this.filiere.getCode();
	}
	public void setCode() {
		this.code = this.niveau.getCode()+"-"+this.cycle.getCode()+"-"+this.filiere.getCode();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Cycle getCycle() {
		return cycle;
	}
	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	@Override
	public String toString() {
		return "ClasseGenerique [id=" + id + ", code=" + code
				+ ", description=" + description + ", filiere=" + filiere + ", niveau="
				+ niveau + "]";
	}	
}