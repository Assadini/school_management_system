package controllers.classe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domaine.classe.Filiere;

import com.google.gson.Gson;
import dao.classe.FiliereDAO;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Filiere/Update")
public class FiliereUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FiliereDAO filiereDAO;  
    public FiliereUpdate() {
        super();
        filiereDAO = new FiliereDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id=Integer.parseInt(request.getParameter("id"));
		String code=request.getParameter("code");
		String nom_Fr= request.getParameter("nom_Fr");
		String nom_Ar=request.getParameter("nom_Ar");
		
		Filiere filiere = new Filiere();
		filiere.setId(id);
		filiere.setCode(code);
		filiere.setNom_Fr(nom_Fr);
		filiere.setNom_Ar(nom_Ar);
		
		try {
			filiereDAO.update(filiere);
			result="La filiere à été modifié avec succès";
		} catch (SQLException e) {
			result="Impossible de modifier la filiere";
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
