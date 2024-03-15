package Domaine.securite;

import java.util.Date;

public class Permission {
	private int id;
	private String permission;
	private Date dateMAJ;
	private Role role;
	private Ressource ressource;
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permission(int id, String permission, Date dateMAJ, Role role,
			Ressource ressource) {
		this.id = id;
		this.permission = permission;
		this.dateMAJ = dateMAJ;
		this.role = role;
		this.ressource = ressource;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Date getDateMAJ() {
		return dateMAJ;
	}
	public void setDateMAJ(Date dateMAJ) {
		this.dateMAJ = dateMAJ;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Ressource getRessource() {
		return ressource;
	}
	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", permission=" + permission
				+ ", dateMAJ=" + dateMAJ + ", role=" + role + ", ressource="
				+ ressource + "]";
	}
}