package dao.matiere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.matiere.Unite;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class UniteDAO {
	private Connection con;
	public UniteDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(Unite unite) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into unite (ID, Code, Nom_Fr, Nom_Ar) values (null, ?, ?, ?)");
		statement.setString(1, unite.getCode());
		statement.setString(2, unite.getNom_Fr());
		statement.setString(3, unite.getNom_Ar());
		statement.execute();
		statement.close();
	}
	public ArrayList<Unite> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from unite");
		ResultSet rs = statement.executeQuery();
		ArrayList<Unite> unites = new ArrayList<Unite>();
		while (rs.next()) {
			Unite unite = new Unite();
			unite.setId(rs.getInt("ID"));
			unite.setCode(rs.getString("Code"));
			unite.setNom_Fr(rs.getString("Nom_Fr"));
			unite.setNom_Ar(rs.getString("Nom_Ar"));
			unites.add(unite);
		}
		rs.close();
		statement.close();
		return unites;	
	}
	public Unite getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from unite where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		Unite unite = new Unite();
		while (rs.next()) {
			unite.setId(rs.getInt("ID"));
			unite.setCode(rs.getString("Code"));
			unite.setNom_Fr(rs.getString("Nom_Fr"));
			unite.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return unite;		
	}
	public void update (Unite unite) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update unite set Code = ?, Nom_Fr = ?, Nom_Ar = ? where ID = ?");
		statement.setString(1, unite.getCode());
		statement.setString(2, unite.getNom_Fr());
		statement.setString(3, unite.getNom_Ar());
		statement.setInt(4,unite.getId());
		statement.execute();
	}
	public void delete(Unite unite) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from unite where ID = ?");
		statement.setInt(1, unite.getId());
		statement.execute();
		statement.close();
	}
}
