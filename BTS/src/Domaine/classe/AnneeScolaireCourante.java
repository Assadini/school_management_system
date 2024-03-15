package Domaine.classe;


public class AnneeScolaireCourante {
	private int id;
	private AnneeScolaire anneeScolaire;
	
	public AnneeScolaireCourante() {
		super();
	}

	public AnneeScolaireCourante(int id, AnneeScolaire anneeScolaire) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	@Override
	public String toString() {
		return "AnneeScolaireCourante [id=" + id + ", anneeScolaire="
				+ anneeScolaire + "]";
	}
}