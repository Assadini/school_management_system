package dao.classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.classe.Niveau;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class NiveauDAO {
	private Connection con;
	public NiveauDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(Niveau niveau) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into niveau (ID, Code, Nom_Fr, Nom_Ar) values (null, ?, ?, ?)");
		statement.setString(1, niveau.getCode());
		statement.setString(2, niveau.getNom_Fr());
		statement.setString(3, niveau.getNom_Ar());
		statement.execute();
		statement.close();
	}
	public ArrayList<Niveau> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from niveau");
		ResultSet rs = statement.executeQuery();
		ArrayList<Niveau> niveaus = new ArrayList<Niveau>();
		while (rs.next()) {
			Niveau niveau = new Niveau();
			niveau.setId(rs.getInt("ID"));
			niveau.setCode(rs.getString("Code"));
			niveau.setNom_Fr(rs.getString("Nom_Fr"));
			niveau.setNom_Ar(rs.getString("Nom_Ar"));
			niveaus.add(niveau);
		}
		rs.close();
		statement.close();
		return niveaus;	
	}
	public Niveau getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from niveau where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		Niveau niveau = new Niveau();
		while (rs.next()) {
			niveau.setId(rs.getInt("ID"));
			niveau.setCode(rs.getString("Code"));
			niveau.setNom_Fr(rs.getString("Nom_Fr"));
			niveau.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return niveau;		
	}
	public void update (Niveau niveau) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update niveau set Code = ?, Nom_Fr = ?, Nom_Ar = ?  where ID = ?");
		statement.setString(1, niveau.getCode());
		statement.setString(2, niveau.getNom_Fr());
		statement.setString(3, niveau.getNom_Ar());
		statement.setInt(4,niveau.getId());
		statement.execute();
	}
	public void delete(Niveau niveau) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from niveau where ID = ?");
		statement.setInt(1, niveau.getId());
		statement.execute();
		statement.close();
	}
}
