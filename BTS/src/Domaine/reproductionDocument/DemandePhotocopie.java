package Domaine.reproductionDocument;

import Domaine.personnel.Professeur;
import java.util.ArrayList;
import java.util.Date;

import Domaine.classe.Classe;
import Domaine.matiere.Matiere;
import Domaine.matiere.Module;
import Domaine.reproductionDocument.DocumentPhotocopie;

public class DemandePhotocopie {
	private int id;
	private Professeur professeur;
	private Date date;
	private Date datePrevue;
	private Date dateRetrait;
	//Attribut d�riv� non perssistant servant � calculer le nombre de copie 
	//en fonction des nombre d'�tudiants des classe conc�rn�e
	private short nbreCopie;
	private String etat;
	private String observation;
	private ArrayList<Classe> classes;
	private Matiere matiere;
	private Module module;
	private TypeDocument type;
	private ArrayList<DocumentPhotocopie> documents;
	
	public DemandePhotocopie() {
		super();
	}

	public DemandePhotocopie(int id, Professeur professeur, Date date,
			Date datePrevue, Date dateRetrait, String etat,
			String observation, Matiere matiere,
			Module module, TypeDocument type) {
		super();
		this.id = id;
		this.professeur = professeur;
		this.date = date;
		this.datePrevue = datePrevue;
		this.dateRetrait = dateRetrait;
		this.etat = etat;
		this.observation = observation;
		this.matiere = matiere;
		this.module = module;
		this.type = type;
		this.classes = new ArrayList<Classe>();
		this.documents = new ArrayList<DocumentPhotocopie>();
		//TODO : calculer le nombre de copie en fonction des nombre d'�tudiants des classes concern�es
		this.nbreCopie = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDatePrevue() {
		return datePrevue;
	}

	public void setDatePrevue(Date datePrevue) {
		this.datePrevue = datePrevue;
	}

	public Date getDateRetrait() {
		return dateRetrait;
	}

	public void setDateRetrait(Date dateRetrait) {
		this.dateRetrait = dateRetrait;
	}

	public short getNbreCopie() {
		return nbreCopie;
	}

	public void setNbreCopie(short nbreCopie) {
		//TODO : calculer le nombre de copie en fonction des nombre d'�tudiants des classes concern�es
		this.nbreCopie = nbreCopie;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	public void addClasses(Classe classe) {
		this.classes.add(classe);
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public TypeDocument getType() {
		return type;
	}

	public void setType(TypeDocument type) {
		this.type = type;
	}

	public ArrayList<DocumentPhotocopie> getDocuments() {
		return documents;
	}

	public void addDocument(DocumentPhotocopie document) {
		this.documents.add(document);
	}

	@Override
	public String toString() {
		return "DemandePhotocopie [id=" + id + ", professeur=" + professeur
				+ ", date=" + date + ", datePrevue=" + datePrevue
				+ ", dateRetrait=" + dateRetrait + ", nbreCopie=" + nbreCopie
				+ ", etat=" + etat + ", observation=" + observation
				+ ", classes=" + classes + ", matiere=" + matiere + ", module="
				+ module + ", type=" + type + ", documents=" + documents + "]";
	}
}