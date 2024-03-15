package Domaine.securite;

import java.util.ArrayList;
import Domaine.securite.Permission;

public class Ressource {
	private int id;
	private String code;
	private String nom;
	private String url;
	private String description;
	public ArrayList<Permission> permissions ;
	public Ressource() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ressource(int id, String code, String nom, String url,
			String description) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.url = url;
		this.description = description;
		this.permissions = new ArrayList<Permission>();
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Permission> getPermissions() {
		return permissions;
	}
	public void addPermissions(Permission permission) {
		this.permissions.add(permission);
	}
	@Override
	public String toString() {
		return "Ressource [id=" + id + ", code=" + code + ", nom=" + nom
				+ ", url=" + url + ", description=" + description
				+ ", permissions=" + permissions + "]";
	}
}