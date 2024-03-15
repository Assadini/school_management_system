package Domaine.matiere;

import Domaine.evaluation.FormeEvaluation;

public class ConfigurationModule {
	private int id;
	private Module module;
	private ConfigurationMatiere configurationMatiere;
	private short volumeHoraire;
	private short horaireS1;
	private short horaireS2;
	private short nbreControles;
	private FormeEvaluation formeControle;
	private float noteEliminatoire;
	private Periode periode;
	public ConfigurationModule() {
		super();
	}
	public ConfigurationModule(int id, Module module,
			ConfigurationMatiere configurationMatiere, short volumeHoraire,
			short horaireS1,short horaireS2, 
			short nbreControles, FormeEvaluation formeControle,
			float noteEliminatoire, Periode periode) {
		super();
		this.id = id;
		this.module = module;
		this.configurationMatiere = configurationMatiere;
		this.volumeHoraire = volumeHoraire;
		this.horaireS1 = horaireS1;
		this.horaireS2 = horaireS2;
		this.nbreControles = nbreControles;
		this.formeControle = formeControle;
		this.noteEliminatoire = noteEliminatoire;
		this.periode = periode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public ConfigurationMatiere getConfigurationMatiere() {
		return configurationMatiere;
	}
	public void setConfigurationMatiere(ConfigurationMatiere configurationMatiere) {
		this.configurationMatiere = configurationMatiere;
	}
	public short getVolumeHoraire() {
		return volumeHoraire;
	}
	public void setVolumeHoraire(short volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}
	public short getHoraireS1() {
		return horaireS1;
	}
	public void setHoraireS1(short horaireS1) {
		this.horaireS1 = horaireS1;
	}
	public short getHoraireS2() {
		return horaireS2;
	}
	public void setHoraireS2(short horaireS2) {
		this.horaireS2 = horaireS2;
	}
	public short getNbreControles() {
		return nbreControles;
	}
	public void setNbreControles(short nbreControles) {
		this.nbreControles = nbreControles;
	}
	public FormeEvaluation getFormeControle() {
		return formeControle;
	}
	public void setFormeControle(FormeEvaluation formeControle) {
		this.formeControle = formeControle;
	}
	public float getNoteEliminatoire() {
		return noteEliminatoire;
	}
	public void setNoteEliminatoire(float noteEliminatoire) {
		this.noteEliminatoire = noteEliminatoire;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	@Override
	public String toString() {
		return "ConfigurationModule [id=" + id + ", module=" + module
				+ ", configurationMatiere=" + configurationMatiere
				+ ", Volume horaire=" + volumeHoraire 
				+ ", Horaire S1=" + horaireS1 + ", Horaire S2=" + horaireS2
				+ ", nbreControles=" + nbreControles + ", formeControle="
				+ formeControle + ", noteEliminatoire=" + noteEliminatoire
				+ ", periode=" + periode + "]";
	}
}