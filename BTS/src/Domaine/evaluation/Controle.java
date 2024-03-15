package Domaine.evaluation;

import java.util.ArrayList;
import java.util.Date;

import Domaine.classe.Classe;
import Domaine.evaluation.NoteControle;
import Domaine.locaux.Salle;
import Domaine.matiere.Matiere;
import Domaine.matiere.Module;
import Domaine.personnel.Professeur;

public class Controle extends Evaluation {
	private boolean comptabilise;
	private ArrayList<NoteControle> notes;
	private Module module;
	public Controle() {
		super();
	}
	public Controle(int id, String code, Classe classe, Matiere matiere,
			String description, FormeEvaluation formeEvaluation, short duree,
			Salle salle, Date datePlanifiee, Date datePassage,
			Date dateDepotNotes, Professeur professeur, String etat,
			String observation, DocumentEvaluation sujet,
			DocumentEvaluation corrige,Module module) {
		super(id, code, classe, matiere, description, formeEvaluation, duree, salle,
				datePlanifiee, datePassage, dateDepotNotes, professeur, etat,
				observation, sujet, corrige);
		//TODO: Intilialiser les attributs
		this.notes  = new ArrayList<NoteControle>();
		this.comptabilise=false;
		this.module=module;
	}
	public boolean isComptabilise() {
		return comptabilise;
	}
	public void setComptabilise(boolean comptabilise) {
		this.comptabilise = comptabilise;
	}
	public ArrayList<NoteControle> getNotes() {
		return notes;
	}
	public void addNote(NoteControle note) {
		this.notes.add(note);
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	@Override
	public String toString() {
		return "Controle [comptabilise=" + comptabilise + ", notes=" + notes
				+ ", module=" + module + ", id=" + id + ", code=" + code
				+ ", classe=" + classe + ", matiere=" + matiere
				+ ", description=" + description + ", formeEvaluation="
				+ formeEvaluation + ", duree=" + duree + ", salle=" + salle
				+ ", datePlanifiee=" + datePlanifiee + ", datePassage="
				+ datePassage + ", dateDepotNotes=" + dateDepotNotes
				+ ", professeur=" + professeur + ", etat=" + etat
				+ ", observation=" + observation + ", sujet=" + sujet
				+ ", corrige=" + corrige + "]";
	}
}