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
@WebServlet("/FormeEvaluation/Delete")
public class FormeEvaluationDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FormeEvaluationDAO formeEvaluationDAO;
    public FormeEvaluationDelete() {
        super();
        formeEvaluationDAO = new FormeEvaluationDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		int id =Integer.parseInt(request.getParameter("id"));
		FormeEvaluation formeEvaluation= new FormeEvaluation();
		formeEvaluation.setId(id);
		try {
			formeEvaluationDAO.delete(formeEvaluation);
			result="La forme d'évaluation à été supprimée avec succès";
		} catch (SQLException e) {
			result="Impossible de supprimer la forme d'évaluation";
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
