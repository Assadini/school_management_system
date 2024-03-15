package controllers.matiere;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domaine.matiere.Unite;

import dao.matiere.UniteDAO;

/**
 * Servlet implementation class UniteList
 */
@WebServlet("/Unite/Delete")
public class UniteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UniteDAO uniteDAO;
    public UniteDelete() {
        super();
        uniteDAO = new UniteDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		Unite unite= new Unite();
		unite.setId(id);
		try {
			uniteDAO.delete(unite);
			result="L'unite à été supprimée avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer l'unite";
			e.printStackTrace();
		}
		String json = new Gson().toJson(result).toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}
}

