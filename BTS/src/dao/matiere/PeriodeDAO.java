package dao.matiere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.matiere.Periode;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class PeriodeDAO {
	private Connection con;
	public PeriodeDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(Periode periode) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into periode (ID, Code, Nom_Fr, Nom_Ar) values (null, ?, ?, ?)");
		statement.setString(1, periode.getCode());
		statement.setString(2, periode.getNom_Fr());
		statement.setString(3, periode.getNom_Ar());
		statement.execute();
		statement.close();
	}
	public ArrayList<Periode> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from periode");
		ResultSet rs = statement.executeQuery();
		ArrayList<Periode> periodes = new ArrayList<Periode>();
		while (rs.next()) {
			Periode periode = new Periode();
			periode.setId(rs.getInt("ID"));
			periode.setCode(rs.getString("Code"));
			periode.setNom_Fr(rs.getString("Nom_Fr"));
			periode.setNom_Ar(rs.getString("Nom_Ar"));
			periodes.add(periode);
		}
		rs.close();
		statement.close();
		return periodes;	
	}
	public Periode getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from periode where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		Periode periode = new Periode();
		while (rs.next()) {
			periode.setId(rs.getInt("ID"));
			periode.setCode(rs.getString("Code"));
			periode.setNom_Fr(rs.getString("Nom_Fr"));
			periode.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return periode;		
	}
	public void update (Periode periode) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update periode set Code = ?, Nom_Fr = ?, Nom_Ar = ? where ID = ?");
		statement.setString(1, periode.getCode());
		statement.setString(2, periode.getNom_Fr());
		statement.setString(3, periode.getNom_Ar());
		statement.setInt(4,periode.getId());
		statement.execute();
	}
	public void delete(Periode periode) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from periode where ID = ?");
		statement.setInt(1, periode.getId());
		statement.execute();
		statement.close();
	}
}
