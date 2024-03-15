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
import Domaine.classe.AnneeScolaireCourante;

import com.google.gson.Gson;

import dao.classe.AnneeScolaireCouranteDAO;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/AnneeScolaireCourante/Update")
public class AnneeScolaireCouranteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AnneeScolaireCouranteDAO anneeScolaireCouranteDAO;  
    public AnneeScolaireCouranteUpdate() {
        super();
        anneeScolaireCouranteDAO = new AnneeScolaireCouranteDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String message=null;
		boolean result=false;
		
		int anneeScolaireId =Integer.parseInt(request.getParameter("id"));
		
		try {
				AnneeScolaireCourante anneeScolaireCourante = new AnneeScolaireCourante();
				
				AnneeScolaire anneeScolaire = new AnneeScolaire();
				anneeScolaire.setId(anneeScolaireId);
				
				anneeScolaireCourante.setAnneeScolaire(anneeScolaire);
				
				anneeScolaireCouranteDAO.update(anneeScolaireCourante);
				message="L'année scolaire courante à été modifiée avec succès";
		} catch (SQLException e) {
				message="Impossible de modifier l'année scolaire courante";
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
