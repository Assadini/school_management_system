package Domaine.matiere;

public class Module {
	private int id;
	private String code;
	private String nom_Fr;
	private String nom_Ar;
	private Matiere matiere;
	public Module() {
		super();
	}
	public Module(int id, String code, String nom_Fr, String nom_Ar, Matiere matiere) {
		super();
		this.id = id;
		this.code = code;
		this.nom_Fr = nom_Fr;
		this.nom_Ar = nom_Ar;
		this.matiere = matiere;
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
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	@Override
	public String toString() {
		return "Module [id=" + id + ", code=" + code + ", nom_Fr=" + nom_Fr
				+ ", nom_Ar=" + nom_Ar + ", matiere=" + matiere + "]";
	}
}