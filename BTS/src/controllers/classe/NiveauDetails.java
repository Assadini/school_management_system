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
@WebServlet("/Niveau/Details")
public class NiveauDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NiveauDAO niveauDAO;
    public NiveauDetails() {
        super();
        niveauDAO = new NiveauDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		Niveau niveau= new Niveau();
		niveau.setId(id);
		try {
			niveau = niveauDAO.getById(id);
			String json = new Gson().toJson(niveau);
			
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
