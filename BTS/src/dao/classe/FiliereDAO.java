package dao.classe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.classe.Filiere;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class FiliereDAO {
	private Connection con;
	public FiliereDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(Filiere filiere) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into filiere (ID, Code, Nom_Fr, Nom_Ar) values (null, ?, ?, ?)");
		statement.setString(1, filiere.getCode());
		statement.setString(2, filiere.getNom_Fr());
		statement.setString(3, filiere.getNom_Ar());
		statement.execute();
		statement.close();
	}
	public ArrayList<Filiere> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from filiere");
		ResultSet rs = statement.executeQuery();
		ArrayList<Filiere> filieres = new ArrayList<Filiere>();
		while (rs.next()) {
			Filiere filiere = new Filiere();
			filiere.setId(rs.getInt("ID"));
			filiere.setCode(rs.getString("Code"));
			filiere.setNom_Fr(rs.getString("Nom_Fr"));
			filiere.setNom_Ar(rs.getString("Nom_Ar"));
			filieres.add(filiere);
		}
		rs.close();
		statement.close();
		return filieres;	
	}
	public Filiere getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from filiere where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		Filiere filiere = new Filiere();
		while (rs.next()) {
			filiere.setId(rs.getInt("ID"));
			filiere.setCode(rs.getString("Code"));
			filiere.setNom_Fr(rs.getString("Nom_Fr"));
			filiere.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return filiere;		
	}
	public void update (Filiere filiere) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update filiere set Code = ?, Nom_Fr = ?, Nom_Ar = ?  where ID = ?");
		statement.setString(1, filiere.getCode());
		statement.setString(2, filiere.getNom_Fr());
		statement.setString(3, filiere.getNom_Ar());
		statement.setInt(4,filiere.getId());
		statement.execute();
	}
	public void delete(Filiere filiere) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from filiere where ID = ?");
		statement.setInt(1, filiere.getId());
		statement.execute();
		statement.close();
	}
}
