package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;


import java.sql.SQLException;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domaine.classe.Classe;
import dao.etudiant.ScolariteDAO;
import Domaine.etudiant.Etudiant;
import Domaine.etudiant.Mention;
import Domaine.etudiant.Scolarite;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Scolarite/Etudiants/Add")
public class ScolariteEtudiantAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ScolariteDAO scolariteDAO;
    
    public ScolariteEtudiantAdd() {
        super();
        scolariteDAO = new ScolariteDAO();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");
		 int classeId = Integer.parseInt(request.getParameter("classeId").trim());
		 String[] etudiantsIds = request.getParameterValues("etudiants[]");
		 String result=null;
		 if(etudiantsIds!=null){
			 for(int i=0;i<etudiantsIds.length;i++){
				 Scolarite scolarite = new Scolarite();
				 Classe classe= new Classe();
				 classe.setId(classeId);
				 scolarite.setClasse(classe);
				 Etudiant etudiant = new Etudiant();
				 etudiant.setId(Integer.parseInt(etudiantsIds[i]));
				 scolarite.setEtudiant(etudiant);
				 Calendar cal = Calendar.getInstance();
				 Date dateInscription = cal.getTime();
				 scolarite.setDateInscription(dateInscription);
				 //TODO : Important !! Régler le problème des jointure des tables dans scolariteDAO.getAll()..
				 //Ici on ajoute la mention quoique la mention ne doit etre ajoutée qu'apres délibération en fin d'année.
				 //C'est uniquement pour que les jointures fonctionnent(Solution provisoire). ( Remplcer peut etre Where par Inner Join)
				 Mention mention=new Mention();
				 mention.setId(1);
				 scolarite.setMention(mention);
				 try {
					scolariteDAO.insert(scolarite);
					result="L'étudiant à été ajouté à la classe  avec succès";
				} catch (SQLException e) {
					e.printStackTrace();
					result="Impossible d'ajouter l'étudiant à la classe";
					break;
				}
				 
			 }
			
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(result);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		 }
	
	}
	
}
