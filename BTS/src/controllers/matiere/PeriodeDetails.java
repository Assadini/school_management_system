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

import Domaine.matiere.Periode;

import dao.matiere.PeriodeDAO;

/**
 * Servlet implementation class PeriodeList
 */
@WebServlet("/Periode/Details")
public class PeriodeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PeriodeDAO periodeDAO;
    public PeriodeDetails() {
        super();
        periodeDAO = new PeriodeDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		Periode periode= new Periode();
		periode.setId(id);
		try {
			periode = periodeDAO.getById(id);
			String json = new Gson().toJson(periode);
			
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
