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

import Domaine.classe.ClasseGenerique;

import dao.classe.ClasseGeneriqueDAO;

/**
 * Servlet implementation class ClasseGeneriqueList
 */
@WebServlet("/ClasseGenerique/Details")
public class ClasseGeneriqueDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseGeneriqueDAO classeGeneriqueDAO;
    public ClasseGeneriqueDetails() {
        super();
        classeGeneriqueDAO = new ClasseGeneriqueDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classeGeneriqueId =Integer.parseInt(request.getParameter("id"));
		ClasseGenerique classeGenerique= new ClasseGenerique();
		try {
			classeGenerique = classeGeneriqueDAO.getById(classeGeneriqueId);
			String json = new Gson().toJson(classeGenerique);
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
