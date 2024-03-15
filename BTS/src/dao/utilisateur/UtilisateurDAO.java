package dao.utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.utilisateur.Utilisateur;
import Domaine.securite.Compte;
import Domaine.securite.Role;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.database.Db;

public class UtilisateurDAO {
	private Connection con;
	public UtilisateurDAO(){
		
		this.con = Db.getInstance().con;
	}
	
	public Utilisateur authentificate(String login,String password) throws SQLException{
		
		String query="SELECT \r\n" + 
				"	`utilisateur`.`ID` AS utilisateurID,\r\n" + 
				"	`utilisateur`.`Nom_Fr` AS utilisateurNom_Fr,\r\n" + 
				"	`utilisateur`.`Prenom_Fr` AS utilisateurPrenom_Fr,\r\n" + 
				"	`utilisateur`.`Nom_Ar` AS utilisateurNom_Ar,\r\n" + 
				"	`utilisateur`.`Prenom_Ar` AS utilisateurPrenom_Ar,\r\n" + 
				"	`utilisateur`.`Photo`,\r\n" + 
				"	`compte`.`ID` AS CompteID, \r\n" + 
				"	`compte`.`Etat` AS CompteEtat, \r\n" + 
				"	`role`.`ID` AS `RoleID`, \r\n" + 
				"	`role`.`Code` AS `RoleCode`, \r\n" +
				"	`role`.`Nom_Fr` as RoleNomFr \r\n" + 
				"	FROM \r\n" + 
				"	`compte`, `role`, `utilisateur` \r\n" + 
				"	WHERE \r\n" + 
				"	(`compte`.`RoleID` = `role`.`ID` ) AND\r\n" + 
				"	(`compte`.`UtilisateurID` = `utilisateur`.`ID`) AND\r\n" + 
				"	(`compte`.`Login` = ?  AND `compte`.`MotPass` = ?);";
		
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setString(1, login);
		statement.setString(2, password);
		ResultSet rs = statement.executeQuery();
		Utilisateur utilisateur = null;
		while (rs.next()) {
			utilisateur = new Utilisateur();
			utilisateur.setId(rs.getInt("utilisateurID"));
			utilisateur.setNom_Fr(rs.getString("utilisateurNom_Fr"));
			utilisateur.setPrenom_Fr(rs.getString("utilisateurPrenom_Fr"));
			utilisateur.setNom_Ar(rs.getString("utilisateurNom_Ar"));
			utilisateur.setPrenom_Ar(rs.getString("utilisateurPrenom_Ar"));
			utilisateur.setPhoto(rs.getString("Photo"));
			
			Compte compte = new Compte();
			compte.setId(rs.getInt("CompteID"));
			compte.setEtat(rs.getString("CompteEtat"));
			
			Role role=new Role();
			role.setId(rs.getInt("RoleID"));
			role.setCode(rs.getString("RoleCode"));
			role.setNom_Fr(rs.getString("RoleNomFr"));
			
			compte.setRole(role);
			utilisateur.addCompte(compte);
		}
		rs.close();
		statement.close();
		return utilisateur;		
	}
	
	/*
	 * Inserre un nouveau Utlisateur et retourne son ID
	 */
	
