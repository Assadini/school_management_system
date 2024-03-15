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

import Domaine.matiere.Matiere;

import dao.matiere.MatiereDAO;

/**
 * Servlet implementation class MatiereList
 */
@WebServlet("/Matiere/Delete")
public class MatiereDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatiereDAO matiereDAO;
    public MatiereDelete() {
        super();
        matiereDAO = new MatiereDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		Matiere matiere= new Matiere();
		matiere.setId(id);
		try {
			matiereDAO.delete(matiere);
			result="La matière à été supprimée avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer la matière";
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

