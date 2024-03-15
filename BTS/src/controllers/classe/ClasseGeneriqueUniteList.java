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

import Domaine.classe.ClasseGenerique;
import Domaine.matiere.ClasseGUnite;
import dao.matiere.ClasseGUniteDAO;

/**
 * Servlet implementation class ClasseGeneriqueController
 */
@WebServlet("/ClasseGenerique/Unite/List")
public class ClasseGeneriqueUniteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseGUniteDAO classeGUniteDAO;
       
    public ClasseGeneriqueUniteList() {
        super();
        classeGUniteDAO = new ClasseGUniteDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classeGeneriqueId= Integer.parseInt(request.getParameter("id"));
		ClasseGenerique classeGenerique = new ClasseGenerique();
		classeGenerique.setId(classeGeneriqueId);
    	ArrayList<ClasseGUnite> classeGUnites= new ArrayList<ClasseGUnite>();
		String json=null;
		try {
			
			
			classeGUnites = classeGUniteDAO.getAllByClasseGenerique(classeGenerique);
			json = new Gson().toJson(classeGUnites);
			
			
			
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
