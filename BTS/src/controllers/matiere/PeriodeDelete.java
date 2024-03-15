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

import Domaine.matiere.Periode;

import dao.matiere.PeriodeDAO;

/**
 * Servlet implementation class PeriodeList
 */
@WebServlet("/Periode/Delete")
public class PeriodeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PeriodeDAO periodeDAO;
    public PeriodeDelete() {
        super();
        periodeDAO = new PeriodeDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		Periode periode= new Periode();
		periode.setId(id);
		try {
			periodeDAO.delete(periode);
			result="La periode à été supprimée avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer la periode";
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
