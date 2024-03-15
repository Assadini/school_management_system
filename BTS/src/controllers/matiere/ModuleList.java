package controllers.matiere;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Domaine.matiere.Module;

import dao.matiere.ModuleDAO;

/**
 * Servlet implementation class ModuleList
 */
@WebServlet("/Module/List")
public class ModuleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModuleDAO moduleDAO;
    public ModuleList() {
        super();
        moduleDAO = new ModuleDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Module> modules= new ArrayList<Module>();
		try {
			modules = moduleDAO.getAll();
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(modules).toString();
		
			//System.out.println(json);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

