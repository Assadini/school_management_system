package controllers.matiere;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domaine.matiere.Matiere;

import dao.matiere.MatiereDAO;

/**
 * Servlet implementation class MatiereList
 */
@WebServlet("/Matiere/Details")
public class MatiereDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatiereDAO matiereDAO;
    public MatiereDetails() {
        super();
        matiereDAO = new MatiereDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		Matiere matiere= new Matiere();
		matiere.setId(id);
		try {
			matiere = matiereDAO.getById(id);
			String json = new Gson().toJson(matiere);
			
			response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
