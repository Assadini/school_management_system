package dao.etudiant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.classe.Filiere;
import Domaine.etablissement.Etablissement;
import Domaine.etudiant.Etudiant;
import Domaine.etudiant.Mention;
import Domaine.etudiant.OptionBac;
import Domaine.etudiant.Parent;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class EtudiantDAO {
	private Connection con;
	public EtudiantDAO(){
		
		this.con = Db.getInstance().con;
	}
	public void insert(Etudiant etudiant)throws SQLException{
			String query="INSERT INTO `etudiant` (\r\n" + 
					"`UtilisateurID` ,\r\n" + 
					"`FiliereID` ,\r\n" +
					"`EtablissementID` ,\r\n" + 
					"`Cne` ,\r\n" + 
					"`NumInscription` ,\r\n" + 
					"`AnneeBac` ,\r\n" + 
					"`OptionBacID` ,\r\n" + 
					"`MoyenneBac` ,\r\n" + 
					"`MentionID` ,\r\n" + 
					"`Candidat` ,\r\n" + 
					"`Etat` ,\r\n" + 
					"`ParentUtilisateurID`\r\n" + 
					")\r\n" + 
					"VALUES (\r\n" + 
					"?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? );" ;
	
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, etudiant.getId());
		statement.setInt(2, etudiant.getFiliere().getId());
		statement.setInt(3, etudiant.getEtabOrigine().getId());
		statement.setString(4, etudiant.getCne());
		statement.setString(5, etudiant.getNumInscription());
		statement.setString(6, etudiant.getAnneeBac());
		statement.setInt(7, etudiant.getOptionBac().getId());
		statement.setFloat(8, etudiant.getMoyenneBac());
		statement.setInt(9, etudiant.getMentionBac().getId());
		statement.setString(10, etudiant.getCandidat());
		statement.setString(11, etudiant.getEtat());
		statement.setInt(12, etudiant.getParent().getId());
		
		statement.execute();
		statement.close();
	}
	public ArrayList<Etudiant> getAll() throws SQLException{
		String query="SELECT \r\n" + 
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
		"	`utilisateur`.`Photo`,\r\n" +
		"	`etudiant`.`UtilisateurID` as EtudiantID ,\r\n" +
		"	`etudiant`.`Cne`,\r\n" +
		"	`etudiant`.`NumInscription`,\r\n" +
		"	`etudiant`.`AnneeBac`,\r\n" +
		"	`etudiant`.`Candidat`,\r\n" +
		"	`etudiant`.`Etat`,\r\n" +
		"	`optionbac`.`ID` as OptionBacID,\r\n" +
		"	`optionbac`.`Code` as OptionBacCode,\r\n" +
		"	`optionbac`.`Nom_Fr` as OptionBacNom_Fr,\r\n" +
		"	`optionbac`.`Nom_Ar` as OptionBacNom_Ar,\r\n" +
		"	`etudiant`.`MoyenneBac`,\r\n" +
		"	`mention`.`ID` as MentionBacID,\r\n" +
		"	`mention`.`Code` as MentionBacCode,\r\n" +
		"	`mention`.`Nom_Fr` as MentionBacNom_Fr,\r\n" +
		"	`mention`.`Nom_Ar` as MentionBacNom_Ar,\r\n" +
		"	`filiere`.`ID` as FiliereID,\r\n" +
		"	`filiere`.`Code` as FiliereCode,\r\n" +
		"	`filiere`.`Nom_Fr` as FiliereNom_Fr,\r\n" +
		"	`filiere`.`Nom_Ar` as FiliereNom_Ar,\r\n" +
		"	`etablissement`.`ID` as EtablissementID,\r\n" +
		"	`etablissement`.`Code` as EtablissementCode,\r\n" +
		"	`etablissement`.`Nom_Fr` as EtablissementNom_Fr,\r\n" +
		"	`etablissement`.`Nom_Ar` as EtablissementNom_Ar,\r\n" +
		"	`etablissement`.`Adresse_Fr` as EtablissementAdresse_Fr,\r\n" +
		"	`etablissement`.`Adresse_Ar` as EtablissementAdresse_Ar,\r\n" +
		"	`etablissement`.`Telephone` as EtablissementTel,\r\n" +
		"	`etablissement`.`Email` as EtablissementEmail,\r\n" +
		"	`utilisateurParent`.`ID` AS `ParentID` ,\r\n" +
		"	`utilisateurParent`.`Titre` AS `TitreParent`,\r\n" +
		"	`utilisateurParent`.`Sexe` AS `SexeParent`,\r\n" +
		"	`utilisateurParent`.`Cin` AS `CinParent`,\r\n" +
		"	`utilisateurParent`.`Nom_Fr` AS `Nom_FrParent`,\r\n" + 
		"	`utilisateurParent`.`Prenom_Fr` AS `Prenom_FrParent`,\r\n" + 
		"	`utilisateurParent`.`Nom_Ar` AS `Nom_ArParent`,\r\n" + 
		"	`utilisateurParent`.`Prenom_Ar` AS `Prenom_ArParent`,\r\n" + 
		"	`utilisateurParent`.`Nationalite` AS `NationaliteParent`,\r\n" + 
		"	`utilisateurParent`.`DateNais` AS `DateNaisParent`,\r\n" +
		"	`utilisateurParent`.`LieuNais_Fr` AS `LieuNais_FrParent`,\r\n" +
		"	`utilisateurParent`.`LieuNais_Ar` AS `LieuNais_ArParent`,\r\n" +
		"	`utilisateurParent`.`Adresse_Fr` AS `Adresse_FrParent`,\r\n" +
		"	`utilisateurParent`.`Adresse_Ar` AS `Adresse_ArParent`,\r\n" +
		"	`utilisateurParent`.`Email` AS `EmailParent`,\r\n" +
		"	`utilisateurParent`.`SituationF` AS `SituationFParent`,\r\n" +
		"	`utilisateurParent`.`TeleMobile` AS `TeleMobileParent`,\r\n" +
		"	`utilisateurParent`.`TeleDomicile` AS `TeleDomicileParent`,\r\n" +
		"	`utilisateurParent`.`Photo` AS `PhotoParent`,\r\n" +
		"	`parent`.`LienParente`\r\n" +
		"	FROM \r\n" + 
		"	`utilisateur`, `etudiant`, `optionbac`, `mention`, `filiere`, `etablissement`,`utilisateur` AS `utilisateurParent`,`parent` \r\n" + 
		"	WHERE \r\n" + 
		"	(`etudiant`.`UtilisateurID` = `utilisateur`.`ID` ) AND\r\n" + 
		"	(`etudiant`.`OptionBacID` = `optionbac`.`ID`) AND\r\n" + 
		"	(`etudiant`.`MentionID` = `mention`.`ID`) AND\r\n" +
		"	(`etudiant`.`FiliereID` = `filiere`.`ID`) AND\r\n" + 
		"	(`etudiant`.`EtablissementID` = `etablissement`.`ID`) AND \r\n"+
		"	(`utilisateurParent`.`ID` = `etudiant`.`ParentUtilisateurID`) AND \r\n"+
		"	(`etudiant`.`ParentUtilisateurID` = `parent`.`UtilisateurID`);";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
		Etudiant etudiant=null;
		while (rs.next()) {
			etudiant = new Etudiant();
			etudiant.setId(rs.getInt("EtudiantID"));
			etudiant.setTitre(rs.getString("Titre"));
			etudiant.setSexe(rs.getString("Sexe"));
			etudiant.setCin(rs.getString("Cin"));
			etudiant.setNom_Fr(rs.getString("Nom_Fr"));
			etudiant.setPrenom_Fr(rs.getString("Prenom_Fr"));
			etudiant.setNom_Ar(rs.getString("Nom_Ar"));
			etudiant.setPrenom_Ar(rs.getString("Prenom_Ar"));
			etudiant.setNationalite(rs.getString("Nationalite"));
			etudiant.setDateNais(rs.getDate("DateNais"));
			etudiant.setLieuNais_Fr(rs.getString("LieuNais_Fr"));
			etudiant.setLieuNais_Ar(rs.getString("LieuNais_Ar"));
			etudiant.setAdresse_Fr(rs.getString("Adresse_Fr"));
			etudiant.setAdresse_Ar(rs.getString("Adresse_Ar"));
			etudiant.setEmail(rs.getString("Email"));
			etudiant.setSituationF(rs.getString("SituationF"));
			etudiant.setTeleMobile(rs.getString("TeleMobile"));
			etudiant.setTeleDomicile(rs.getString("TeleDomicile"));
			etudiant.setCne(rs.getString("Cne"));
			etudiant.setNumInscription(rs.getString("NumInscription"));
			etudiant.setAnneeBac(rs.getString("AnneeBac"));
			etudiant.setMoyenneBac(rs.getFloat("MoyenneBac"));
			etudiant.setCandidat(rs.getString("Candidat"));
			etudiant.setEtat(rs.getString("Etat"));
			etudiant.setPhoto(rs.getString("Photo"));
			
			OptionBac optionBac = new OptionBac();
			optionBac.setId(rs.getInt("OptionBacID"));
			optionBac.setCode(rs.getString("OptionBacCode"));
			optionBac.setNom_Fr(rs.getString("OptionBacNom_Fr"));
			optionBac.setNom_Ar(rs.getString("OptionBacNom_Ar"));
			etudiant.setOptionBac(optionBac);
			
			Mention mentionBac = new Mention();
			mentionBac.setId(rs.getInt("MentionBacID"));
			mentionBac.setCode(rs.getString("MentionBacCode"));
			mentionBac.setNom_Fr(rs.getString("MentionBacNom_Fr"));
			mentionBac.setNom_Ar(rs.getString("MentionBacNom_Ar"));
			etudiant.setMentionBac(mentionBac);
			
			Filiere filiere = new Filiere();
			filiere.setId(rs.getInt("FiliereID"));
			filiere.setCode(rs.getString("FiliereCode"));
			filiere.setNom_Fr(rs.getString("FiliereNom_Fr"));
			filiere.setNom_Ar(rs.getString("FiliereNom_Ar"));
			etudiant.setFiliere(filiere);
			
			Etablissement etablissement = new Etablissement();
			etablissement.setId(rs.getInt("EtablissementID"));
			etablissement.setCode(rs.getString("EtablissementCode"));
			etablissement.setNom_Fr(rs.getString("EtablissementNom_Fr"));
			etablissement.setNom_Ar(rs.getString("EtablissementNom_Ar"));
			etablissement.setAdresse_Fr(rs.getString("EtablissementAdresse_Fr"));
			etablissement.setAdresse_Ar(rs.getString("EtablissementAdresse_Ar"));
			etablissement.setTelephone(rs.getString("EtablissementTel"));
			etablissement.setEmail(rs.getString("EtablissementEmail"));
			etudiant.setEtabOrigine(etablissement);
			
			Parent parent=new Parent();
			parent.setId(rs.getInt("ParentID"));
			parent.setTitre(rs.getString("TitreParent"));
			parent.setSexe(rs.getString("SexeParent"));
			parent.setCin(rs.getString("CinParent"));
			parent.setNom_Fr(rs.getString("Nom_FrParent"));
			parent.setPrenom_Fr(rs.getString("Prenom_FrParent"));
			parent.setNom_Ar(rs.getString("Nom_ArParent"));
			parent.setPrenom_Ar(rs.getString("Prenom_ArParent"));
			parent.setNationalite(rs.getString("NationaliteParent"));
			parent.setDateNais(rs.getDate("DateNaisParent"));
			parent.setLieuNais_Fr(rs.getString("LieuNais_FrParent"));
			parent.setLieuNais_Ar(rs.getString("LieuNais_ArParent"));
			parent.setAdresse_Fr(rs.getString("Adresse_FrParent"));
			parent.setAdresse_Ar(rs.getString("Adresse_ArParent"));
			parent.setEmail(rs.getString("EmailParent"));
			parent.setSituationF(rs.getString("SituationFParent"));
			parent.setTeleMobile(rs.getString("TeleMobileParent"));
			parent.setTeleDomicile(rs.getString("TeleDomicileParent"));
			parent.setPhoto(rs.getString("PhotoParent"));
			parent.setLienParente(rs.getString("LienParente"));
			etudiant.setParent(parent);
			
			etudiants.add(etudiant);
		}
		rs.close();
		statement.close();
		return etudiants;	
	}
	public Etudiant getById(int id) throws SQLException{
		String query="SELECT \r\n" + 
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
		"	`utilisateur`.`Photo`,\r\n" +
		"	`etudiant`.`UtilisateurID` as EtudiantID ,\r\n" +
		"	`etudiant`.`Cne`,\r\n" +
		"	`etudiant`.`NumInscription`,\r\n" +
		"	`etudiant`.`AnneeBac`,\r\n" +
		"	`etudiant`.`Candidat`,\r\n" +
		"	`etudiant`.`Etat`,\r\n" +
		"	`optionbac`.`ID` as OptionBacID,\r\n" +
		"	`optionbac`.`Code` as OptionBacCode,\r\n" +
		"	`optionbac`.`Nom_Fr` as OptionBacNom_Fr,\r\n" +
		"	`optionbac`.`Nom_Ar` as OptionBacNom_Ar,\r\n" +
		"	`etudiant`.`MoyenneBac`,\r\n" +
		"	`mention`.`ID` as MentionBacID,\r\n" +
		"	`mention`.`Code` as MentionBacCode,\r\n" +
		"	`mention`.`Nom_Fr` as MentionBacNom_Fr,\r\n" +
		"	`mention`.`Nom_Ar` as MentionBacNom_Ar,\r\n" +
		"	`filiere`.`ID` as FiliereID,\r\n" +
		"	`filiere`.`Code` as FiliereCode,\r\n" +
		"	`filiere`.`Nom_Fr` as FiliereNom_Fr,\r\n" +
		"	`filiere`.`Nom_Ar` as FiliereNom_Ar,\r\n" +
		"	`etablissement`.`ID` as EtablissementID,\r\n" +
		"	`etablissement`.`Code` as EtablissementCode,\r\n" +
		"	`etablissement`.`Nom_Fr` as EtablissementNom_Fr,\r\n" +
		"	`etablissement`.`Nom_Ar` as EtablissementNom_Ar,\r\n" +
		"	`etablissement`.`Adresse_Fr` as EtablissementAdresse_Fr,\r\n" +
		"	`etablissement`.`Adresse_Ar` as EtablissementAdresse_Ar,\r\n" +
		"	`etablissement`.`Telephone` as EtablissementTel,\r\n" +
		"	`etablissement`.`Email` as EtablissementEmail,\r\n" +
		"	`utilisateurParent`.`ID` AS `ParentID` ,\r\n" +
		"	`utilisateurParent`.`Titre` AS `TitreParent`,\r\n" +
		"	`utilisateurParent`.`Sexe` AS `SexeParent`,\r\n" +
		"	`utilisateurParent`.`Cin` AS `CinParent`,\r\n" +
		"	`utilisateurParent`.`Nom_Fr` AS `Nom_FrParent`,\r\n" + 
		"	`utilisateurParent`.`Prenom_Fr` AS `Prenom_FrParent`,\r\n" + 
		"	`utilisateurParent`.`Nom_Ar` AS `Nom_ArParent`,\r\n" + 
		"	`utilisateurParent`.`Prenom_Ar` AS `Prenom_ArParent`,\r\n" + 
		"	`utilisateurParent`.`Nationalite` AS `NationaliteParent`,\r\n" + 
		"	`utilisateurParent`.`DateNais` AS `DateNaisParent`,\r\n" +
		"	`utilisateurParent`.`LieuNais_Fr` AS `LieuNais_FrParent`,\r\n" +
		"	`utilisateurParent`.`LieuNais_Ar` AS `LieuNais_ArParent`,\r\n" +
		"	`utilisateurParent`.`Adresse_Fr` AS `Adresse_FrParent`,\r\n" +
		"	`utilisateurParent`.`Adresse_Ar` AS `Adresse_ArParent`,\r\n" +
		"	`utilisateurParent`.`Email` AS `EmailParent`,\r\n" +
		"	`utilisateurParent`.`SituationF` AS `SituationFParent`,\r\n" +
		"	`utilisateurParent`.`TeleMobile` AS `TeleMobileParent`,\r\n" +
		"	`utilisateurParent`.`TeleDomicile` AS `TeleDomicileParent`,\r\n" +
		"	`utilisateurParent`.`Photo` AS `PhotoParent`,\r\n" +
		"	`parent`.`LienParente`\r\n" +
		"	FROM \r\n" + 
		"	`utilisateur`, `etudiant`, `optionbac`, `mention`, `filiere`, `etablissement`,`utilisateur` AS `utilisateurParent`,`parent` \r\n" + 
		"	WHERE \r\n" + 
		"	(`etudiant`.`UtilisateurID` = `utilisateur`.`ID` ) AND\r\n" + 
		"	(`etudiant`.`OptionBacID` = `optionbac`.`ID`) AND\r\n" + 
		"	(`etudiant`.`MentionID` = `mention`.`ID`) AND\r\n" +
		"	(`etudiant`.`FiliereID` = `filiere`.`ID`) AND\r\n" + 
		"	(`etudiant`.`EtablissementID` = `etablissement`.`ID`) AND \r\n"+
		"	(`utilisateurParent`.`ID` = `etudiant`.`ParentUtilisateurID`) AND \r\n"+
		"	(`etudiant`.`ParentUtilisateurID` = `parent`.`UtilisateurID`) AND \r\n"+
		"	(`etudiant`.`UtilisateurID` = ? );";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		Etudiant etudiant = new Etudiant();
		while (rs.next()) {
			etudiant.setId(rs.getInt("EtudiantID"));
			etudiant.setTitre(rs.getString("Titre"));
			etudiant.setSexe(rs.getString("Sexe"));
			etudiant.setCin(rs.getString("Cin"));
			etudiant.setNom_Fr(rs.getString("Nom_Fr"));
			etudiant.setPrenom_Fr(rs.getString("Prenom_Fr"));
			etudiant.setNom_Ar(rs.getString("Nom_Ar"));
			etudiant.setPrenom_Ar(rs.getString("Prenom_Ar"));
			etudiant.setNationalite(rs.getString("Nationalite"));
			etudiant.setDateNais(rs.getDate("DateNais"));
			etudiant.setLieuNais_Fr(rs.getString("LieuNais_Fr"));
			etudiant.setLieuNais_Ar(rs.getString("LieuNais_Ar"));
			etudiant.setAdresse_Fr(rs.getString("Adresse_Fr"));
			etudiant.setAdresse_Ar(rs.getString("Adresse_Ar"));
			etudiant.setEmail(rs.getString("Email"));
			etudiant.setSituationF(rs.getString("SituationF"));
			etudiant.setTeleMobile(rs.getString("TeleMobile"));
			etudiant.setTeleDomicile(rs.getString("TeleDomicile"));
			etudiant.setCne(rs.getString("Cne"));
			etudiant.setNumInscription(rs.getString("NumInscription"));
			etudiant.setAnneeBac(rs.getString("AnneeBac"));
			etudiant.setMoyenneBac(rs.getFloat("MoyenneBac"));
			etudiant.setCandidat(rs.getString("Candidat"));
			etudiant.setEtat(rs.getString("Etat"));
			etudiant.setPhoto(rs.getString("Photo"));
			
			OptionBac optionBac = new OptionBac();
			optionBac.setId(rs.getInt("OptionBacID"));
			optionBac.setCode(rs.getString("OptionBacCode"));
			optionBac.setNom_Fr(rs.getString("OptionBacNom_Fr"));
			optionBac.setNom_Ar(rs.getString("OptionBacNom_Ar"));
			etudiant.setOptionBac(optionBac);
			
			Mention mentionBac = new Mention();
			mentionBac.setId(rs.getInt("MentionBacID"));
			mentionBac.setCode(rs.getString("MentionBacCode"));
			mentionBac.setNom_Fr(rs.getString("MentionBacNom_Fr"));
			mentionBac.setNom_Ar(rs.getString("MentionBacNom_Ar"));
			etudiant.setMentionBac(mentionBac);
			
			Filiere filiere = new Filiere();
			filiere.setId(rs.getInt("FiliereID"));
			filiere.setCode(rs.getString("FiliereCode"));
			filiere.setNom_Fr(rs.getString("FiliereNom_Fr"));
			filiere.setNom_Ar(rs.getString("FiliereNom_Ar"));
			etudiant.setFiliere(filiere);
			
			Etablissement etablissement = new Etablissement();
			etablissement.setId(rs.getInt("EtablissementID"));
			etablissement.setCode(rs.getString("EtablissementCode"));
			etablissement.setNom_Fr(rs.getString("EtablissementNom_Fr"));
			etablissement.setNom_Ar(rs.getString("EtablissementNom_Ar"));
			etablissement.setAdresse_Fr(rs.getString("EtablissementAdresse_Fr"));
			etablissement.setAdresse_Ar(rs.getString("EtablissementAdresse_Ar"));
			etablissement.setTelephone(rs.getString("EtablissementTel"));
			etablissement.setEmail(rs.getString("EtablissementEmail"));
			
			Parent parent=new Parent();
			parent.setId(rs.getInt("ParentID"));
			parent.setTitre(rs.getString("TitreParent"));
			parent.setSexe(rs.getString("SexeParent"));
			parent.setCin(rs.getString("CinParent"));
			parent.setNom_Fr(rs.getString("Nom_FrParent"));
			parent.setPrenom_Fr(rs.getString("Prenom_FrParent"));
			parent.setNom_Ar(rs.getString("Nom_ArParent"));
			parent.setPrenom_Ar(rs.getString("Prenom_ArParent"));
			parent.setNationalite(rs.getString("NationaliteParent"));
			parent.setDateNais(rs.getDate("DateNaisParent"));
			parent.setLieuNais_Fr(rs.getString("LieuNais_FrParent"));
			parent.setLieuNais_Ar(rs.getString("LieuNais_ArParent"));
			parent.setAdresse_Fr(rs.getString("Adresse_FrParent"));
			parent.setAdresse_Ar(rs.getString("Adresse_ArParent"));
			parent.setEmail(rs.getString("EmailParent"));
			parent.setSituationF(rs.getString("SituationFParent"));
			parent.setTeleMobile(rs.getString("TeleMobileParent"));
			parent.setTeleDomicile(rs.getString("TeleDomicileParent"));
			parent.setPhoto(rs.getString("PhotoParent"));
			parent.setLienParente(rs.getString("LienParente"));
			etudiant.setParent(parent);
			
			etudiant.setEtabOrigine(etablissement);
		}
		rs.close();
		statement.close();
		return etudiant;	
	}
	public void update(Etudiant etudiant)throws SQLException{
			String query="UPDATE `etudiant` SET \r\n" + 
					"`UtilisateurID` = ? , \r\n" +
					"`FiliereID` = ? ,\r\n" +
					"`EtablissementID` = ?  ,\r\n" + 
					"`Cne` = ? ,\r\n" + 
					"`NumInscription` = ? ,\r\n" + 
					"`AnneeBac` = ? ,\r\n" + 
					"`OptionBacID` = ?  ,\r\n" + 
					"`MoyenneBac` = ? ,\r\n" + 
					"`MentionID` = ? ,\r\n" + 
					"`Candidat` = ? ,\r\n" + 
					"`Etat` = ? ,\r\n" + 
					"`ParentUtilisateurID` = ? \r\n" + 
					"WHERE \r\n" + 
					"`UtilisateurID` = ? ;" ;
	
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, etudiant.getId());
		statement.setInt(2, etudiant.getFiliere().getId());
		statement.setInt(3, etudiant.getEtabOrigine().getId());
		statement.setString(4, etudiant.getCne());
		statement.setString(5, etudiant.getNumInscription());
		statement.setString(6, etudiant.getAnneeBac());
		statement.setInt(7, etudiant.getOptionBac().getId());
		statement.setFloat(8, etudiant.getMoyenneBac());
		statement.setInt(9, etudiant.getMentionBac().getId());
		statement.setString(10, etudiant.getCandidat());
		statement.setString(11, etudiant.getEtat());
		statement.setInt(12, etudiant.getParent().getId());
		statement.setInt(13, etudiant.getId());
		statement.execute();
		statement.close();
	}
	
	public void delete(Etudiant etudiant)throws SQLException{
			String query="DELETE FROM `etudiant` \r\n" + 
					"	WHERE \r\n" + 
					"	(`etudiant`.`UtilisateurID` = ? );";
	
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, etudiant.getId());
		
		statement.execute();
		statement.close();
	}
}
