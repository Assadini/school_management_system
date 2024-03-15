package controllers.classe;

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

import Domaine.matiere.ClasseGUnite;
import Domaine.matiere.ConfigurationMatiere;
import dao.matiere.ConfigurationMatiereDAO;

/**
 * Servlet implementation class ClasseGeneriqueController
 */
@WebServlet("/ClasseGenerique/Unite/Matiere/List")
public class ClasseGeneriqueUniteMatiereList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConfigurationMatiereDAO configurationMatiereDAO;
       
    public ClasseGeneriqueUniteMatiereList() {
        super();
        configurationMatiereDAO = new ConfigurationMatiereDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classeGUnitId= Integer.parseInt(request.getParameter("classeGUnitId"));
		ClasseGUnite classeGUnite = new ClasseGUnite();
		classeGUnite.setId(classeGUnitId);
		ArrayList<ConfigurationMatiere> configurationMatieres= new ArrayList<ConfigurationMatiere>();
		try {
			
			
			configurationMatieres = configurationMatiereDAO.getAllByClasseGUnite(classeGUnite);
			String json = new Gson().toJson(configurationMatieres);
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
