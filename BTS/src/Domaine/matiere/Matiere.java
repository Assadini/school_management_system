package Domaine.matiere;

import java.util.ArrayList;
import Domaine.matiere.Module;

public class Matiere {
	private int id;
	private String code;
	private String nom_Fr;
	private String nom_Ar;
	private Unite unite;
	private ArrayList<Module> modules;
	public Matiere() {
		super();
	}
	public Matiere(int id, String code, String nom_Fr, String nom_Ar, Unite unite) {
		super();
		this.id = id;
		this.code = code;
		this.nom_Fr = nom_Fr;
		this.nom_Ar = nom_Ar;
		this.unite = unite;
		this.modules = new ArrayList<Module>();
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
	public String getNom_Fr() {
		return nom_Fr;
	}
	public void setNom_Fr(String nom_Fr) {
		this.nom_Fr = nom_Fr;
	}
	public String getNom_Ar() {
		return nom_Ar;
	}
	public void setNom_Ar(String nom_Ar) {
		this.nom_Ar = nom_Ar;
	}
	public Unite getUnite() {
		return unite;
	}
	public void setUnite(Unite unite) {
		this.unite = unite;
	}
	public ArrayList<Module> getModules() {
		return modules;
	}
	public void addModule(Module module) {
		this.modules.add(module);
	}
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", code=" + code + ", nom_Fr=" + nom_Fr
				+ ", nom_Ar=" + nom_Ar + ", unite=" + unite + ", modules=" + modules + "]";
	}
}