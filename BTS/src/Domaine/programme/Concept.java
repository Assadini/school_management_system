package Domaine.programme;

public class Concept {
	private int id;
	private String nom;
	private String description;
	private Chapitre chapitre;
	public Concept() {
		super();
	}
	public Concept(int id, String nom, String description, Chapitre chapitre) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.chapitre = chapitre;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Chapitre getChapitre() {
		return chapitre;
	}
	public void setChapitre(Chapitre chapitre) {
		this.chapitre = chapitre;
	}
	@Override
	public String toString() {
		return "Concept [id=" + id + ", nom=" + nom + ", description="
				+ description + ", chapitre=" + chapitre + "]";
	}
}