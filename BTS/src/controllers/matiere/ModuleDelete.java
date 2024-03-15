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

import Domaine.matiere.Module;

import dao.matiere.ModuleDAO;

/**
 * Servlet implementation class ModuleList
 */
@WebServlet("/Module/Delete")
public class ModuleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModuleDAO moduleDAO;
    public ModuleDelete() {
        super();
        moduleDAO = new ModuleDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		Module module= new Module();
		module.setId(id);
		try {
			moduleDAO.delete(module);
			result="Le module à été supprimé avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer le module";
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

