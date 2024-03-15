package controllers.matiere;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domaine.matiere.Unite;

import com.google.gson.Gson;
import dao.matiere.UniteDAO;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Unite/Update")
public class UniteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UniteDAO uniteDAO;  
    public UniteUpdate() {
        super();
        uniteDAO = new UniteDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		String code=request.getParameter("code");
		String nom_Fr= request.getParameter("nom_Fr");
		String nom_Ar=request.getParameter("nom_Ar");
		
		Unite unite = new Unite();
		unite.setId(id);
		unite.setCode(code);
		unite.setNom_Fr(nom_Fr);
		unite.setNom_Ar(nom_Ar);
		System.out.print("Test  : " +unite);
		String result=null;
		
		try {
			uniteDAO.update(unite);
			result="L'unité à été modiiée avec succès";
		} catch (SQLException e) {
			result="Impossible de modifier l'unité";
			e.printStackTrace();
		}
		String json = new Gson().toJson(result).toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
