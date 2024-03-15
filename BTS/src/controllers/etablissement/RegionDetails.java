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
@WebServlet("/Region/Details")
public class RegionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegionDAO regionDAO;
    public RegionDetails() {
        super();
        regionDAO = new RegionDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		Region region= new Region();
		region.setId(id);
		try {
			region = regionDAO.getById(id);
			String json = new Gson().toJson(region);
			
			response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
