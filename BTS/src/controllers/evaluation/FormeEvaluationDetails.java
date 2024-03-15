package controllers.evaluation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Domaine.evaluation.FormeEvaluation;

import dao.evaluation.FormeEvaluationDAO;

/**
 * Servlet implementation class FormeEvaluationList
 */
@WebServlet("/FormeEvaluation/Details")
public class FormeEvaluationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FormeEvaluationDAO formeEvaluationDAO;
    public FormeEvaluationDetails() {
        super();
        formeEvaluationDAO = new FormeEvaluationDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		FormeEvaluation formeEvaluation= new FormeEvaluation();
		formeEvaluation.setId(id);
		try {
			formeEvaluation = formeEvaluationDAO.getById(id);
			String json = new Gson().toJson(formeEvaluation).toString();
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
