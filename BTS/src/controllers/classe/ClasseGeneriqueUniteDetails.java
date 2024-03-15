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

import Domaine.matiere.ClasseGUnite;
import dao.matiere.ClasseGUniteDAO;

/**
 * Servlet implementation class ClasseGeneriqueController
 */
@WebServlet("/ClasseGenerique/Unite/Details")
public class ClasseGeneriqueUniteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseGUniteDAO classeGUniteDAO;
       
    public ClasseGeneriqueUniteDetails() {
        super();
        classeGUniteDAO = new ClasseGUniteDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classeGUniteId= Integer.parseInt(request.getParameter("classeGUniteId"));
		ClasseGUnite classeGUnite = new ClasseGUnite();
		
    	
		String json=null;
		try {
			
			
			classeGUnite = classeGUniteDAO.getById(classeGUniteId);
			json = new Gson().toJson(classeGUnite);
			
			
			
		} catch (SQLException e) {
			json = new Gson().toJson(e.getMessage()).toString();
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
