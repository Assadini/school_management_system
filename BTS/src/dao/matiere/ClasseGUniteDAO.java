package dao.matiere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.classe.ClasseGenerique;
import Domaine.classe.Cycle;
import Domaine.classe.Filiere;
import Domaine.classe.Niveau;
import Domaine.matiere.ClasseGUnite;
import Domaine.matiere.Unite;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.database.Db;

public class ClasseGUniteDAO {
	private Connection con;
	public ClasseGUniteDAO(){
		this.con = Db.getInstance().con;
	}
	public void insert(ClasseGUnite classeGUnite) throws SQLException{
		String query="INSERT INTO `classegunite` (\r\n" + 
				"`ID` ,\r\n" + 
				"`ClasseGeneriqueID` ,\r\n" + 
				"`UniteID` ,\r\n" + 
				"`NoteEliminatoire`\r\n" + 
				")\r\n" + 
				"VALUES (\r\n" + 
				"NULL , ?, ?, ?\r\n" + 
				");";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, classeGUnite.getClasseGenerique().getId());
		statement.setInt(2, classeGUnite.getUnite().getId());
		statement.setFloat(3,classeGUnite.getNoteEliminatoire());
		statement.execute();
		statement.close();
	}
	public ArrayList<ClasseGUnite> getAll() throws SQLException{
		String query = "SELECT \r\n" + 
				"	`classegunite`.`ID` AS `classeguniteID`,\r\n" + 
				"	`classegunite`.`NoteEliminatoire` ,\r\n" + 
				"	`classegenerique`.`ID` AS `classegeneriqueID`,\r\n" + 
				"	`classegenerique`.`Description`,\r\n" +
				"	`unite`.`ID` AS `uniteID`,\r\n" + 
				"	`unite`.`Code` AS `uniteCode`,\r\n" + 
				"	`unite`.`Nom_Fr` AS `uniteNom_Fr`,\r\n" +
				"	`unite`.`Nom_Ar` AS `uniteNom_Ar`,\r\n" +
				"	`cycle`.`ID` AS `cycleID`,\r\n" + 
				"	`cycle`.`Code` AS `cycleCode`,\r\n" + 
				"	`cycle`.`Nom_Fr` AS `cycleNom_Fr`,\r\n" +
				"	`cycle`.`Nom_Ar` AS `cycleNom_Ar`,\r\n" +
				"	`filiere`.`ID` AS `filiereID`,\r\n" + 
				"	`filiere`.`Code` AS `filiereCode`,\r\n" +
				"	`filiere`.`Nom_Fr` AS `filiereNom_Fr`,\r\n" + 
				"	`filiere`.`Nom_Ar` AS `filiereNom_Ar`,\r\n" +
				"	`niveau`.`ID` AS `niveauID`,\r\n" + 
				"	`niveau`.`Code` AS `niveauCode`,\r\n" + 
				"	`niveau`.`Nom_Fr` AS `niveauNom_Fr`,\r\n" + 
				"	`niveau`.`Nom_Ar` AS `niveauNom_Ar`\r\n" +
				"	FROM `classegunite`, `classegenerique`, `unite` ,`cycle`, `filiere`, `niveau`\r\n" + 
				"	WHERE \r\n" + 
				"	(`classegunite`.`ClasseGeneriqueID`= `classegenerique`.`ID`) AND\r\n" +
				"	(`classegunite`.`UniteID`= `unite`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`CycleID`= `cycle`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`FiliereID`= `filiere`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`NiveauID`= `niveau`.`ID`)\r\n" + 
				"	;\r\n";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		ArrayList<ClasseGUnite> classeGUnites = new ArrayList<ClasseGUnite>();
		
		while (rs.next()) {
			
			
			Cycle cycle= new Cycle();
			cycle.setId(rs.getInt("cycleID"));
			cycle.setCode(rs.getString("cycleCode"));
			cycle.setNom_Fr(rs.getString("cycleNom_Fr"));
			cycle.setNom_Ar(rs.getString("cycleNom_Ar"));
			
			Filiere filiere = new Filiere();
			filiere.setId(rs.getInt("filiereID"));
			filiere.setCode(rs.getString("filiereCode"));
			filiere.setNom_Fr(rs.getString("filiereNom_Fr"));
			filiere.setNom_Ar(rs.getString("filiereNom_Ar"));
			
			Niveau niveau= new Niveau();
			niveau.setId(rs.getInt("niveauID"));
			niveau.setCode(rs.getString("niveauCode"));
			niveau.setNom_Fr(rs.getString("niveauNom_Fr"));
			niveau.setNom_Ar(rs.getString("niveauNom_Ar"));
			
			ClasseGenerique classeGenerique =new ClasseGenerique();
			classeGenerique.setCycle(cycle);
			classeGenerique.setFiliere(filiere);
			classeGenerique.setNiveau(niveau);
			classeGenerique.setId(rs.getInt("classegeneriqueID"));
			classeGenerique.setDescription(rs.getString("Description"));
			classeGenerique.setCode();
			
			Unite unite= new Unite();
			unite.setId(rs.getInt("uniteID"));
			unite.setCode(rs.getString("uniteCode"));
			unite.setNom_Fr(rs.getString("uniteNom_Fr"));
			unite.setNom_Ar(rs.getString("uniteNom_Ar"));
			
			ClasseGUnite classeGUnite = new ClasseGUnite();
			classeGUnite.setId(rs.getInt("classeguniteID"));
			classeGUnite.setNoteEliminatoire(rs.getFloat("NoteEliminatoire"));
			classeGUnite.setClasseGenerique(classeGenerique);
			classeGUnite.setUnite(unite);
			
			classeGUnites.add(classeGUnite);
		}
		rs.close();
		statement.close();
		return classeGUnites;
	}
	public ArrayList<ClasseGUnite> getAllByClasseGenerique(ClasseGenerique classeGenerique1) throws SQLException{
		String query = "SELECT \r\n" + 
				"	`classegunite`.`ID` AS `classeguniteID`,\r\n" + 
				"	`classegunite`.`NoteEliminatoire` ,\r\n" + 
				"	`classegenerique`.`ID` AS `classegeneriqueID`,\r\n" + 
				"	`classegenerique`.`Description`,\r\n" +
				"	`unite`.`ID` AS `uniteID`,\r\n" + 
				"	`unite`.`Code` AS `uniteCode`,\r\n" + 
				"	`unite`.`Nom_Fr` AS `uniteNom_Fr`,\r\n" +
				"	`unite`.`Nom_Ar` AS `uniteNom_Ar`,\r\n" +
				"	`cycle`.`ID` AS `cycleID`,\r\n" + 
				"	`cycle`.`Code` AS `cycleCode`,\r\n" + 
				"	`cycle`.`Nom_Fr` AS `cycleNom_Fr`,\r\n" +
				"	`cycle`.`Nom_Ar` AS `cycleNom_Ar`,\r\n" +
				"	`filiere`.`ID` AS `filiereID`,\r\n" + 
				"	`filiere`.`Code` AS `filiereCode`,\r\n" +
				"	`filiere`.`Nom_Fr` AS `filiereNom_Fr`,\r\n" + 
				"	`filiere`.`Nom_Ar` AS `filiereNom_Ar`,\r\n" +
				"	`niveau`.`ID` AS `niveauID`,\r\n" + 
				"	`niveau`.`Code` AS `niveauCode`,\r\n" + 
				"	`niveau`.`Nom_Fr` AS `niveauNom_Fr`,\r\n" + 
				"	`niveau`.`Nom_Ar` AS `niveauNom_Ar`\r\n" +
				"	FROM `classegunite`, `classegenerique`, `unite` ,`cycle`, `filiere`, `niveau`\r\n" + 
				"	WHERE \r\n" + 
				"	(`classegunite`.`ClasseGeneriqueID`= `classegenerique`.`ID`) AND\r\n" +
				"	(`classegunite`.`UniteID`= `unite`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`CycleID`= `cycle`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`FiliereID`= `filiere`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`NiveauID`= `niveau`.`ID`) AND \r\n" + 
				"	(`classegunite`.`ClasseGeneriqueID`= ?);";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, classeGenerique1.getId());
		ResultSet rs = statement.executeQuery();
		ArrayList<ClasseGUnite> classeGUnites = new ArrayList<ClasseGUnite>();
		
		while (rs.next()) {
			
			
			Cycle cycle= new Cycle();
			cycle.setId(rs.getInt("cycleID"));
			cycle.setCode(rs.getString("cycleCode"));
			cycle.setNom_Fr(rs.getString("cycleNom_Fr"));
			cycle.setNom_Ar(rs.getString("cycleNom_Ar"));
			
			Filiere filiere = new Filiere();
			filiere.setId(rs.getInt("filiereID"));
			filiere.setCode(rs.getString("filiereCode"));
			filiere.setNom_Fr(rs.getString("filiereNom_Fr"));
			filiere.setNom_Ar(rs.getString("filiereNom_Ar"));
			
			Niveau niveau= new Niveau();
			niveau.setId(rs.getInt("niveauID"));
			niveau.setCode(rs.getString("niveauCode"));
			niveau.setNom_Fr(rs.getString("niveauNom_Fr"));
			niveau.setNom_Ar(rs.getString("niveauNom_Ar"));
			
			ClasseGenerique classeGenerique =new ClasseGenerique();
			classeGenerique.setCycle(cycle);
			classeGenerique.setFiliere(filiere);
			classeGenerique.setNiveau(niveau);
			classeGenerique.setId(rs.getInt("classegeneriqueID"));
			classeGenerique.setDescription(rs.getString("Description"));
			classeGenerique.setCode();
			
			Unite unite= new Unite();
			unite.setId(rs.getInt("uniteID"));
			unite.setCode(rs.getString("uniteCode"));
			unite.setNom_Fr(rs.getString("uniteNom_Fr"));
			unite.setNom_Ar(rs.getString("uniteNom_Ar"));
			
			ClasseGUnite classeGUnite = new ClasseGUnite();
			classeGUnite.setId(rs.getInt("classeguniteID"));
			classeGUnite.setNoteEliminatoire(rs.getFloat("NoteEliminatoire"));
			classeGUnite.setClasseGenerique(classeGenerique);
			classeGUnite.setUnite(unite);
			
			classeGUnites.add(classeGUnite);
		}
		rs.close();
		statement.close();
		return classeGUnites;
	}
	public ClasseGUnite exists(ClasseGUnite classeGUnite) throws SQLException{
		String query = "SELECT \r\n" + 
				"	`classegunite`.`ID` AS `classeguniteID`,\r\n" + 
				"	`classegunite`.`NoteEliminatoire` ,\r\n" + 
				"	`classegenerique`.`ID` AS `classegeneriqueID`,\r\n" + 
				"	`classegenerique`.`Description`,\r\n" +
				"	`unite`.`ID` AS `uniteID`,\r\n" + 
				"	`unite`.`Code` AS `uniteCode`,\r\n" + 
				"	`unite`.`Nom_Fr` AS `uniteNom_Fr`,\r\n" +
				"	`unite`.`Nom_Ar` AS `uniteNom_Ar`,\r\n" +
				"	`cycle`.`ID` AS `cycleID`,\r\n" + 
				"	`cycle`.`Code` AS `cycleCode`,\r\n" + 
				"	`cycle`.`Nom_Fr` AS `cycleNom_Fr`,\r\n" +
				"	`cycle`.`Nom_Ar` AS `cycleNom_Ar`,\r\n" +
				"	`filiere`.`ID` AS `filiereID`,\r\n" + 
				"	`filiere`.`Code` AS `filiereCode`,\r\n" +
				"	`filiere`.`Nom_Fr` AS `filiereNom_Fr`,\r\n" + 
				"	`filiere`.`Nom_Ar` AS `filiereNom_Ar`,\r\n" +
				"	`niveau`.`ID` AS `niveauID`,\r\n" + 
				"	`niveau`.`Code` AS `niveauCode`,\r\n" + 
				"	`niveau`.`Nom_Fr` AS `niveauNom_Fr`,\r\n" + 
				"	`niveau`.`Nom_Ar` AS `niveauNom_Ar`\r\n" +
				"	FROM `classegunite`, `classegenerique`, `unite` ,`cycle`, `filiere`, `niveau`\r\n" + 
				"	WHERE \r\n" + 
				"	(`classegunite`.`ClasseGeneriqueID`= `classegenerique`.`ID`) AND\r\n" +
				"	(`classegunite`.`UniteID`= `unite`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`CycleID`= `cycle`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`FiliereID`= `filiere`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`NiveauID`= `niveau`.`ID`) AND\r\n" + 
				"	(`classegunite`.`ClasseGeneriqueID` = ?) AND\r\n" +
				"	(`classegunite`.`UniteID` = ?);\r\n";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, classeGUnite.getClasseGenerique().getId());
		statement.setInt(2, classeGUnite.getUnite().getId());
		ResultSet rs = statement.executeQuery();
		ClasseGUnite classeGUniteResult = null;
		
		while (rs.next()) {
			
			
			Cycle cycle= new Cycle();
			cycle.setId(rs.getInt("cycleID"));
			cycle.setCode(rs.getString("cycleCode"));
			cycle.setNom_Fr(rs.getString("cycleNom_Fr"));
			cycle.setNom_Ar(rs.getString("cycleNom_Ar"));
			
			Filiere filiere = new Filiere();
			filiere.setId(rs.getInt("filiereID"));
			filiere.setCode(rs.getString("filiereCode"));
			filiere.setNom_Fr(rs.getString("filiereNom_Fr"));
			filiere.setNom_Ar(rs.getString("filiereNom_Ar"));
			
			Niveau niveau= new Niveau();
			niveau.setId(rs.getInt("niveauID"));
			niveau.setCode(rs.getString("niveauCode"));
			niveau.setNom_Fr(rs.getString("niveauNom_Fr"));
			niveau.setNom_Ar(rs.getString("niveauNom_Ar"));
			
			ClasseGenerique classeGenerique =new ClasseGenerique();
			classeGenerique.setCycle(cycle);
			classeGenerique.setFiliere(filiere);
			classeGenerique.setNiveau(niveau);
			classeGenerique.setId(rs.getInt("classegeneriqueID"));
			classeGenerique.setDescription(rs.getString("Description"));
			classeGenerique.setCode();
			
			Unite unite= new Unite();
			unite.setId(rs.getInt("uniteID"));
			unite.setCode(rs.getString("uniteCode"));
			unite.setNom_Fr(rs.getString("uniteNom_Fr"));
			unite.setNom_Ar(rs.getString("uniteNom_Ar"));
			
			classeGUniteResult = new ClasseGUnite();
			classeGUniteResult.setId(rs.getInt("classeguniteID"));
			classeGUniteResult.setNoteEliminatoire(rs.getFloat("NoteEliminatoire"));
			classeGUniteResult.setClasseGenerique(classeGenerique);
			classeGUniteResult.setUnite(unite);
			
			
		}
		rs.close();
		statement.close();
		return classeGUniteResult;
	}
	public ClasseGUnite getById(int id) throws SQLException{
		String query = "SELECT \r\n" + 
				"	`classegunite`.`ID` AS `classeguniteID`,\r\n" + 
				"	`classegunite`.`NoteEliminatoire` ,\r\n" + 
				"	`classegenerique`.`ID` AS `classegeneriqueID`,\r\n" + 
				"	`classegenerique`.`Description`,\r\n" +
				"	`unite`.`ID` AS `uniteID`,\r\n" + 
				"	`unite`.`Code` AS `uniteCode`,\r\n" + 
				"	`unite`.`Nom_Fr` AS `uniteNom_Fr`,\r\n" +
				"	`unite`.`Nom_Ar` AS `uniteNom_Ar`,\r\n" +
				"	`cycle`.`ID` AS `cycleID`,\r\n" + 
				"	`cycle`.`Code` AS `cycleCode`,\r\n" + 
				"	`cycle`.`Nom_Fr` AS `cycleNom_Fr`,\r\n" +
				"	`cycle`.`Nom_Ar` AS `cycleNom_Ar`,\r\n" +
				"	`filiere`.`ID` AS `filiereID`,\r\n" + 
				"	`filiere`.`Code` AS `filiereCode`,\r\n" +
				"	`filiere`.`Nom_Fr` AS `filiereNom_Fr`,\r\n" + 
				"	`filiere`.`Nom_Ar` AS `filiereNom_Ar`,\r\n" +
				"	`niveau`.`ID` AS `niveauID`,\r\n" + 
				"	`niveau`.`Code` AS `niveauCode`,\r\n" + 
				"	`niveau`.`Nom_Fr` AS `niveauNom_Fr`,\r\n" + 
				"	`niveau`.`Nom_Ar` AS `niveauNom_Ar`\r\n" +
				"	FROM `classegunite`, `classegenerique`, `unite` ,`cycle`, `filiere`, `niveau`\r\n" + 
				"	WHERE \r\n" + 
				"	(`classegunite`.`ClasseGeneriqueID`= `classegenerique`.`ID`) AND\r\n" +
				"	(`classegunite`.`UniteID`= `unite`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`CycleID`= `cycle`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`FiliereID`= `filiere`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`NiveauID`= `niveau`.`ID`) AND\r\n" + 
				"	(`classegunite`.`ID` = ?); \r\n" ;
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		ClasseGUnite classeGUniteResult = null;
		
		while (rs.next()) {
			
			
			Cycle cycle= new Cycle();
			cycle.setId(rs.getInt("cycleID"));
			cycle.setCode(rs.getString("cycleCode"));
			cycle.setNom_Fr(rs.getString("cycleNom_Fr"));
			cycle.setNom_Ar(rs.getString("cycleNom_Ar"));
			
			Filiere filiere = new Filiere();
			filiere.setId(rs.getInt("filiereID"));
			filiere.setCode(rs.getString("filiereCode"));
			filiere.setNom_Fr(rs.getString("filiereNom_Fr"));
			filiere.setNom_Ar(rs.getString("filiereNom_Ar"));
			
			Niveau niveau= new Niveau();
			niveau.setId(rs.getInt("niveauID"));
			niveau.setCode(rs.getString("niveauCode"));
			niveau.setNom_Fr(rs.getString("niveauNom_Fr"));
			niveau.setNom_Ar(rs.getString("niveauNom_Ar"));
			
			ClasseGenerique classeGenerique =new ClasseGenerique();
			classeGenerique.setCycle(cycle);
			classeGenerique.setFiliere(filiere);
			classeGenerique.setNiveau(niveau);
			classeGenerique.setId(rs.getInt("classegeneriqueID"));
			classeGenerique.setDescription(rs.getString("Description"));
			classeGenerique.setCode();
			
			Unite unite= new Unite();
			unite.setId(rs.getInt("uniteID"));
			unite.setCode(rs.getString("uniteCode"));
			unite.setNom_Fr(rs.getString("uniteNom_Fr"));
			unite.setNom_Ar(rs.getString("uniteNom_Ar"));
			
			classeGUniteResult = new ClasseGUnite();
			classeGUniteResult.setId(rs.getInt("classeguniteID"));
			classeGUniteResult.setNoteEliminatoire(rs.getFloat("NoteEliminatoire"));
			classeGUniteResult.setClasseGenerique(classeGenerique);
			classeGUniteResult.setUnite(unite);
			
			
		}
		rs.close();
		statement.close();
		return classeGUniteResult;
	}
	
	public void delete(ClasseGUnite classeGUnite) throws SQLException{
		String query="DELETE FROM `classegunite`\r\n" + 
				"	WHERE  \r\n" + 
				"	`ID` = ?;";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, classeGUnite.getId());
		statement.execute();
		statement.close();
	}
	public void update(ClasseGUnite classeGUnite) throws SQLException{
		String query="UPDATE `classegunite` SET	\r\n" + 
					"	`UniteID`= ? , \r\n" + 
					"	`NoteEliminatoire` = ? \r\n" + 
					"	WHERE	\r\n" + 
					"	`ID` = ? ;";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, classeGUnite.getUnite().getId());
		statement.setFloat(2, classeGUnite.getNoteEliminatoire());
		statement.setInt(3, classeGUnite.getId());
		statement.execute();
		statement.close();
	}
	public ClasseGUnite exists2 (ClasseGUnite classeGUnite) throws SQLException{
		String query="SELECT  \r\n" + 
				"`ID` ,\r\n" + 
				"`ClasseGeneriqueID` ,\r\n" + 
				"`UniteID` ,\r\n" + 
				"`NoteEliminatoire`\r\n" + 
				" FROM `classegunite` \r\n" + 
				" WHERE  \r\n" + 
				" `ClasseGeneriqueID` = ? AND \r\n" + 
				" `UniteID` = ? ;\r\n"; 
				
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, classeGUnite.getClasseGenerique().getId());
		statement.setInt(2, classeGUnite.getUnite().getId());
		ResultSet rs = statement.executeQuery();
		ClasseGUnite classeGUniteResult = null;
		while (rs.next()) {
			classeGUniteResult = new ClasseGUnite();
			Unite unite = new Unite();
			unite.setId(Integer.parseInt(rs.getString("UniteID")));
			
			ClasseGenerique classeGenerique = new ClasseGenerique();
			classeGenerique.setId(Integer.parseInt(rs.getString("ClasseGeneriqueID")));
			
			classeGUniteResult.setId(rs.getInt("ID"));
			classeGUniteResult.setNoteEliminatoire(Float.parseFloat(rs.getString("NoteEliminatoire")));
			classeGUniteResult.setClasseGenerique(classeGenerique);
			classeGUniteResult.setUnite(unite);
			
		}
		rs.close();
		statement.close();
		return classeGUniteResult;	
	}
	
}
