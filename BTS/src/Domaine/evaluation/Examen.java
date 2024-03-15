package Domaine.evaluation;

import java.util.ArrayList;
import java.util.Date;

import Domaine.classe.Classe;
import Domaine.evaluation.NoteExamen;
import Domaine.locaux.Salle;
import Domaine.matiere.Matiere;
import Domaine.personnel.Professeur;

public class Examen extends Evaluation {
	private String session;
	private ArrayList<NoteExamen> notes;
	private TypeExamen type;
	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Examen(int id, String code, Classe classe, Matiere matiere,
			String description, FormeEvaluation formeEvaluation, short duree,
			Salle salle, Date datePlanifiee, Date datePassage,
			Date dateDepotNotes, Professeur professeur, String etat,
			String observation, DocumentEvaluation sujet,
			DocumentEvaluation corrige,String session,TypeExamen type) {
		super(id, code, classe, matiere, description, formeEvaluation, duree, salle,
				datePlanifiee, datePassage, dateDepotNotes, professeur, etat,
				observation, sujet, corrige);
		// TODO Auto-generated constructor stub
		this.type=type;
		this.session=session;
		this.notes = new ArrayList<NoteExamen>();
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public ArrayList<NoteExamen> getNotes() {
		return notes;
	}
	public void setNotes(ArrayList<NoteExamen> notes) {
		this.notes = notes;
	}
	public TypeExamen getType() {
		return type;
	}
	public void setType(TypeExamen type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Examen [session=" + session + ", notes=" + notes + ", type="
				+ type + ", id=" + id + ", code=" + code + ", classe=" + classe
				+ ", matiere=" + matiere + ", description=" + description
				+ ", formeEvaluation=" + formeEvaluation + ", duree=" + duree
				+ ", salle=" + salle + ", datePlanifiee=" + datePlanifiee
				+ ", datePassage=" + datePassage + ", dateDepotNotes="
				+ dateDepotNotes + ", professeur=" + professeur + ", etat="
				+ etat + ", observation=" + observation + ", sujet=" + sujet
				+ ", corrige=" + corrige + "]";
	}
}