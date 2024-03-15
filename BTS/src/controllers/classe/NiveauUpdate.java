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
@WebServlet("/Niveau/Update")
public class NiveauUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NiveauDAO niveauDAO;  
    public NiveauUpdate() {
        super();
        niveauDAO = new NiveauDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");
		System.out.println("Encodage utilisé : "+request.getCharacterEncoding());
		
		int id=Integer.parseInt(request.getParameter("id"));
		String code=request.getParameter("code");
		String nom_Fr= request.getParameter("nom_Fr");
		String nom_Ar=request.getParameter("nom_Ar");
		
		//System.out.println("Nom Niveau Arabe = "+nom_Ar);
		
		Niveau niveau = new Niveau();
		niveau.setId(id);
		niveau.setCode(code);
		niveau.setNom_Fr(nom_Fr);
		niveau.setNom_Ar(nom_Ar);
	
		String result=null;
		
		try {
			niveauDAO.update(niveau);
			result="Le niveau à été modiier avec succès";
		} catch (SQLException e) {
			result="Impossible de modifier le niveau";
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
