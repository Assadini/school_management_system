package dao.etudiant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.etudiant.Mention;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class MentionDAO {
	private Connection con;
	public MentionDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(Mention mention) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into mention (ID, Code, Nom_Fr, Nom_Ar) values (null, ?, ?, ?)");
		statement.setString(1, mention.getCode());
		statement.setString(2, mention.getNom_Fr());
		statement.setString(3, mention.getNom_Ar());
		statement.execute();
		statement.close();
	}
	public ArrayList<Mention> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from mention");
		ResultSet rs = statement.executeQuery();
		ArrayList<Mention> mentions = new ArrayList<Mention>();
		while (rs.next()) {
			Mention mention = new Mention();
			mention.setId(rs.getInt("ID"));
			mention.setCode(rs.getString("Code"));
			mention.setNom_Fr(rs.getString("Nom_Fr"));
			mention.setNom_Ar(rs.getString("Nom_Ar"));
			mentions.add(mention);
		}
		rs.close();
		statement.close();
		return mentions;	
	}
	public Mention getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from mention where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		Mention mention = new Mention();
		while (rs.next()) {
			mention.setId(rs.getInt("ID"));
			mention.setCode(rs.getString("Code"));
			mention.setNom_Fr(rs.getString("Nom_Fr"));
			mention.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return mention;		
	}
	public void update (Mention mention) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update mention set Code = ?, Nom_Fr = ?, Nom_Ar = ?  where ID = ?");
		statement.setString(1, mention.getCode());
		statement.setString(2, mention.getNom_Fr());
		statement.setString(3, mention.getNom_Ar());
		statement.setInt(4,mention.getId());
		statement.execute();
	}
	public void delete(Mention mention) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from mention where ID = ?");
		statement.setInt(1, mention.getId());
		statement.execute();
		statement.close();
	}
}
