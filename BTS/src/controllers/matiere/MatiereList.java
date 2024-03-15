package controllers.matiere;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Domaine.matiere.Matiere;

import dao.matiere.MatiereDAO;

/**
 * Servlet implementation class MatiereList
 */
@WebServlet("/Matiere/List")
public class MatiereList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatiereDAO matiereDAO;
    public MatiereList() {
        super();
        matiereDAO = new MatiereDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Matiere> matieres= new ArrayList<Matiere>();
		try {
			matieres = matiereDAO.getAll();
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(matieres).toString();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

