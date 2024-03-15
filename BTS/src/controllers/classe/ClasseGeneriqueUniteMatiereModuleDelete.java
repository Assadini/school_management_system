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
@WebServlet("/ClasseGenerique/Unite/Matiere/Module/Delete")
public class ClasseGeneriqueUniteMatiereModuleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfigurationModuleDAO configurationModuleDAO;
       
    public ClasseGeneriqueUniteMatiereModuleDelete() {
        super();
        configurationModuleDAO = new ConfigurationModuleDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int configurationModuleId = Integer.parseInt(request.getParameter("configurationModuleId"));
		
		ConfigurationModule configurationModule= new ConfigurationModule();
		configurationModule.setId(configurationModuleId);
		
		String message=null;
		boolean success =false;
		boolean warning = false;
		
		try {
			configurationModuleDAO.delete(configurationModule);
			success=true;
			warning = false;
			message="Le module a élé supprimé avec succès";
				
		} catch (SQLException e1) {
			success=false;
			warning = false;
			message="Impossible de supprimer le module";
			e1.printStackTrace();
		}
		
		String json = new Gson().toJson(message);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
