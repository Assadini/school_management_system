package controllers.etablissement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domaine.etablissement.Region;

import dao.etablissement.RegionDAO;

/**
 * Servlet implementation class RegionList
 */
@WebServlet("/Region/Delete")
public class RegionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegionDAO regionDAO;
    public RegionDelete() {
        super();
        regionDAO = new RegionDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		Region region= new Region();
		region.setId(id);
		try {
			regionDAO.delete(region);
			result="Le région à été supprimée avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer le région";
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
