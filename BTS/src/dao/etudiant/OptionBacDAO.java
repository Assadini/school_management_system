package dao.etudiant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.etudiant.OptionBac;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class OptionBacDAO {
	private Connection con;
	public OptionBacDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(OptionBac optionBac) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into optionBac (ID, Code, Nom_Fr, Nom_Ar) values (null, ?, ?, ?)");
		statement.setString(1, optionBac.getCode());
		statement.setString(2, optionBac.getNom_Fr());
		statement.setString(3, optionBac.getNom_Ar());
		statement.execute();
		statement.close();
	}
	public ArrayList<OptionBac> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from optionBac");
		ResultSet rs = statement.executeQuery();
		ArrayList<OptionBac> optionBacs = new ArrayList<OptionBac>();
		while (rs.next()) {
			OptionBac optionBac = new OptionBac();
			optionBac.setId(rs.getInt("ID"));
			optionBac.setCode(rs.getString("Code"));
			optionBac.setNom_Fr(rs.getString("Nom_Fr"));
			optionBac.setNom_Ar(rs.getString("Nom_Ar"));
			optionBacs.add(optionBac);
		}
		rs.close();
		statement.close();
		return optionBacs;	
	}
	public OptionBac getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from optionBac where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		OptionBac optionBac = new OptionBac();
		while (rs.next()) {
			optionBac.setId(rs.getInt("ID"));
			optionBac.setCode(rs.getString("Code"));
			optionBac.setNom_Fr(rs.getString("Nom_Fr"));
			optionBac.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return optionBac;		
	}
	public void update (OptionBac optionBac) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update optionBac set Code = ?, Nom_Fr = ?, Nom_Ar = ?  where ID = ?");
		statement.setString(1, optionBac.getCode());
		statement.setString(2, optionBac.getNom_Fr());
		statement.setString(3, optionBac.getNom_Ar());
		statement.setInt(4,optionBac.getId());
		statement.execute();
	}
	public void delete(OptionBac optionBac) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from optionBac where ID = ?");
		statement.setInt(1, optionBac.getId());
		statement.execute();
		statement.close();
	}
}
