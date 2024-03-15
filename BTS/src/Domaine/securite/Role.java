package Domaine.securite;

import java.util.ArrayList;
import Domaine.securite.Permission;

public class Role {
	private int id;
	private String code;
	private String nom_Fr;
	private String nom_Ar;
	private String description;
	public ArrayList<Permission> permissions;
	public Role() {
		super();
	}
	public Role(int id, String code, String nom_Fr, String nom_Ar,
			String description) {
		super();
		this.id = id;
		this.code = code;
		this.nom_Fr = nom_Fr;
		this.nom_Ar = nom_Ar;
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
	public String getNom_Fr() {
		return nom_Fr;
	}
	public void setNom_Fr(String nom_Fr) {
		this.nom_Fr = nom_Fr;
	}
	public String getNom_Ar() {
		return nom_Ar;
	}
	public void setNom_Ar(String nom_Ar) {
		this.nom_Ar = nom_Ar;
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
	public void addPermission(Permission permission) {
		this.permissions.add(permission);
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", code=" + code + ", nom_Fr=" + nom_Fr
				+ ", nom_Ar=" + nom_Ar + ", description=" + description
				+ ", permissions=" + permissions + "]";
	}
}