	public int insert(Utilisateur utilisateur) throws SQLException{
		
		String query="INSERT INTO `utilisateur` (\r\n" + 
				"`ID` ,\r\n" + 
				"`Photo` ,\r\n" + 
				"`Nom_Fr` ,\r\n" + 
				"`Prenom_Fr` ,\r\n" + 
				"`Nom_Ar` ,\r\n" + 
				"`Prenom_Ar` ,\r\n" + 
				"`Sexe` ,\r\n" + 
				"`Titre` ,\r\n" + 
				"`Cin` ,\r\n" + 
				"`Nationalite` ,\r\n" + 
				"`DateNais` ,\r\n" + 
				"`LieuNais_Fr` ,\r\n" + 
				"`LieuNais_Ar` ,\r\n" + 
				"`Adresse_Fr` ,\r\n" + 
				"`Adresse_Ar` ,\r\n" + 
				"`Email` ,\r\n" + 
				"`SituationF` ,\r\n" + 
				"`TeleMobile` ,\r\n" + 
				"`TeleDomicile`\r\n" + 
				")\r\n" + 
				"VALUES (\r\n" + 
				"NULL , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? );";
		
		
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, utilisateur.getPhoto());
		statement.setString(2, utilisateur.getNom_Fr());
		statement.setString(3, utilisateur.getPrenom_Fr());
		statement.setString(4, utilisateur.getNom_Ar());
		statement.setString(5, utilisateur.getPrenom_Ar());
		statement.setString(6, utilisateur.getSexe());
		statement.setString(7, utilisateur.getTitre());
		statement.setString(8, utilisateur.getCin());
		statement.setString(9, utilisateur.getNationalite());
		if(utilisateur.getDateNais()!=null){
		statement.setDate(10, new java.sql.Date(utilisateur.getDateNais().getTime()));
		}else{
		statement.setDate(10, null);	
		}
		statement.setString(11, utilisateur.getLieuNais_Fr());
		statement.setString(12, utilisateur.getLieuNais_Ar());
		statement.setString(13, utilisateur.getAdresse_Fr());
		statement.setString(14, utilisateur.getAdresse_Ar());
		statement.setString(15, utilisateur.getEmail());
		statement.setString(16, utilisateur.getSituationF());
		statement.setString(17, utilisateur.getTeleMobile());
		statement.setString(18, utilisateur.getTeleDomicile());
		
