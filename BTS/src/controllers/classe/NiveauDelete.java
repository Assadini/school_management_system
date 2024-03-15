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

import Domaine.classe.Niveau;

import dao.classe.NiveauDAO;

/**
 * Servlet implementation class NiveauList
 */
@WebServlet("/Niveau/Delete")
public class NiveauDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NiveauDAO niveauDAO;
    public NiveauDelete() {
        super();
        niveauDAO = new NiveauDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		Niveau niveau= new Niveau();
		niveau.setId(id);
		try {
			niveauDAO.delete(niveau);
			result="Le niveau à été supprimé avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer le niveau";
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
