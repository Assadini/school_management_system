package dao.securite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Domaine.securite.Role;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.database.Db;

public class RoleDAO {
	private Connection con;
	public RoleDAO() {
		this.con = Db.getInstance().con;
	}
	public void insert(Role role) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("insert into role (ID, Code, Nom_Fr, Nom_Ar) values (null, ?, ?, ?)");
		statement.setString(1, role.getCode());
		statement.setString(2, role.getNom_Fr());
		statement.setString(3, role.getNom_Ar());
		statement.execute();
		statement.close();
	}
	public ArrayList<Role> getAll() throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from role");
		ResultSet rs = statement.executeQuery();
		ArrayList<Role> roles = new ArrayList<Role>();
		while (rs.next()) {
			Role role = new Role();
			role.setId(rs.getInt("ID"));
			role.setCode(rs.getString("Code"));
			role.setNom_Fr(rs.getString("Nom_Fr"));
			role.setNom_Ar(rs.getString("Nom_Ar"));
			roles.add(role);
		}
		rs.close();
		statement.close();
		return roles;	
	}
	public Role getById(int id) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from role where ID = ? ");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		Role role = new Role();
		while (rs.next()) {
			role.setId(rs.getInt("ID"));
			role.setCode(rs.getString("Code"));
			role.setNom_Fr(rs.getString("Nom_Fr"));
			role.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return role;		
	}
	public void update (Role role) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("update role set Code = ?, Nom_Fr = ?, Nom_Ar = ? where ID = ?");
		statement.setString(1, role.getCode());
		statement.setString(2, role.getNom_Fr());
		statement.setString(3, role.getNom_Ar());
		statement.setInt(4,role.getId());
		statement.execute();
	}
	public void delete(Role role) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("delete from role where ID = ?");
		statement.setInt(1, role.getId());
		statement.execute();
		statement.close();
	}
	public Role getByCode(String code) throws SQLException{
		PreparedStatement statement = (PreparedStatement) con.prepareStatement("select ID, Code, Nom_Fr, Nom_Ar from role where Code = ? ");
		statement.setString(1, code);
		ResultSet rs = statement.executeQuery();
		Role role = new Role();
		while (rs.next()) {
			role.setId(rs.getInt("ID"));
			role.setCode(rs.getString("Code"));
			role.setNom_Fr(rs.getString("Nom_Fr"));
			role.setNom_Ar(rs.getString("Nom_Ar"));
		}
		rs.close();
		statement.close();
		return role;		
	}
	
}
