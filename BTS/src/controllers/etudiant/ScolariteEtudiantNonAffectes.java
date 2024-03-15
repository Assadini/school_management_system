package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Domaine.classe.AnneeScolaire;
import Domaine.classe.AnneeScolaireCourante;
import Domaine.etudiant.Etudiant;
import dao.classe.AnneeScolaireCouranteDAO;
import dao.classe.AnneeScolaireDAO;
import dao.etudiant.ScolariteDAO;

/**
 * Servlet implementation class ScolariteList
 */
@WebServlet("/Scolarite/Etudiant/NonAffectes")
public class ScolariteEtudiantNonAffectes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScolariteDAO scolariteDAO;
    public ScolariteEtudiantNonAffectes() {
        super();
        scolariteDAO = new ScolariteDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Etudiant> etudiants= new ArrayList<Etudiant>();
		ArrayList<AnneeScolaireCourante> anneeScolaireCourantes= new ArrayList<AnneeScolaireCourante>();
		AnneeScolaireCouranteDAO anneeScolaireCouranteDAO = new AnneeScolaireCouranteDAO();
		
		String json = null;
		try {
			anneeScolaireCourantes = anneeScolaireCouranteDAO.getAll();
			etudiants = scolariteDAO.getEtudiantNonAffectes(anneeScolaireCourantes.get(0).getAnneeScolaire());
			ObjectMapper mapper = new ObjectMapper();
			
			json = mapper.writeValueAsString(etudiants);
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
