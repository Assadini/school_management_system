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

import Domaine.classe.AnneeScolaire;
import dao.classe.AnneeScolaireDAO;


/**
 * Servlet implementation class CycleList
 */
@WebServlet("/AnneeScolaire/List")
public class AnneeScolaireList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnneeScolaireDAO anneeScolaireDAO;
    public AnneeScolaireList() {
        super();
        anneeScolaireDAO = new AnneeScolaireDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AnneeScolaire> anneeScolaires= new ArrayList<AnneeScolaire>();
		String json=null;
		try {
			
			anneeScolaires = anneeScolaireDAO.getAll();
			json = new Gson().toJson(anneeScolaires);
			
			
			
		} catch (SQLException e) {
			json = new Gson().toJson(e.getMessage());
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}
}
