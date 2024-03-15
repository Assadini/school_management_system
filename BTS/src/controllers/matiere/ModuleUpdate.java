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
@WebServlet("/Module/Update")
public class ModuleUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ModuleDAO moduleDAO;  
    public ModuleUpdate() {
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
		
		int id=Integer.parseInt(request.getParameter("id"));
		String code=request.getParameter("code");
		String nom_Fr= request.getParameter("nom_Fr");
		String nom_Ar=request.getParameter("nom_Ar");
		
		Module module = new Module();
		module.setId(id);
		module.setCode(code);
		module.setNom_Fr(nom_Fr);
		module.setNom_Ar(nom_Ar);
		System.out.print("Test  : " +module);
		String result=null;
		
		try {
			moduleDAO.update(module);
			result="Le module à été modiié avec succès";
		} catch (SQLException e) {
			result="Impossible de modifier le module";
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
