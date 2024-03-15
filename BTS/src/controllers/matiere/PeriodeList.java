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

import Domaine.matiere.Periode;
import dao.matiere.PeriodeDAO;


/**
 * Servlet implementation class CycleList
 */
@WebServlet("/Periode/List")
public class PeriodeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PeriodeDAO periodeDAO;
    public PeriodeList() {
        super();
        //cycleDAO = new CycleDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Periode> periodes= new ArrayList<Periode>();
		String json=null;
		try {
			
			periodeDAO = new PeriodeDAO();
			periodes = periodeDAO.getAll();
			json = new Gson().toJson(periodes);
			
			
			
		} catch (SQLException e) {
			json = new Gson().toJson(e.getMessage()).toString();
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}
}
