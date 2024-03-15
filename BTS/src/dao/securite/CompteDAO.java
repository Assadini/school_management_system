package dao.securite;


import java.sql.SQLException;

import Domaine.securite.Compte;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.database.Db;

public class CompteDAO {
	private Connection con;
	
	public CompteDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(Compte compte) throws SQLException{
		String query="INSERT INTO `compte` \r\n" + 
				"(`ID`, \r\n" + 
				"`RoleID`, \r\n" + 
				"`UtilisateurID`, \r\n" + 
				"`Login`, \r\n" + 
				"`MotPass`, \r\n" + 
				"`DateCreation`, \r\n" + 
				"`Etat`, \r\n" +
				"`OnLine`, \r\n" + 
				"`Statut`) \r\n" + 
				"VALUES \r\n" + 
				"(NULL, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, compte.getRole().getId());
		statement.setInt(2, compte.getUtilisateur().getId());
		statement.setString(3, compte.getLogin());
		statement.setString(4, compte.getMotPass());
		if(compte.getDateCreation()!=null){
			statement.setDate(5, new java.sql.Date(compte.getDateCreation().getTime()));
			}else{
			statement.setDate(5, null);	
		}
		statement.setString(6, compte.getEtat());
		statement.setBoolean(7, compte.isOnLine());
		statement.setString(8, compte.getStatut());
		
		statement.execute();
		statement.close();	
	}
	public void updateOnLine(Compte compte) throws SQLException{
		String query="Update `compte` \r\n" + 
				" SET \r\n" + 
				"`OnLine` = ?  \r\n" + 
				" WHERE \r\n" + 
				" `ID` =  ?;";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setBoolean(1, compte.isOnLine());
		statement.setInt(2, compte.getId());
		statement.execute();
		statement.close();	
	}
}
