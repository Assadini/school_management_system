package controllers.evaluation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domaine.evaluation.FormeEvaluation;

import com.google.gson.Gson;

import dao.evaluation.FormeEvaluationDAO;

/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/FormeEvaluation/Add")
public class FormeEvaluationAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FormeEvaluationDAO formeEvaluationDAO;  
    public FormeEvaluationAdd() {
        super();
        formeEvaluationDAO = new FormeEvaluationDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result=null;
		String code=request.getParameter("code");
		String nom_Fr= request.getParameter("nom_Fr");
		String nom_Ar=request.getParameter("nom_Ar");
		
		FormeEvaluation formeEvaluation = new FormeEvaluation();
		formeEvaluation.setCode(code);
		formeEvaluation.setNom_Fr(nom_Fr);
		formeEvaluation.setNom_Ar(nom_Ar);
		
		try {
			formeEvaluationDAO.insert(formeEvaluation);
			result="La forme d'évaluation à été ajoutée avec succès";
		} catch (SQLException e) {
			result="Impossible d'ajouter la forme d'évaluation";
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
