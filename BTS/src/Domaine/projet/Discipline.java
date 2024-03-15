package Domaine.projet;

public class Discipline {
	private int id;
	private String code;
	private String nom;
	public Discipline() {
		super();
	}
	public Discipline(int id, String code, String nom) {
		this.id = id;
		this.code = code;
		this.nom = nom;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Discipline [id=" + id + ", code=" + code + ", nom=" + nom + "]";
	}
}