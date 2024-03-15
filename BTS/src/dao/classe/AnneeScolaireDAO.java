package dao.classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.classe.AnneeScolaire;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class AnneeScolaireDAO {
	private Connection con;
	public AnneeScolaireDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(AnneeScolaire anneeScolaire) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into AnneeScolaire (ID, Code,DateDebut,DateFin) values (null, ?, ?, ?)");
		statement.setString(1,anneeScolaire.getCode());
		statement.setDate(2,new java.sql.Date(anneeScolaire.getDateDebut().getTime()));
		statement.setDate(3,new java.sql.Date(anneeScolaire.getDateFin().getTime()));
		statement.execute();
		statement.close();
	}
	public ArrayList<AnneeScolaire> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, DateDebut, DateFin from AnneeScolaire");
		ResultSet rs = statement.executeQuery();
		ArrayList<AnneeScolaire> anneeScolaires = new ArrayList<AnneeScolaire>();
		while (rs.next()) {
			AnneeScolaire anneeScolaire = new AnneeScolaire();
			anneeScolaire.setId(rs.getInt("ID"));
			anneeScolaire.setCode(rs.getString("Code"));
			anneeScolaire.setDateDebut(rs.getDate("DateDebut"));
			anneeScolaire.setDateFin(rs.getDate("DateFin"));
			anneeScolaires.add(anneeScolaire);
		}
		rs.close();
		statement.close();
		return anneeScolaires;	
	}
	public AnneeScolaire getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, DateDebut, DateFin from AnneeScolaire where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		AnneeScolaire anneeScolaire = new AnneeScolaire();
		while (rs.next()) {
			anneeScolaire.setId(rs.getInt("ID"));
			anneeScolaire.setCode(rs.getString("Code"));
			anneeScolaire.setDateDebut(rs.getDate("DateDebut"));
			anneeScolaire.setDateFin(rs.getDate("DateFin"));
		}
		rs.close();
		statement.close();
		return anneeScolaire;		
	}
	public void update (AnneeScolaire anneeScolaire) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update AnneeScolaire set Code = ? , DateDebut = ?, DateFin = ? where ID = ?");
		statement.setString(1,anneeScolaire.getCode());
		statement.setDate(2,new java.sql.Date(anneeScolaire.getDateDebut().getTime()));
		statement.setDate(3,new java.sql.Date(anneeScolaire.getDateFin().getTime()));
		statement.setInt(4, anneeScolaire.getId());
		statement.execute();
	}
	public void delete(AnneeScolaire anneeScolaire) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from AnneeScolaire where ID = ?");
			statement.setInt(1, anneeScolaire.getId());
			statement.execute();
			statement.close();
		}
	}
