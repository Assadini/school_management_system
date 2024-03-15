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

import Domaine.classe.Classe;
import dao.classe.ClasseDAO;


/**
 * Servlet implementation class CycleList
 */
@WebServlet("/Classe/Delete")
public class ClasseDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseDAO classeDAO;
    public ClasseDelete() {
    	classeDAO = new ClasseDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Classe classe = new Classe();
		classe.setId(id);
		String message =null;
		try {
			classeDAO.delete(classe);
			message="La classe à été supprimée avec succès";
			
		} catch (SQLException e) {
			message="Impossible de supprimer la classe";
			e.printStackTrace();
		}	
		String json = new Gson().toJson(message).toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}
}
