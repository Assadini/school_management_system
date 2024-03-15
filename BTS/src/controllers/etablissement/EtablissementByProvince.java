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

import Domaine.etablissement.Etablissement;
import Domaine.etablissement.Province;

import dao.etablissement.EtablissementDAO;

/**
 * Servlet implementation class EtablissementList
 */
@WebServlet("/Etablissement/Province")
public class EtablissementByProvince extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EtablissementDAO etablissementDAO;
    public EtablissementByProvince() {
        super();
        etablissementDAO = new EtablissementDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Etablissement> etablissements= new ArrayList<Etablissement>();
		int provinceId=Integer.parseInt(request.getParameter("provinceId"));
		Province province = new Province();
		province.setId(provinceId);
		try {
			etablissements = etablissementDAO.getByProvince(province);
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(etablissements).toString();
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
