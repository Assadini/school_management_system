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

import Domaine.classe.Niveau;

import com.google.gson.Gson;

import dao.classe.NiveauDAO;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Niveau/Add")
public class NiveauAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NiveauDAO niveauDAO;  
    public NiveauAdd() {
        super();
        niveauDAO = new NiveauDAO();
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
		
		Niveau niveau = new Niveau();
		niveau.setCode(code);
		niveau.setNom_Fr(nom_Fr);
		niveau.setNom_Ar(nom_Ar);
		String result=null;
		try {
			niveauDAO.insert(niveau);
			result="Le niveau à été ajouté avec succès";
		} catch (SQLException e) {
			result="Impossible d'ajouter le niveau";
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
