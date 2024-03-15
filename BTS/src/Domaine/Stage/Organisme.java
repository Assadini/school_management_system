package Domaine.Stage;

public class Organisme {
	private int id;
	private String nom;
	private String telephone;
	private String fax;
	private String email;
	private String site;
	private String adresse;
	private String division;
	public Organisme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Organisme(int id, String nom, String telephone, String fax,
			String email, String site, String adresse, String division) {
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.fax = fax;
		this.email = email;
		this.site = site;
		this.adresse = adresse;
		this.division = division;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "Organisme [id=" + id + ", nom=" + nom + ", telephone="
				+ telephone + ", fax=" + fax + ", email=" + email + ", site="
				+ site + ", adresse=" + adresse + ", division=" + division
				+ "]";
	}
}