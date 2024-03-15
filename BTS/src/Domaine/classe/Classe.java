package Domaine.classe;

public class Classe {
	private int id;
	private String label;
	//Attribut dérivé non perssistant : constuit à partir du : Label de le classe + Code de la classe générique
	private String code;
	private ClasseGenerique classeGenerique;
	private AnneeScolaire anneeScolaire;
	public Classe() {
		super();
	}
	public Classe(int id, String label, ClasseGenerique classeGenerique,
			AnneeScolaire anneeScolaire) {
		super();
		this.id = id;
		this.label = label;
		this.classeGenerique = classeGenerique;
		this.anneeScolaire = anneeScolaire;
		this.code = this.classeGenerique.getNiveau().getCode()+"-"+this.classeGenerique.getCycle().getCode()+"-"+this.classeGenerique.getFiliere().getCode()+"-"+this.anneeScolaire.getCode()+"-"+this.label;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCode() {
			 return this.classeGenerique.getNiveau().getCode()+"-"+this.classeGenerique.getCycle().getCode()+"-"+this.classeGenerique.getFiliere().getCode()+"-"+this.anneeScolaire.getCode()+"-"+this.label;
	}
	public void setCode() {
		this.code = this.classeGenerique.getNiveau().getCode()+"-"+this.classeGenerique.getCycle().getCode()+"-"+this.classeGenerique.getFiliere().getCode()+"-"+this.anneeScolaire.getCode()+"-"+this.label;
	}
	public ClasseGenerique getClasseGenerique() {
		return classeGenerique;
	}
	public void setClasseGenerique(ClasseGenerique classeGenerique) {
		this.classeGenerique = classeGenerique;
	}
	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}
	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}
	@Override
	public String toString() {
		return "Classe [id=" + id + ", label=" + label + ", code=" + code
				+ ", classeGenerique=" + classeGenerique + ", anneeScolaire="
				+ anneeScolaire + "]";
	}
}