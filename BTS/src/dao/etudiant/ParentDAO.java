package dao.etudiant;

import java.sql.SQLException;
import Domaine.etudiant.Parent;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.database.Db;

public class ParentDAO {
	private Connection con;
	public ParentDAO(){
		
		this.con = Db.getInstance().con;
	}
	public void insert(Parent parent)throws SQLException{
			String query="INSERT INTO `parent` \r\n" + 
					"(`UtilisateurID`, `LienParente`) \r\n" + 
					"VALUES (?, ? );" ;
	
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, parent.getId());
		statement.setString(2, parent.getLienParente());
		statement.execute();
		statement.close();
	}
	public void update(Parent parent)throws SQLException{
		String query="UPDATE `parent` SET \r\n" + 
				"`UtilisateurID` = ? , `LienParente` = ? \r\n" + 
				"WHERE  `UtilisateurID` = ?;" ;

	PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
	statement.setInt(1, parent.getId());
	statement.setString(2, parent.getLienParente());
	statement.setInt(3, parent.getId());
	statement.execute();
	statement.close();
}
	public void delete(Parent parent)throws SQLException{
			String query="DELETE FROM `parent` \r\n" + 
					"	WHERE \r\n" + 
					"	(`parent`.`UtilisateurID` = ? );";
	
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, parent.getId());
		statement.execute();
		statement.close();
	}
}
