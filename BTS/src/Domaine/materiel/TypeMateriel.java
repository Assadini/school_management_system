package Domaine.materiel;

public class TypeMateriel {
	private int id;
	private String code;
	private String type;
	public TypeMateriel() {
		super();
	}
	public TypeMateriel(int id, String code, String type) {
		super();
		this.id = id;
		this.code = code;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "TypeMateriel [id=" + id + ", code=" + code + ", Type=" + type
				+ "]";
	}
}