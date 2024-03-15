package controllers.utilisateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;


import Domaine.utilisateur.Utilisateur;
import dao.utilisateur.UtilisateurDAO;




/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Utilisateur/List")
public class UtilisateurList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilisateurDAO utilisateurDAO;
    public UtilisateurList() {
        super();
        utilisateurDAO = new UtilisateurDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<Utilisateur> utilisateurs= new ArrayList<Utilisateur>();
		String json = null;
		try {
			utilisateurs = utilisateurDAO.getAll();
			
			/*
			 * Important : En raison d'un problème de reflectvité du champs Date de la classe Utilisateur
			 * J'ai dû utiliser l'API Jackson au lieu de l'API Gson.
			 * Prévoir peut etre de changer l'API Gson par Jackson dans tout le projet
			 */
			ObjectMapper mapper = new ObjectMapper();
			
			json = mapper.writeValueAsString(utilisateurs);
			
			
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
