package Domaine.cahierTexte;

import java.util.ArrayList;
import Domaine.cahierTexte.AcrivitePedagogique;
import Domaine.emploiDuTemps.Seance;
import Domaine.programme.Concept;

public class CahierTexte {
	private int id;
	private String texte;
	private String observation;
	private String etat;
	private ArrayList<AcrivitePedagogique> activites;
	private Seance seance;
	private ArrayList<Concept> concepts;
	//TODO : Peut etre ajouter une association avec Chapitre : CahierTexte---------> Chapitre
	public CahierTexte() {
		super();
	}
	public CahierTexte(int id, String texte, String observation, String etat, Seance seance) {
		super();
		this.id = id;
		this.texte = texte;
		this.observation = observation;
		this.etat = etat;
		this.seance = seance;
		this.activites = new ArrayList<AcrivitePedagogique>();
		this.concepts  = new ArrayList<Concept>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public ArrayList<AcrivitePedagogique> getActivites() {
		return activites;
	}
	public void addActivite(AcrivitePedagogique activite) {
		this.activites.add(activite);
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	public ArrayList<Concept> getConcept() {
		return concepts;
	}
	public void addConcept(Concept concept) {
		this.concepts.add(concept);
	}
	@Override
	public String toString() {
		return "CahierTexte [id=" + id + ", texte=" + texte + ", observation="
				+ observation + ", etat=" + etat + ", activites=" + activites
				+ ", seance=" + seance + ", concepts=" + concepts + "]";
	}
}