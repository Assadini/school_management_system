package controllers.classe;

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

import Domaine.classe.AnneeScolaireCourante;
import dao.classe.AnneeScolaireCouranteDAO;


/**
 * Servlet implementation class CycleList
 */
@WebServlet("/AnneeScolaireCourante/List")
public class AnneeScolaireCouranteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AnneeScolaireCouranteDAO anneeScolaireCouranteDAO;
    public AnneeScolaireCouranteList() {
        super();
        anneeScolaireCouranteDAO = new AnneeScolaireCouranteDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AnneeScolaireCourante> anneeScolaireCourantes= new ArrayList<AnneeScolaireCourante>();
		String json=null;
		try {
			
			anneeScolaireCourantes = anneeScolaireCouranteDAO.getAll();
			json = new Gson().toJson(anneeScolaireCourantes);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
			
		} catch (SQLException e) {
			json = new Gson().toJson(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
