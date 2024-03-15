package dao.matiere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.matiere.Matiere;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class MatiereDAO {
	private Connection con;
	public MatiereDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(Matiere matiere) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into matiere (ID, Code, Nom_Fr, Nom_Ar) values (null, ?, ?, ?)");
		statement.setString(1, matiere.getCode());
		statement.setString(2, matiere.getNom_Fr());
		statement.setString(3, matiere.getNom_Ar());
		statement.execute();
		statement.close();
	}
	public ArrayList<Matiere> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from matiere");
		ResultSet rs = statement.executeQuery();
		ArrayList<Matiere> matieres = new ArrayList<Matiere>();
		while (rs.next()) {
			Matiere matiere = new Matiere();
			matiere.setId(rs.getInt("ID"));
			matiere.setCode(rs.getString("Code"));
			matiere.setNom_Fr(rs.getString("Nom_Fr"));
			matiere.setNom_Ar(rs.getString("Nom_Ar"));
			matieres.add(matiere);
		}
		rs.close();
		statement.close();
		return matieres;	
	}
	public Matiere getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from matiere where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		Matiere matiere = new Matiere();
		while (rs.next()) {
			matiere.setId(rs.getInt("ID"));
			matiere.setCode(rs.getString("Code"));
			matiere.setNom_Fr(rs.getString("Nom_Fr"));
			matiere.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return matiere;		
	}
	public void update (Matiere matiere) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update matiere set Code = ?, Nom_Fr = ?, Nom_Ar = ? where ID = ?");
		statement.setString(1, matiere.getCode());
		statement.setString(2, matiere.getNom_Fr());
		statement.setString(3, matiere.getNom_Ar());
		statement.setInt(4,matiere.getId());
		statement.execute();
	}
	public void delete(Matiere matiere) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from matiere where ID = ?");
		statement.setInt(1, matiere.getId());
		statement.execute();
		statement.close();
	}
}
