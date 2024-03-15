package dao.matiere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.matiere.Module;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class ModuleDAO {
	private Connection con;
	public ModuleDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(Module module) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into module (ID, Code, Nom_Fr, Nom_Ar) values (null, ?, ?, ?)");
		statement.setString(1, module.getCode());
		statement.setString(2, module.getNom_Fr());
		statement.setString(3, module.getNom_Ar());
		statement.execute();
		statement.close();
	}
	public ArrayList<Module> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from module");
		ResultSet rs = statement.executeQuery();
		ArrayList<Module> modules = new ArrayList<Module>();
		while (rs.next()) {
			Module module = new Module();
			module.setId(rs.getInt("ID"));
			module.setCode(rs.getString("Code"));
			module.setNom_Fr(rs.getString("Nom_Fr"));
			module.setNom_Ar(rs.getString("Nom_Ar"));
			modules.add(module);
		}
		rs.close();
		statement.close();
		return modules;	
	}
	public Module getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from module where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		Module module = new Module();
		while (rs.next()) {
			module.setId(rs.getInt("ID"));
			module.setCode(rs.getString("Code"));
			module.setNom_Fr(rs.getString("Nom_Fr"));
			module.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return module;		
	}
	public void update (Module module) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update module set Code = ?, Nom_Fr = ?, Nom_Ar = ? where ID = ?");
		statement.setString(1, module.getCode());
		statement.setString(2, module.getNom_Fr());
		statement.setString(3, module.getNom_Ar());
		statement.setInt(4,module.getId());
		statement.execute();
	}
	public void delete(Module module) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from module where ID = ?");
		statement.setInt(1, module.getId());
		statement.execute();
		statement.close();
	}
}
