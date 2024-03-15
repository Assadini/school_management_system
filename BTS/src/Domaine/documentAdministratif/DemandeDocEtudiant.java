package Domaine.documentAdministratif;


import Domaine.etudiant.Etudiant;

public class DemandeDocEtudiant extends DemandeDocument {
	private TypeDocumentEtudiant type;
	private Etudiant etudiant;
	
	public DemandeDocEtudiant() {
		super();
	}
	public TypeDocumentEtudiant getType() {
		return type;
	}
	public void setType(TypeDocumentEtudiant type) {
		this.type = type;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	@Override
	public String toString() {
		return "DemandeDocEtudiant [type=" + type + ", etudiant=" + etudiant
				+ ", id=" + id + ", date=" + date + ", etat=" + etat
				+ ", dateRetrait=" + dateRetrait + ", observation="
				+ observation + "]";
	}
}