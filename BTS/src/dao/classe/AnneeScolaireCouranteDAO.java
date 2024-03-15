package dao.classe;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.classe.AnneeScolaire;
import Domaine.classe.AnneeScolaireCourante;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class AnneeScolaireCouranteDAO {
	private Connection con;
	public AnneeScolaireCouranteDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(AnneeScolaireCourante anneeScolaireCourante) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into AnneeScolaireCourante (ID, AnneeScolaireID) values (null, ?)");
		statement.setInt(1,anneeScolaireCourante.getId());
		statement.execute();
		statement.close();
	}
	public ArrayList<AnneeScolaireCourante> getAll() throws SQLException{
		String query = "SELECT \r\n" + 
		"	`anneescolairecourante`.`ID` AS `AnneeScolaireCouranteID`,\r\n" + 
		"	`anneescolaire`.`ID` AS `AnneeScolaireID`,\r\n" + 
		"	`anneescolaire`.`Code` AS `AnneeScolaireCode`,\r\n" + 
		"	`anneescolaire`.`DateDebut` AS `DateDebut`,\r\n" +
		"	`anneescolaire`.`DateFin` AS `DateFin`\r\n" +
		"	FROM `anneescolairecourante`, `Anneescolaire`\r\n" + 
		"	WHERE \r\n" + 
		"	(`anneescolairecourante`.`AnneeScolaireID`= `anneescolaire`.`ID`);";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		ArrayList<AnneeScolaireCourante> anneeScolaireCourantes = new ArrayList<AnneeScolaireCourante>();
		while (rs.next()) {
			AnneeScolaireCourante anneeScolaireCourante = new AnneeScolaireCourante();
			anneeScolaireCourante.setId(rs.getInt("AnneeScolaireCouranteID"));
			AnneeScolaire anneeScolaire = new AnneeScolaire();
			anneeScolaire.setId(rs.getInt("AnneeScolaireID"));
			anneeScolaire.setCode(rs.getString("AnneeScolaireCode"));
			anneeScolaire.setDateDebut(rs.getDate("DateDebut"));
			anneeScolaire.setDateFin(rs.getDate("DateFin"));
			
			anneeScolaireCourante.setAnneeScolaire(anneeScolaire);
			anneeScolaireCourantes.add(anneeScolaireCourante);
		}
		rs.close();
		statement.close();
		return anneeScolaireCourantes;	
	}
	public AnneeScolaireCourante getById(int id) throws SQLException{
		String query = "SELECT \r\n" + 
		"	`anneescolairecourante`.`ID` AS `AnneeScolaireCouranteID`,\r\n" + 
		"	`anneescolaire`.`ID` AS `AnneeScolaireID`,\r\n" + 
		"	`anneescolaire`.`Code` AS `AnneeScolaireCode`,\r\n" + 
		"	`anneescolaire`.`DateDebut` AS `DateDebut`,\r\n" +
		"	`anneescolaire`.`DateFin` AS `DateFin`\r\n" +
		"	FROM `anneescolairecourante`, `Anneescolaire`\r\n" + 
		"	WHERE \r\n" + 
		"	(`anneescolairecourante`.`ID`= `anneescolaire`.`ID`) AND \r\\n" +
		"	(`anneescolairecourante`.`ID`= ?);";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		AnneeScolaireCourante anneeScolaireCourante = new AnneeScolaireCourante();
		while (rs.next()) {
			anneeScolaireCourante.setId(rs.getInt("AnneeScolaireCouranteID"));
			AnneeScolaire anneeScolaire = new AnneeScolaire();
			anneeScolaire.setId(rs.getInt("AnneeScolaireID"));
			anneeScolaire.setCode(rs.getString("AnneeScolaireCode"));
			anneeScolaire.setDateDebut(rs.getDate("DateDebut"));
			anneeScolaire.setDateFin(rs.getDate("DateFin"));
			
			anneeScolaireCourante.setAnneeScolaire(anneeScolaire);
		}
		rs.close();
		statement.close();
		return anneeScolaireCourante;		
	}
	public void update (AnneeScolaireCourante anneeScolaireCourante) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update AnneeScolaireCourante set AnneeScolaireID = ?");
		statement.setInt(1,anneeScolaireCourante.getAnneeScolaire().getId());
		statement.execute();
	}
	public void delete(AnneeScolaireCourante anneeScolaireCourante) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from AnneeScolaireCourante where ID = ?");
			statement.setInt(1, anneeScolaireCourante.getId());
			statement.execute();
			statement.close();
		}
	}
