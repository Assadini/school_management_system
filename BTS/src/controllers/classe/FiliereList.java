package controllers.classe;

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

import Domaine.classe.Filiere;

import dao.classe.FiliereDAO;;

/**
 * Servlet implementation class filiereList
 */
@WebServlet("/Filiere/List")
public class FiliereList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FiliereDAO filiereDAO;
    public FiliereList() {
        super();
        filiereDAO = new FiliereDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Filiere> filieres= new ArrayList<Filiere>();
		try {
			filieres = filiereDAO.getAll();
			Gson gson = new GsonBuilder().create();
			gson.serializeNulls();
			String json = gson.toJson(filieres);
			
			/****Rtetard pour tester l'animation de cahragement d'ajax ***/
//			int timeToWait = 2; //second
//	        System.out.println("Loading filières ...");
//	        try {
//	            for (int i=0; i<timeToWait ; i++) {
//	                Thread.sleep(1000);
//	                System.out.print(".");
//	            }
//	        } catch (InterruptedException ie)
//	        {
//	            Thread.currentThread().interrupt();
//	        }
			/*** fin du retard**/
			
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

