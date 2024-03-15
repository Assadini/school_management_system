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

import Domaine.etudiant.OptionBac;

import dao.etudiant.OptionBacDAO;

/**
 * Servlet implementation class OptionBacList
 */
@WebServlet("/OptionBac/Details")
public class OptionBacDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OptionBacDAO optionBacDAO;
    public OptionBacDetails() {
        super();
        optionBacDAO = new OptionBacDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		OptionBac optionBac= new OptionBac();
		optionBac.setId(id);
		try {
			optionBac = optionBacDAO.getById(id);
			String json = new Gson().toJson(optionBac);
			
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
