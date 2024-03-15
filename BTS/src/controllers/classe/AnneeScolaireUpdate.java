package controllers.classe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet("/AnneeScolaire/Update")
public class AnneeScolaireUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AnneeScolaireDAO anneeScolaireDAO;  
    public AnneeScolaireUpdate() {
        super();
        anneeScolaireDAO = new AnneeScolaireDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String message=null;
		boolean result=false;
		int id=Integer.parseInt(request.getParameter("id"));
		String code=request.getParameter("code");
	
		try {
			Date dateDebut = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateDebut"));
			Date dateFin= new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateFin"));
			try {
				AnneeScolaire anneeScolaire = new AnneeScolaire();
				anneeScolaire.setId(id);
				anneeScolaire.setCode(code);
				anneeScolaire.setDateDebut(dateDebut);
				anneeScolaire.setDateFin(dateFin);
				anneeScolaireDAO.update(anneeScolaire);
				message="L'année scolaire à été modifiée avec succès";
			} catch (SQLException e) {
				message="Impossible de modifier l'année scolaire";
				e.printStackTrace();
			}
		} catch (ParseException e1) {
			message="Erreur de conversion de date";
			e1.printStackTrace();
		}
		
		String json = new Gson().toJson(message).toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
