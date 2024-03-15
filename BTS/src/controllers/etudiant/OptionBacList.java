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

import Domaine.etudiant.OptionBac;

import dao.etudiant.OptionBacDAO;

/**
 * Servlet implementation class OptionBacList
 */
@WebServlet("/OptionBac/List")
public class OptionBacList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OptionBacDAO optionBacDAO;
    public OptionBacList() {
        super();
        optionBacDAO = new OptionBacDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<OptionBac> optionBacs= new ArrayList<OptionBac>();
		try {
			optionBacs = optionBacDAO.getAll();
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(optionBacs);
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
