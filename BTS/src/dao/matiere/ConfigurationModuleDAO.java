package dao.matiere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.evaluation.FormeEvaluation;
import Domaine.matiere.ConfigurationMatiere;
import Domaine.matiere.ConfigurationModule;
import Domaine.matiere.Matiere;
import Domaine.matiere.Module;
import Domaine.matiere.Periode;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.database.Db;

public class ConfigurationModuleDAO {
	private Connection con;
	public ConfigurationModuleDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(ConfigurationModule configurationModule) throws SQLException{
	String query = "INSERT INTO `configurationmodule` (\r\n" + 
				"`ID` ,\r\n" + 
				"`ConfigurationMatiereID` ,\r\n" + 
				"`ModuleID` ,\r\n" + 
				"`FormeEvaluationID` ,\r\n" + 
				"`PeriodeID` ,\r\n" + 
				"`VolumeHoraire` ,\r\n" + 
				"`HoraireS1` ,\r\n" + 
				"`HoraireS2` ,\r\n" + 
				"`NbreControles` ,\r\n" + 
				"`NoteEliminatoire`\r\n" + 
				")\r\n" + 
				"VALUES (NULL , ?, ?, ?, ?, ?, ?, ?, ?, ? );";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, configurationModule.getConfigurationMatiere().getId());
		statement.setInt(2, configurationModule.getModule().getId());
		statement.setInt(3, configurationModule.getFormeControle().getId());
		statement.setInt(4, configurationModule.getPeriode().getId());
		statement.setShort(5, configurationModule.getVolumeHoraire());
		statement.setShort(6, configurationModule.getHoraireS1());
		statement.setShort(7, configurationModule.getHoraireS2());
		statement.setShort(8, configurationModule.getNbreControles());
		statement.setFloat(9, configurationModule.getNoteEliminatoire());
		statement.execute();
		statement.close();
	}
	public ArrayList<ConfigurationModule> getAllByConfigurationMatiere(ConfigurationMatiere configurationMatiere1) throws SQLException{
		String query = "SELECT \r\n" + 
				"	`configurationmodule`.`ID` AS `ConfigurationModuleID`,\r\n" +
				"	`configurationmodule`.`VolumeHoraire`,\r\n" +
				"	`configurationmodule`.`HoraireS1`,\r\n" +
				"	`configurationmodule`.`HoraireS2`,\r\n" +
				"	`configurationmodule`.`NbreControles`,\r\n" +
				"	`configurationmodule`.`NoteEliminatoire` AS `ModuleNoteEliminatoire`,\r\n" +
				"	`formeEvaluation`.`ID` AS `FormeEvaluationID`,\r\n" +
				"	`formeEvaluation`.`Code` AS `FormeEvaluationCode`,\r\n" +
				"	`formeEvaluation`.`Nom_Fr` AS `FormeEvaluationNom_Fr`,\r\n" +
				"	`formeEvaluation`.`Nom_Ar` AS `FormeEvaluationNom_Ar`,\r\n" +
				"	`periode`.`ID` AS `PeriodeID`,\r\n" +
				"	`periode`.`Code` AS `PeriodeCode`,\r\n" +
				"	`periode`.`Nom_Fr` AS `PeriodeNom_Fr`,\r\n" +
				"	`periode`.`Nom_Ar` AS `PeriodeNom_Ar`,\r\n" +
				"	`module`.`ID` AS `ModuleID`,\r\n" +
				"	`module`.`Code` AS `ModuleCode`,\r\n" +
				"	`module`.`Nom_Fr` AS `ModuleNom_Fr`,\r\n" + 
				"	`module`.`Nom_Ar` AS `ModuleNom_Ar`,\r\n" +
				"	`configurationMatiere`.`ID` AS `ConfigurationMatiereID`,\r\n" +
				"	`configurationMatiere`.`NoteEliminatoire` AS `MatiereNoteEliminatoire`,\r\n" +
				"	`matiere`.`ID` AS `MatiereID`,\r\n" +
				"	`matiere`.`Code` AS `MatiereCode`,\r\n" +
				"	`matiere`.`Nom_Fr` AS `MatiereNom_Fr`,\r\n" + 
				"	`matiere`.`Nom_Ar` AS `MatiereNom_Ar`\r\n" +
				"	FROM `configurationmodule`,`formeEvaluation`,`periode`, `module`,`configurationMatiere`,`matiere` \r\n" + 
				"	WHERE \r\n" + 
				"	(`configurationmodule`.`ModuleID`= `module`.`ID`) AND\r\n" +
				"	(`configurationmodule`.`FormeEvaluationID`= `formeEvaluation`.`ID`) AND\r\n" +
				"	(`configurationmodule`.`PeriodeID`= `periode`.`ID`) AND\r\n" +
				"	(`configurationmodule`.`ConfigurationMatiereID`= `configurationMatiere`.`ID`) AND\r\n" +
				"	(`configurationMatiere`.`MatiereID`= `matiere`.`ID`) AND\r\n" +
				"	(`configurationmodule`.`ConfigurationMatiereID`= ?);";
		
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, configurationMatiere1.getId());
		ResultSet rs = statement.executeQuery();
		ArrayList<ConfigurationModule> configurationModules = new ArrayList<ConfigurationModule>();
		
		while (rs.next()) {
			
			ConfigurationModule configurationModule = new ConfigurationModule();
			
			configurationModule.setId(rs.getInt("ConfigurationModuleID"));
			configurationModule.setVolumeHoraire(rs.getShort("VolumeHoraire"));
			configurationModule.setHoraireS1(rs.getShort("HoraireS1"));
			configurationModule.setHoraireS2(rs.getShort("HoraireS2"));
			configurationModule.setNbreControles(rs.getShort("NbreControles"));
			configurationModule.setNoteEliminatoire(rs.getFloat("ModuleNoteEliminatoire"));
			
			FormeEvaluation formeControle = new FormeEvaluation();
			formeControle.setId(rs.getInt("FormeEvaluationID"));
			formeControle.setCode(rs.getString("FormeEvaluationCode"));
			formeControle.setNom_Fr(rs.getString("FormeEvaluationNom_Fr"));
			formeControle.setNom_Ar(rs.getString("FormeEvaluationNom_Fr"));
			
			configurationModule.setFormeControle(formeControle);
			
			Periode periode = new Periode();
			periode.setId(rs.getInt("PeriodeID"));
			periode.setCode(rs.getString("PeriodeCode"));
			periode.setNom_Fr(rs.getString("PeriodeNom_Fr"));
			periode.setNom_Ar(rs.getString("PeriodeNom_Ar"));
			
			configurationModule.setPeriode(periode);
			
			Module module = new Module();
			module.setId(rs.getInt("ModuleID"));
			module.setCode(rs.getString("ModuleCode"));
			module.setNom_Fr(rs.getString("ModuleNom_Fr"));
			module.setNom_Ar(rs.getString("ModuleNom_Ar"));
			
			configurationModule.setModule(module);
			
			ConfigurationMatiere configurationMatiere = new ConfigurationMatiere();
			configurationMatiere.setId(rs.getInt("ConfigurationMatiereID"));
			configurationMatiere.setNoteEliminatoire(rs.getFloat("MatiereNoteEliminatoire"));
			
			Matiere matiere = new Matiere();
			matiere.setId(rs.getInt("MatiereID"));
			matiere.setCode(rs.getString("MatiereCode"));
			matiere.setNom_Fr(rs.getString("MatiereNom_Fr"));
			matiere.setNom_Ar(rs.getString("MatiereNom_Ar"));
			
			configurationMatiere.setMatiere(matiere);
			
			configurationModule.setConfigurationMatiere(configurationMatiere);
			
			configurationModules.add(configurationModule);
		}
		rs.close();
		statement.close();
		return configurationModules;

	}
	public ConfigurationModule getById(int id) throws SQLException{
		String query = "SELECT \r\n" + 
				"	`configurationmodule`.`ID` AS `ConfigurationModuleID`,\r\n" +
				"	`configurationmodule`.`VolumeHoraire`,\r\n" +
				"	`configurationmodule`.`HoraireS1`,\r\n" +
				"	`configurationmodule`.`HoraireS2`,\r\n" +
				"	`configurationmodule`.`NbreControles`,\r\n" +
				"	`configurationmodule`.`NoteEliminatoire` AS `ModuleNoteEliminatoire`,\r\n" +
				"	`formeEvaluation`.`ID` AS `FormeEvaluationID`,\r\n" +
				"	`formeEvaluation`.`Code` AS `FormeEvaluationCode`,\r\n" +
				"	`formeEvaluation`.`Nom_Fr` AS `FormeEvaluationNom_Fr`,\r\n" +
				"	`formeEvaluation`.`Nom_Ar` AS `FormeEvaluationNom_Ar`,\r\n" +
				"	`periode`.`ID` AS `PeriodeID`,\r\n" +
				"	`periode`.`Code` AS `PeriodeCode`,\r\n" +
				"	`periode`.`Nom_Fr` AS `PeriodeNom_Fr`,\r\n" +
				"	`periode`.`Nom_Ar` AS `PeriodeNom_Ar`,\r\n" +
				"	`module`.`ID` AS `ModuleID`,\r\n" +
				"	`module`.`Code` AS `ModuleCode`,\r\n" +
				"	`module`.`Nom_Fr` AS `ModuleNom_Fr`,\r\n" + 
				"	`module`.`Nom_Ar` AS `ModuleNom_Ar`,\r\n" +
				"	`configurationMatiere`.`ID` AS `ConfigurationMatiereID`,\r\n" +
				"	`configurationMatiere`.`NoteEliminatoire` AS `MatiereNoteEliminatoire`,\r\n" +
				"	`matiere`.`ID` AS `MatiereID`,\r\n" +
				"	`matiere`.`Code` AS `MatiereCode`,\r\n" +
				"	`matiere`.`Nom_Fr` AS `MatiereNom_Fr`,\r\n" + 
				"	`matiere`.`Nom_Ar` AS `MatiereNom_Ar`\r\n" +
				"	FROM `configurationmodule`,`formeEvaluation`,`periode`, `module`,`configurationMatiere`,`matiere` \r\n" + 
				"	WHERE \r\n" + 
				"	(`configurationmodule`.`ModuleID`= `module`.`ID`) AND\r\n" +
				"	(`configurationmodule`.`FormeEvaluationID`= `formeEvaluation`.`ID`) AND\r\n" +
				"	(`configurationmodule`.`PeriodeID`= `periode`.`ID`) AND\r\n" +
				"	(`configurationmodule`.`ConfigurationMatiereID`= `configurationMatiere`.`ID`) AND\r\n" +
				"	(`configurationMatiere`.`MatiereID`= `matiere`.`ID`) AND\r\n" +
				"	(`configurationmodule`.`ID`= ?);";
		
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		ConfigurationModule configurationModule = new ConfigurationModule();
		while (rs.next()) {
			
			
			
			configurationModule.setId(rs.getInt("ConfigurationModuleID"));
			configurationModule.setVolumeHoraire(rs.getShort("VolumeHoraire"));
			configurationModule.setHoraireS1(rs.getShort("HoraireS1"));
			configurationModule.setHoraireS2(rs.getShort("HoraireS2"));
			configurationModule.setNbreControles(rs.getShort("NbreControles"));
			configurationModule.setNoteEliminatoire(rs.getFloat("ModuleNoteEliminatoire"));
			
			FormeEvaluation formeControle = new FormeEvaluation();
			formeControle.setId(rs.getInt("FormeEvaluationID"));
			formeControle.setCode(rs.getString("FormeEvaluationCode"));
			formeControle.setNom_Fr(rs.getString("FormeEvaluationNom_Fr"));
			formeControle.setNom_Ar(rs.getString("FormeEvaluationNom_Fr"));
			
			configurationModule.setFormeControle(formeControle);
			
			Periode periode = new Periode();
			periode.setId(rs.getInt("PeriodeID"));
			periode.setCode(rs.getString("PeriodeCode"));
			periode.setNom_Fr(rs.getString("PeriodeNom_Fr"));
			periode.setNom_Ar(rs.getString("PeriodeNom_Ar"));
			
			configurationModule.setPeriode(periode);
			
			Module module = new Module();
			module.setId(rs.getInt("ModuleID"));
			module.setCode(rs.getString("ModuleCode"));
			module.setNom_Fr(rs.getString("ModuleNom_Fr"));
			module.setNom_Ar(rs.getString("ModuleNom_Ar"));
			
			configurationModule.setModule(module);
			
			ConfigurationMatiere configurationMatiere = new ConfigurationMatiere();
			configurationMatiere.setId(rs.getInt("ConfigurationMatiereID"));
			configurationMatiere.setNoteEliminatoire(rs.getFloat("MatiereNoteEliminatoire"));
			
			Matiere matiere = new Matiere();
			matiere.setId(rs.getInt("MatiereID"));
			matiere.setCode(rs.getString("MatiereCode"));
			matiere.setNom_Fr(rs.getString("MatiereNom_Fr"));
			matiere.setNom_Ar(rs.getString("MatiereNom_Ar"));
			
			configurationMatiere.setMatiere(matiere);
			
			configurationModule.setConfigurationMatiere(configurationMatiere);
		}
		rs.close();
		statement.close();
		return configurationModule;

	}
	public void update(ConfigurationModule configurationModule) throws SQLException{
		String query = "UPDATE `configurationmodule` \r\n" + 
					" SET \r\n" + 
					"`ConfigurationMatiereID` = ? ,\r\n" + 
					"`ModuleID` = ? ,\r\n" + 
					"`FormeEvaluationID` = ? ,\r\n" + 
					"`PeriodeID` = ? ,\r\n" + 
					"`VolumeHoraire` = ? ,\r\n" + 
					"`HoraireS1` = ? ,\r\n" + 
					"`HoraireS2` = ? ,\r\n" +
					"`NbreControles` = ? ,\r\n" + 
					"`NoteEliminatoire` = ?\r\n" + 
					" WHERE \r\n" + 
					" `ID` = ? ;";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			statement.setInt(1, configurationModule.getConfigurationMatiere().getId());
			statement.setInt(2, configurationModule.getModule().getId());
			statement.setInt(3, configurationModule.getFormeControle().getId());
			statement.setInt(4, configurationModule.getPeriode().getId());
			statement.setShort(5, configurationModule.getVolumeHoraire());
			statement.setShort(6, configurationModule.getHoraireS1());
			statement.setShort(7, configurationModule.getHoraireS2());
			statement.setShort(8, configurationModule.getNbreControles());
			statement.setFloat(9, configurationModule.getNoteEliminatoire());
			statement.setFloat(10, configurationModule.getId());
			statement.execute();
			statement.close();
	}
	public void delete(ConfigurationModule configurationModule) throws SQLException{
		String query = "DELETE FROM `configurationmodule` WHERE `ID` = ? ;";
			PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
			statement.setFloat(1, configurationModule.getId());
			statement.execute();
			statement.close();
	}
}
