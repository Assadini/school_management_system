package controllers.etudiant;

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

import Domaine.etudiant.Mention;

import dao.etudiant.MentionDAO;

/**
 * Servlet implementation class MentionList
 */
@WebServlet("/Mention/List")
public class MentionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MentionDAO mentionDAO;
    public MentionList() {
        super();
        mentionDAO = new MentionDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Mention> mentions= new ArrayList<Mention>();
		try {
			mentions = mentionDAO.getAll();
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(mentions).toString();
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
