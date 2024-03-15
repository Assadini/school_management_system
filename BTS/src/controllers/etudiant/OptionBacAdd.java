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

import Domaine.etudiant.OptionBac;

import com.google.gson.Gson;

import dao.etudiant.OptionBacDAO;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/OptionBac/Add")
public class OptionBacAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OptionBacDAO optionBacDAO;  
    public OptionBacAdd() {
        super();
        optionBacDAO = new OptionBacDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String code=request.getParameter("code");
		String nom_Fr= request.getParameter("nom_Fr");
		String nom_Ar=request.getParameter("nom_Ar");
		
		OptionBac optionBac = new OptionBac();
		optionBac.setCode(code);
		optionBac.setNom_Fr(nom_Fr);
		optionBac.setNom_Ar(nom_Ar);
		String result=null;
		try {
			optionBacDAO.insert(optionBac);
			result="L'option du Bac à été ajoutée avec succès";
		} catch (SQLException e) {
			result="Impossible d'ajouter l'option du Bac";
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
