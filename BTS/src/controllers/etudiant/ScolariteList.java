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

import Domaine.classe.Classe;
import Domaine.etudiant.Scolarite;

import dao.etudiant.ScolariteDAO;

/**
 * Servlet implementation class ScolariteList
 */
@WebServlet("/Scolarite/List")
public class ScolariteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScolariteDAO scolariteDAO;
    public ScolariteList() {
        super();
        scolariteDAO = new ScolariteDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Scolarite> scolarites= new ArrayList<Scolarite>();
		int classeId = Integer.parseInt(request.getParameter("classeId"));
		Classe classe = new Classe();
		classe.setId(classeId);
		String json = null;
		try {
			scolarites = scolariteDAO.getByClasse(classe);
			ObjectMapper mapper = new ObjectMapper();
			
			json = mapper.writeValueAsString(scolarites);
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
