package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;


import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.etudiant.ScolariteDAO;
import Domaine.etudiant.Scolarite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Scolarite/Delete")
public class ScolariteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ScolariteDAO scolariteDAO;
    
    public ScolariteDelete() {
        super();
        scolariteDAO = new ScolariteDAO();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 int scolariteId = Integer.parseInt(request.getParameter("ScolariteId").trim());
		 Scolarite scolarite= new Scolarite();
		 scolarite.setId(scolariteId);
		 String result=null;
		 
		 try {
			scolariteDAO.delete(scolarite);
			result="L'étudiant à été retiré de la classe  avec succès";
		 } catch (SQLException e) {
			e.printStackTrace();
			result="Impossible de retirer l'étudiant de la classe";
		 }
				 
			
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
}
