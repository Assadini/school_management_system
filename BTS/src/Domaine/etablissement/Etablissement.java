package Domaine.etablissement;

public class Etablissement {
	private int id;
	private String code;
	private String nom_Fr;
	private String nom_Ar;
	private String telephone;
	private String email;
	private String adresse_Fr;
	private String adresse_Ar;
	private Province province;
	public Etablissement() {
		super();
	}
	public Etablissement(int id, String code, String nom_Fr, String nom_Ar,
			String telephone, String email, String adresse_Fr,
			String adresse_Ar, Province province) {
		super();
		this.id = id;
		this.code = code;
		this.nom_Fr = nom_Fr;
		this.nom_Ar = nom_Ar;
		this.telephone = telephone;
		this.email = email;
		this.adresse_Fr = adresse_Fr;
		this.adresse_Ar = adresse_Ar;
		this.province = province;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse_Fr() {
		return adresse_Fr;
	}
	public void setAdresse_Fr(String adresse_Fr) {
		this.adresse_Fr = adresse_Fr;
	}
	public String getAdresse_Ar() {
		return adresse_Ar;
	}
	public void setAdresse_Ar(String adresse_Ar) {
		this.adresse_Ar = adresse_Ar;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Etablissement [id=" + id + ", code=" + code + ", nom_Fr="
				+ nom_Fr + ", nom_Ar=" + nom_Ar + ", telephone=" + telephone
				+ ", email=" + email + ", adresse_Fr=" + adresse_Fr
				+ ", adresse_Ar=" + adresse_Ar + ", province=" + province + "]";
	}
}