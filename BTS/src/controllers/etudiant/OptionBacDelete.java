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

import Domaine.etudiant.OptionBac;

import dao.etudiant.OptionBacDAO;

/**
 * Servlet implementation class OptionBacList
 */
@WebServlet("/OptionBac/Delete")
public class OptionBacDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OptionBacDAO optionBacDAO;
    public OptionBacDelete() {
        super();
        optionBacDAO = new OptionBacDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		OptionBac optionBac= new OptionBac();
		optionBac.setId(id);
		try {
			optionBacDAO.delete(optionBac);
			result="L'option du Bac à été supprimée avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer l'option du Bac";
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
