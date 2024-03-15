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

import Domaine.classe.Classe;
import dao.classe.ClasseDAO;


/**
 * Servlet implementation class CycleList
 */
@WebServlet("/Classe/Details")
public class ClasseDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseDAO classeDAO;
    public ClasseDetails() {
        super();
        classeDAO = new ClasseDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		Classe classe= new Classe();
		try {
			classe = classeDAO.getById(id);
			String json = new Gson().toJson(classe);
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
