package Domaine.document;

import java.util.Date;

public class Document {
	protected int id;
	protected String code;
	protected String nom;
	protected String emplacement;
	protected String type;
	protected long taille;
	protected Date dateUpload;
	public Document() {
		super();
	}
	public Document(int id, String code, String nom, String emplacement,
			String type, long taille, Date dateUpload) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.emplacement = emplacement;
		this.type = type;
		this.taille = taille;
		this.dateUpload = dateUpload;
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
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getTaille() {
		return taille;
	}
	public void setTaille(long taille) {
		this.taille = taille;
	}
	public Date getDateUpload() {
		return dateUpload;
	}
	public void setDateUpload(Date dateUpload) {
		this.dateUpload = dateUpload;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", code=" + code + ", nom=" + nom
				+ ", emplacement=" + emplacement + ", type=" + type
				+ ", taille=" + taille + ", dateUpload=" + dateUpload + "]";
	}
}