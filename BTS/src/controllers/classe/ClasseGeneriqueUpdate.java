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
import Domaine.classe.Cycle;
import Domaine.classe.Filiere;
import Domaine.classe.Niveau;

import dao.classe.ClasseGeneriqueDAO;
import dao.classe.CycleDAO;
import dao.classe.FiliereDAO;
import dao.classe.NiveauDAO;

/**
 * Servlet implementation class ClasseGeneriqueController
 */
@WebServlet("/ClasseGenerique/Update")
public class ClasseGeneriqueUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasseGeneriqueDAO classeGeneriqueDAO;
       
    public ClasseGeneriqueUpdate() {
        super();
        classeGeneriqueDAO = new ClasseGeneriqueDAO();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int classeGeneriqueId = Integer.parseInt(request.getParameter("id"));
		int cycleId=Integer.parseInt(request.getParameter("cycle"));
		int filiereId=Integer.parseInt(request.getParameter("filiere"));
		int niveauId=Integer.parseInt(request.getParameter("niveau"));
		String description=request.getParameter("description");
		
		ClasseGenerique classeGenerique = new ClasseGenerique();
		Cycle cycle = new Cycle();
		Filiere filiere = new Filiere();
		Niveau niveau = new Niveau();
		
		CycleDAO cycleDA0 = new CycleDAO();
		FiliereDAO filiereDAO = new FiliereDAO();
		NiveauDAO niveauDA0 = new NiveauDAO();
		
		String result=null;
		
		try {
			cycle = cycleDA0.getById(cycleId);
			filiere= filiereDAO.getById(filiereId);
			niveau = niveauDA0.getById(niveauId);
			classeGenerique.setCycle(cycle);
			classeGenerique.setFiliere(filiere);
			classeGenerique.setNiveau(niveau);
			classeGenerique.setCode();
			classeGenerique.setId(classeGeneriqueId);
			classeGenerique.setDescription(description);
			
			if(classeGeneriqueDAO.exists(classeGenerique)== null){
				classeGeneriqueDAO.update(classeGenerique);
				result="La classe générique a élé modifiée avec succès";
				
			}else{
				result="Cette classe générique existe déja ";
			}
			
		} catch (SQLException e1) {
			result="Impossible de modifier la classes générique";
			e1.printStackTrace();
		}
		
		String json = new Gson().toJson(result).toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

}
