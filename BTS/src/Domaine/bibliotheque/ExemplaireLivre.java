package Domaine.bibliotheque;

public class ExemplaireLivre {
	private int id;
	private String code;
	private String numInventaire;
	private String etat;
	private String observation;
	private Livre livre;
	public ExemplaireLivre() {
		super();
	}
	public ExemplaireLivre(int id, String code, String numInventaire,
			String etat, String observation, Livre livre) {
		super();
		this.id = id;
		this.code = code;
		this.numInventaire = numInventaire;
		this.etat = etat;
		this.observation = observation;
		this.livre = livre;
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
	public String getNumInventaire() {
		return numInventaire;
	}
	public void setNumInventaire(String numInventaire) {
		this.numInventaire = numInventaire;
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
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	@Override
	public String toString() {
		return "ExemplaireLivre [id=" + id + ", code=" + code
				+ ", numInventaire=" + numInventaire + ", etat=" + etat
				+ ", observation=" + observation + ", livre=" + livre + "]";
	}
}