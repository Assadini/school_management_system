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

import Domaine.matiere.Module;

import com.google.gson.Gson;

import dao.matiere.ModuleDAO;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Module/Add")
public class ModuleAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ModuleDAO moduleDAO;  
    public ModuleAdd() {
        super();
        moduleDAO = new ModuleDAO();
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
		
		Module module = new Module();
		module.setCode(code);
		module.setNom_Fr(nom_Fr);
		module.setNom_Ar(nom_Ar);
		String result=null;
		try {
			moduleDAO.insert(module);
			result="Le module à été ajouté avec succès";
		} catch (SQLException e) {
			result="Impossible d'ajouter le module";
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

