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

import Domaine.matiere.ClasseGUnite;
import dao.matiere.ClasseGUniteDAO;

/**
 * Servlet implementation class ClasseGeneriqueController
 */
@WebServlet("/ClasseGenerique/Unite/Delete")
public class ClasseGeneriqueUniteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseGUniteDAO classeGUniteDAO;
       
    public ClasseGeneriqueUniteDelete() {
        super();
        classeGUniteDAO = new ClasseGUniteDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classeGUniteId= Integer.parseInt(request.getParameter("classeGUniteId"));
		ClasseGUnite classeGUnite = new ClasseGUnite();
		classeGUnite.setId(classeGUniteId);
    	
		String message=null;
		try {
			classeGUniteDAO.delete(classeGUnite);
			message="L'unité à été supprimée avec succès";
			
		} catch (SQLException e) {
			message="Imposible de supprimer l'unité";
			e.printStackTrace();
		}
		String json = new Gson().toJson(message);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
