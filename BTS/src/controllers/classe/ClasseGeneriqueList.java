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
import com.google.gson.GsonBuilder;

import Domaine.classe.ClasseGenerique;

import dao.classe.ClasseGeneriqueDAO;

/**
 * Servlet implementation class ClasseGeneriqueList
 */
@WebServlet("/ClasseGenerique/List")
public class ClasseGeneriqueList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseGeneriqueDAO classeGeneriqueDAO;
    public ClasseGeneriqueList() {
        super();
        classeGeneriqueDAO = new ClasseGeneriqueDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ClasseGenerique> classeGeneriques= new ArrayList<ClasseGenerique>();
		try {
			classeGeneriques = classeGeneriqueDAO.getAll();
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(classeGeneriques).toString();
			
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
