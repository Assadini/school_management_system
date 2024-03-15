package Domaine.personnel;

public class Cadre {
	private int id;
	private String Code;
	private String nom_Fr;
	private String nom_Ar;
	public Cadre() {
		super();
	}
	public Cadre(int id, String code, String nom_Fr, String nom_Ar) {
		this.id = id;
		Code = code;
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
		return Code;
	}
	public void setCode(String code) {
		Code = code;
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
		return "Cadre [id=" + id + ", Code=" + Code + ", nom_Fr=" + nom_Fr
				+ ", nom_Ar=" + nom_Ar + "]";
	}
}