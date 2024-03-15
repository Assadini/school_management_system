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

import Domaine.matiere.Unite;

import dao.matiere.UniteDAO;

/**
 * Servlet implementation class UniteList
 */
@WebServlet("/Unite/Details")
public class UniteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UniteDAO uniteDAO;
    public UniteDetails() {
        super();
        uniteDAO = new UniteDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		Unite unite= new Unite();
		unite.setId(id);
		try {
			unite = uniteDAO.getById(id);
			String json = new Gson().toJson(unite);
			
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
