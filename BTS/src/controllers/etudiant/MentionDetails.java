package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domaine.etudiant.Mention;

import dao.etudiant.MentionDAO;

/**
 * Servlet implementation class MentionList
 */
@WebServlet("/Mention/Details")
public class MentionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MentionDAO mentionDAO;
    public MentionDetails() {
        super();
        mentionDAO = new MentionDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		Mention mention= new Mention();
		mention.setId(id);
		try {
			mention = mentionDAO.getById(id);
			String json = new Gson().toJson(mention);
			
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
