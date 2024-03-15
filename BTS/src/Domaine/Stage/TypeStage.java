package Domaine.Stage;

public class TypeStage {
	private int id;
	private String code;
	private String nom_Fr;
	private String nom_Ar;
	public TypeStage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeStage(int id, String code, String nom_Fr, String nom_Ar) {
		this.id = id;
		this.code = code;
		this.nom_Fr = nom_Fr;
		this.nom_Ar = nom_Ar;
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
	@Override
	public String toString() {
		return "TypeStage [id=" + id + ", code=" + code + ", nom_Fr=" + nom_Fr
				+ ", nom_Ar=" + nom_Ar + "]";
	}
	
}