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


import Domaine.matiere.ConfigurationMatiere;
import dao.matiere.ConfigurationMatiereDAO;

/**
 * Servlet implementation class ClasseGeneriqueController
 */
@WebServlet("/ClasseGenerique/Unite/Matiere/Delete")
public class ClasseGeneriqueUniteMatiereDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfigurationMatiereDAO configurationMatiereDAO;
       
    public ClasseGeneriqueUniteMatiereDelete() {
        super();
        configurationMatiereDAO = new ConfigurationMatiereDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int configurationMatiereId = Integer.parseInt(request.getParameter("configurationMatiereId"));
		
		
		ConfigurationMatiere configurationMatiere= new ConfigurationMatiere();
		configurationMatiere.setId(configurationMatiereId);
		
		String message=null;
		boolean success =false;
		boolean warning = false;
		
		try {

				configurationMatiereDAO.delete(configurationMatiere);
				success=true;
				warning = false;
				message="La matière  a élé supprimée avec succès de l'unité ";
				

			
		} catch (SQLException e1) {
			success=false;
			warning = false;
			message="Impossible de supprimer la matière de l'unité";
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
