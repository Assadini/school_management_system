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

import Domaine.classe.Filiere;

import dao.classe.FiliereDAO;

/**
 * Servlet implementation class FiliereList
 */
@WebServlet("/Filiere/Delete")
public class FiliereDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FiliereDAO filiereDAO;
    public FiliereDelete() {
        super();
        filiereDAO = new FiliereDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		Filiere filiere= new Filiere();
		filiere.setId(id);
		try {
			filiereDAO.delete(filiere);
			result="La filiere à été supprimée avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer la filiere";
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