		int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Impossible d'inserer l'utilisateur, aucun enregistrement n'est affecté");
            
        }
        
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return (int) generatedKeys.getLong(1);
        }
        else {
            throw new SQLException("Impossible d'inserer l'utilisateur, impossible d'obtenir l'ID ");
        }
    }
	public ArrayList<Utilisateur> getAll() throws SQLException{
		String query="SELECT \r\n" + 
		"	`utilisateur`.`ID`,\r\n" +
		"	`utilisateur`.`Titre`,\r\n" +
		"	`utilisateur`.`Sexe`,\r\n" +
		"	`utilisateur`.`Cin`,\r\n" +
		"	`utilisateur`.`Nom_Fr`,\r\n" + 
		"	`utilisateur`.`Prenom_Fr`,\r\n" + 
		"	`utilisateur`.`Nom_Ar`,\r\n" + 
		"	`utilisateur`.`Prenom_Ar`,\r\n" + 
		"	`utilisateur`.`Nationalite`,\r\n" + 
		"	`utilisateur`.`DateNais`,\r\n" +
		"	`utilisateur`.`LieuNais_Fr`,\r\n" +
		"	`utilisateur`.`LieuNais_Ar`,\r\n" +
		"	`utilisateur`.`Adresse_Fr`,\r\n" +
		"	`utilisateur`.`Adresse_Ar`,\r\n" +
		"	`utilisateur`.`Email`,\r\n" +
		"	`utilisateur`.`SituationF`,\r\n" +
		"	`utilisateur`.`TeleMobile`,\r\n" +
		"	`utilisateur`.`TeleDomicile`,\r\n" +
		"	`utilisateur`.`Photo`\r\n" +
		"	FROM \r\n" + 
		"	`utilisateur` ;";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		while (rs.next()) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setId(rs.getInt("ID"));
			utilisateur.setTitre(rs.getString("Titre"));
			utilisateur.setSexe(rs.getString("Sexe"));
			utilisateur.setCin(rs.getString("Cin"));
			utilisateur.setNom_Fr(rs.getString("Nom_Fr"));
			utilisateur.setPrenom_Fr(rs.getString("Prenom_Fr"));
			utilisateur.setNom_Ar(rs.getString("Nom_Ar"));
			utilisateur.setPrenom_Ar(rs.getString("Prenom_Ar"));
			utilisateur.setNationalite(rs.getString("Nationalite"));
			utilisateur.setDateNais(rs.getDate("DateNais"));
			utilisateur.setLieuNais_Fr(rs.getString("LieuNais_Fr"));
			utilisateur.setLieuNais_Ar(rs.getString("LieuNais_Ar"));
			utilisateur.setAdresse_Fr(rs.getString("Adresse_Fr"));
			utilisateur.setAdresse_Ar(rs.getString("Adresse_Ar"));
			utilisateur.setEmail(rs.getString("Email"));
			utilisateur.setSituationF(rs.getString("SituationF"));
			utilisateur.setTeleMobile(rs.getString("TeleMobile"));
			utilisateur.setTeleDomicile(rs.getString("TeleDomicile"));
			utilisateur.setPhoto(rs.getString("Photo"));
			
			utilisateurs.add(utilisateur);
		}
		rs.close();
		statement.close();
		return utilisateurs;	
	}
	public void update(Utilisateur utilisateur) throws SQLException{
		
		String query="UPDATE `utilisateur` SET \r\n" + 
				"`Photo` = ?  ,\r\n" + 
				"`Nom_Fr` = ? ,\r\n" + 
				"`Prenom_Fr` = ? ,\r\n" + 
				"`Nom_Ar` = ? ,\r\n" + 
				"`Prenom_Ar` = ? ,\r\n" + 
				"`Sexe` = ? ,\r\n" + 
				"`Titre` = ? ,\r\n" + 
				"`Cin` = ? ,\r\n" + 
				"`Nationalite` = ? ,\r\n" + 
				"`DateNais` = ? ,\r\n" + 
				"`LieuNais_Fr` = ? ,\r\n" + 
				"`LieuNais_Ar` = ? ,\r\n" + 
				"`Adresse_Fr` = ? ,\r\n" + 
				"`Adresse_Ar` = ? ,\r\n" + 
				"`Email` = ? ,\r\n" + 
				"`SituationF` = ? ,\r\n" + 
				"`TeleMobile` = ? ,\r\n" + 
				"`TeleDomicile` = ? \r\n" +
				"WHERE  \r\n" + 
				" `ID` = ? ;";
		
		
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, utilisateur.getPhoto());
		statement.setString(2, utilisateur.getNom_Fr());
		statement.setString(3, utilisateur.getPrenom_Fr());
		statement.setString(4, utilisateur.getNom_Ar());
		statement.setString(5, utilisateur.getPrenom_Ar());
		statement.setString(6, utilisateur.getSexe());
		statement.setString(7, utilisateur.getTitre());
		statement.setString(8, utilisateur.getCin());
		statement.setString(9, utilisateur.getNationalite());
		if(utilisateur.getDateNais()!=null){
		statement.setDate(10, new java.sql.Date(utilisateur.getDateNais().getTime()));
		}else{
		statement.setDate(10, null);	
		}
		statement.setString(11, utilisateur.getLieuNais_Fr());
		statement.setString(12, utilisateur.getLieuNais_Ar());
		statement.setString(13, utilisateur.getAdresse_Fr());
		statement.setString(14, utilisateur.getAdresse_Ar());
		statement.setString(15, utilisateur.getEmail());
		statement.setString(16, utilisateur.getSituationF());
		statement.setString(17, utilisateur.getTeleMobile());
		statement.setString(18, utilisateur.getTeleDomicile());
		statement.setInt(19, utilisateur.getId());
		statement.executeUpdate();

    }
	public void delete(Utilisateur utilisateur) throws SQLException{
		
		String query="DELETE FROM `utilisateur`\r\n" +  
				"WHERE \r\n" + 
				" `utilisateur`.`ID` = ? ;";
		
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, utilisateur.getId());
		statement.executeUpdate();
    }
}
