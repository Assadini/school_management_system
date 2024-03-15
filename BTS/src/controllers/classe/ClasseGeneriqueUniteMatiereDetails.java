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
@WebServlet("/ClasseGenerique/Unite/Matiere/Details")
public class ClasseGeneriqueUniteMatiereDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfigurationMatiereDAO configurationMatiereDAO;
       
    public ClasseGeneriqueUniteMatiereDetails() {
        super();
        configurationMatiereDAO = new ConfigurationMatiereDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int configurationMatiereId= Integer.parseInt(request.getParameter("configurationMatiereId"));
		ConfigurationMatiere configurationMatiere= new ConfigurationMatiere();
		try {
			
			
			configurationMatiere = configurationMatiereDAO.getById(configurationMatiereId);
			String json = new Gson().toJson(configurationMatiere);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
