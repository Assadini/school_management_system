package Domaine.personnel;

public class Diplome {
	private int iD;
	private String code;
	private String nom_Fr;
	private String nom_Ar;
	private TypeDiplome type;
	public Diplome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Diplome(int iD, String code, String nom_Fr, String nom_Ar, TypeDiplome type) {
		this.iD = iD;
		this.code = code;
		this.nom_Fr = nom_Fr;
		this.nom_Ar = nom_Ar;
		this.type = type;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
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
	public TypeDiplome getType() {
		return type;
	}
	public void setType(TypeDiplome type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Diplome [iD=" + iD + ", code=" + code + ", nom_Fr=" + nom_Fr
				+ ", nom_Ar=" + nom_Ar + ", type=" + type + "]";
	}
}