package controllers.matiere;

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

import Domaine.matiere.Unite;

import dao.matiere.UniteDAO;

/**
 * Servlet implementation class UniteList
 */
@WebServlet("/Unite/List")
public class UniteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UniteDAO uniteDAO;
    public UniteList() {
        super();
        uniteDAO = new UniteDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Unite> unites= new ArrayList<Unite>();
		try {
			unites = uniteDAO.getAll();
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(unites).toString();
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

