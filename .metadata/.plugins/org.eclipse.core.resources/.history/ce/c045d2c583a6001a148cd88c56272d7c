package controllers.etablissement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Domaine.etablissement.Province;
import Domaine.etablissement.Region;

import dao.etablissement.ProvinceDAO;

/**
 * Servlet implementation class ProvinceList
 */
@WebServlet("/Province/Region")
public class ProvinceByRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProvinceDAO provinceDAO;
    public ProvinceByRegion() {
        super();
        provinceDAO = new ProvinceDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Province> provinces= new ArrayList<Province>();
		int regionId=Integer.parseInt(request.getParameter("regionId"));
		Region region = new Region();
		region.setId(regionId);
		try {
			provinces = provinceDAO.getByRegion(region);
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(provinces).toString();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
