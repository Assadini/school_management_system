package Domaine.Stage;

public class EncadrantStage {
	private int id;
	private String nom;
	private String prenom;
	private String fonction;
	private String email;
	private String telephone;
	public EncadrantStage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EncadrantStage(int id, String nom, String prenom, String fonction,
			String email, String telephone) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.email = email;
		this.telephone = telephone;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "EncadrantStage [id=" + id + ", nom=" + nom + ", prenom="
				+ prenom + ", fonction=" + fonction + ", email=" + email
				+ ", telephone=" + telephone + "]";
	}
}
