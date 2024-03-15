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
import Domaine.matiere.ClasseGUnite;
import Domaine.matiere.Unite;

import dao.matiere.ClasseGUniteDAO;

/**
 * Servlet implementation class ClasseGeneriqueController
 */
@WebServlet("/ClasseGenerique/Unite/Update")
public class ClasseGeneriqueUniteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseGUniteDAO classeGUniteDAO;
       
    public ClasseGeneriqueUniteUpdate() {
        super();
        classeGUniteDAO = new ClasseGUniteDAO();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classeGUnitId = Integer.parseInt(request.getParameter("classeGUnitId"));
		int classeGeneriqueId = Integer.parseInt(request.getParameter("classeGeneriqueId"));
		int uniteId = Integer.parseInt(request.getParameter("unite"));
		float noteEliminatoire = Float.parseFloat(request.getParameter("noteEliminatoire"));
		
		ClasseGenerique classeGenerique = new ClasseGenerique();
		Unite unite = new Unite();
		
		
		classeGenerique.setId(classeGeneriqueId);
		unite.setId(uniteId);
		
		ClasseGUnite classeGUnite = new ClasseGUnite();
		classeGUnite.setNoteEliminatoire(noteEliminatoire);
		classeGUnite.setClasseGenerique(classeGenerique);
		classeGUnite.setUnite(unite);
		classeGUnite.setId(classeGUnitId);
		
		
		
		String message=null;
		boolean success =false;
		boolean warning = false;
		
		try {
			if(classeGUniteDAO.exists(classeGUnite)!=null && classeGUniteDAO.exists(classeGUnite).getId()!= classeGUnite.getId()){
				message="L'unité existe déjà modifiée ";
			}else{
				
				classeGUniteDAO.update(classeGUnite);
				success=true;
				warning = false;
				message="L'unité a bien élé modifiée ";
			}
			
		} catch (SQLException e1) {
			success=false;
			warning = false;
			message="Impossible de modifier l'unité ";
			e1.printStackTrace();
		}
		
		String json = new Gson().toJson(message);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
