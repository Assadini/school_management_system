package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domaine.etudiant.Mention;

import dao.etudiant.MentionDAO;

/**
 * Servlet implementation class MentionList
 */
@WebServlet("/Mention/Delete")
public class MentionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MentionDAO mentionDAO;
    public MentionDelete() {
        super();
        mentionDAO = new MentionDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		Mention mention= new Mention();
		mention.setId(id);
		try {
			mentionDAO.delete(mention);
			result="La mention à été supprimée avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer la mention";
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
