package Domaine.evaluation;

import java.util.ArrayList;
import java.util.Date;

import Domaine.classe.Classe;
import Domaine.evaluation.MembreJury;
import Domaine.locaux.Salle;
import Domaine.matiere.Matiere;
import Domaine.personnel.Professeur;

public class Soutenance extends Evaluation {
	public ArrayList<MembreJury> jurys;

	public Soutenance() {
		super();
	}

	public Soutenance(int id, String code, Classe classe, Matiere matiere,
			String description, FormeEvaluation formeEvaluation, short duree,
			Salle salle, Date datePlanifiee, Date datePassage,
			Date dateDepotNotes, Professeur professeur, String etat,
			String observation, DocumentEvaluation sujet,
			DocumentEvaluation corrige) {
		super(id, code, classe, matiere, description, formeEvaluation, duree, salle,
				datePlanifiee, datePassage, dateDepotNotes, professeur, etat,
				observation, sujet, corrige);
		this.jurys= new ArrayList<MembreJury>();
	}

	public ArrayList<MembreJury> getJurys() {
		return jurys;
	}

	public void addJurys(MembreJury jury) {
		this.jurys.add(jury);
	}

	@Override
	public String toString() {
		return "Soutenance [jurys=" + jurys + ", id=" + id + ", code=" + code
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