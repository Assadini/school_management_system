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
import com.google.gson.GsonBuilder;

import Domaine.classe.AnneeScolaire;
import dao.classe.AnneeScolaireDAO;


/**
 * Servlet implementation class CycleList
 */
@WebServlet("/AnneeScolaire/Details")
public class AnneeScolaireDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnneeScolaireDAO anneeScolaireDAO;
    public AnneeScolaireDetails() {
        super();
        anneeScolaireDAO = new AnneeScolaireDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String json=null;
		int id =Integer.parseInt(request.getParameter("id"));
		AnneeScolaire anneeScolaires= new AnneeScolaire();
		try {
			
			anneeScolaires = anneeScolaireDAO.getById(id);
			Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
			json = gson.toJson(anneeScolaires);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} catch (SQLException e) {
			json = new Gson().toJson(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
