package dao.classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.classe.ClasseGenerique;
import Domaine.classe.Cycle;
import Domaine.classe.Filiere;
import Domaine.classe.Niveau;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.database.Db;

public class ClasseGeneriqueDAO {
	private Connection con;
	
	public ClasseGeneriqueDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(ClasseGenerique classeGenerique) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into classegenerique (ID, CycleID, FiliereID, NiveauID, Description) values (null, ?, ?, ?, ?)");
		statement.setInt(1, classeGenerique.getCycle().getId());
		statement.setInt(2, classeGenerique.getFiliere().getId());
		statement.setInt(3, classeGenerique.getNiveau().getId());
		statement.setString(4, classeGenerique.getDescription());
		statement.execute();
		statement.close();
	}
	public ArrayList<ClasseGenerique> getAll() throws SQLException{
		String query = "SELECT \r\n" + 
				"	`classegenerique`.`ID` AS `classegeneriqueID`,\r\n" + 
				"	`classegenerique`.`Description`,\r\n" + 
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
				"	FROM `classegenerique`, `cycle`, `filiere`, `niveau`\r\n" + 
				"	WHERE \r\n" + 
				"	(`classegenerique`.`CycleID`= `cycle`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`FiliereID`= `filiere`.`ID`) AND\r\n" + 
				"	(`classegenerique`.`NiveauID`= `niveau`.`ID`)\r\n" + 
				"	;\r\n";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		ArrayList<ClasseGenerique> classesGeneriques = new ArrayList<ClasseGenerique>();
		
		while (rs.next()) {
			ClasseGenerique classeGenerique =new ClasseGenerique();
			
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
			
			classeGenerique.setCycle(cycle);
			classeGenerique.setFiliere(filiere);
			classeGenerique.setNiveau(niveau);
			
			classeGenerique.setId(rs.getInt("classegeneriqueID"));
			classeGenerique.setDescription(rs.getString("Description"));
			classeGenerique.setCode();
			
			classesGeneriques.add(classeGenerique);
		}
		rs.close();
		statement.close();
		return classesGeneriques;
	}
	public ClasseGenerique getById(int id) throws SQLException{
		String query = "SELECT \r\n" + 
		"	`classegenerique`.`ID` AS `classegeneriqueID`,\r\n" + 
		"	`classegenerique`.`Description`,\r\n" + 
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
		"	FROM `classegenerique`, `cycle`, `filiere`, `niveau`\r\n" + 
		"	WHERE \r\n" + 
		"	(`classegenerique`.`CycleID`= `cycle`.`ID`) AND\r\n" + 
		"	(`classegenerique`.`FiliereID`= `filiere`.`ID`) AND\r\n" + 
		"	(`classegenerique`.`NiveauID`= `niveau`.`ID`) AND \r\n" + 
		"	`classegenerique`.`ID`=? ;";
		
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		ClasseGenerique classeGenerique =new ClasseGenerique();
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
			
			classeGenerique.setCycle(cycle);
			classeGenerique.setFiliere(filiere);
			classeGenerique.setNiveau(niveau);
			
			classeGenerique.setId(rs.getInt("classegeneriqueID"));
			classeGenerique.setDescription(rs.getString("Description"));
			classeGenerique.setCode();
			
		}
		rs.close();
		statement.close();
		return classeGenerique;
	}
	public void delete(ClasseGenerique classeGenerique) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from classegenerique where ID = ?");
		statement.setInt(1, classeGenerique.getId());
		statement.execute();
		statement.close();
	}
	public void update(ClasseGenerique classeGenerique) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update classegenerique set  CycleID = ?, FiliereID = ?, NiveauID = ?, Description = ? where ID = ?");
		statement.setInt(1, classeGenerique.getCycle().getId());
		statement.setInt(2, classeGenerique.getFiliere().getId());
		statement.setInt(3, classeGenerique.getNiveau().getId());
		statement.setString(4, classeGenerique.getDescription());
		statement.setInt(5, classeGenerique.getId());
		statement.execute();
		statement.close();
	}
	/*
	 * Méthode pour vérifier si une Classe Générique existe déjà
	 * Renvoie la classe générique si elle existe 
	 * Renvoie null sinon
	 */
	
	public ClasseGenerique exists(ClasseGenerique classeGenerique) throws SQLException{
		String query = "SELECT 1, \r\n" + 
		"	`classegenerique`.`ID` AS `classegeneriqueID`,\r\n" + 
		"	`classegenerique`.`Description`,\r\n" + 
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
		"	FROM `classegenerique`, `cycle`, `filiere`, `niveau`\r\n" + 
		"	WHERE \r\n" + 
		"	(`classegenerique`.`CycleID`= `cycle`.`ID`) AND\r\n" + 
		"	(`classegenerique`.`FiliereID`= `filiere`.`ID`) AND\r\n" + 
		"	(`classegenerique`.`NiveauID`= `niveau`.`ID`) AND \r\n" + 
		"	(`classegenerique`.`CycleID`= ?) AND\r\n" + 
		"	(`classegenerique`.`FiliereID`= ?) AND\r\n" + 
		"	(`classegenerique`.`NiveauID`= ?) ;";
		
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, classeGenerique.getCycle().getId());
		statement.setInt(2, classeGenerique.getFiliere().getId());
		statement.setInt(3, classeGenerique.getNiveau().getId());
		
		ResultSet rs = statement.executeQuery();
		ClasseGenerique classeGeneriqueResult =null;
		while (rs.next()) {
			classeGeneriqueResult =new ClasseGenerique();
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
			
			classeGeneriqueResult.setCycle(cycle);
			classeGeneriqueResult.setFiliere(filiere);
			classeGeneriqueResult.setNiveau(niveau);
			
			classeGeneriqueResult.setId(rs.getInt("classegeneriqueID"));
			classeGeneriqueResult.setDescription(rs.getString("Description"));
			classeGeneriqueResult.setCode();
			
		}
		rs.close();
		statement.close();
		return classeGeneriqueResult;
	}

}
