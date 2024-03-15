package controllers.classe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domaine.classe.AnneeScolaire;

import com.google.gson.Gson;

import dao.classe.AnneeScolaireDAO;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/AnneeScolaire/Delete")
public class AnneeScolaireDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AnneeScolaireDAO anneeScolaireDAO;  
    public AnneeScolaireDelete() {
        super();
        anneeScolaireDAO = new AnneeScolaireDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String message=null;
		boolean result=false;
		int id=Integer.parseInt(request.getParameter("id"));
		try {
				AnneeScolaire anneeScolaire = new AnneeScolaire();
				anneeScolaire.setId(id);
				anneeScolaireDAO.delete(anneeScolaire);
				message="L'année scolaire à été supprimée avec succès";
		} catch (SQLException e) {
			message="Impossible de supprimer l'année scolaire";
			e.printStackTrace();
		}
		
		String json = new Gson().toJson(message).toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
