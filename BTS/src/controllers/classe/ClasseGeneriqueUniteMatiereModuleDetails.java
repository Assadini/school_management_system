package controllers.classe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domaine.matiere.ConfigurationModule;
import dao.matiere.ConfigurationModuleDAO;

/**
 * Servlet implementation class ClasseGeneriqueController
 */
@WebServlet("/ClasseGenerique/Unite/Matiere/Module/Details")
public class ClasseGeneriqueUniteMatiereModuleDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfigurationModuleDAO configurationModuleDAO;
       
    public ClasseGeneriqueUniteMatiereModuleDetails() {
        super();
        configurationModuleDAO = new ConfigurationModuleDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int configurationModuleId = Integer.parseInt(request.getParameter("configurationModuleId"));
		
				
		String message=null;
		boolean success =false;
		boolean warning = false;
		
		try {
				ConfigurationModule configurationModule = new ConfigurationModule();
				configurationModule= configurationModuleDAO.getById(configurationModuleId);
				String json = new Gson().toJson(configurationModule);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.print(json);
				out.flush();
				
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
