package Domaine.matiere;

import java.util.ArrayList;
import Domaine.classe.ClasseGenerique;

public class ClasseGUnite {
	private int id;
	private ClasseGenerique classeGenerique;
	private Unite unite;
	private float noteEliminatoire;
	public ArrayList<ConfigurationMatiere> configurationMatieres;
	public ClasseGUnite() {
		super();
		this.configurationMatieres =new ArrayList<ConfigurationMatiere>();
	}
	public ClasseGUnite(int id, ClasseGenerique classeGenerique, Unite unite,
			float noteEliminatoire) {
		super();
		this.id = id;
		this.classeGenerique = classeGenerique;
		this.unite = unite;
		this.noteEliminatoire = noteEliminatoire;
		this.configurationMatieres =new ArrayList<ConfigurationMatiere>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ClasseGenerique getClasseGenerique() {
		return classeGenerique;
	}
	public void setClasseGenerique(ClasseGenerique classeGenerique) {
		this.classeGenerique = classeGenerique;
	}
	public Unite getUnite() {
		return unite;
	}
	public void setUnite(Unite unite) {
		this.unite = unite;
	}
	public float getNoteEliminatoire() {
		return noteEliminatoire;
	}
	public void setNoteEliminatoire(float noteEliminatoire) {
		this.noteEliminatoire = noteEliminatoire;
	}
	public ArrayList<ConfigurationMatiere> getConfigurationMatieres() {
		return configurationMatieres;
	}
	public void addConfigurationMatiere(ConfigurationMatiere configurationMatiere) {
		this.configurationMatieres.add(configurationMatiere);
	}
	@Override
	public String toString() {
		return "ClasseGUnite [id=" + id + ", classeGenerique="
				+ classeGenerique + ", unite=" + unite + ", noteEliminatoire="
				+ noteEliminatoire + ", configurationMatieres="
				+ configurationMatieres + "]";
	}
}