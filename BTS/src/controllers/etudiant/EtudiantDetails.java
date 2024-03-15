package controllers.etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;





import Domaine.etudiant.Etudiant;
import dao.etudiant.EtudiantDAO;



/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Etudiant/Details")
public class EtudiantDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EtudiantDAO etudiantDAO;
    public EtudiantDetails() {
        super();
        etudiantDAO = new EtudiantDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int etudiantId = Integer.parseInt(request.getParameter("id"));
		Etudiant etudiant= new Etudiant();
		String json = null;
		try {
			etudiant = etudiantDAO.getById(etudiantId);
			
			ObjectMapper mapper = new ObjectMapper();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			mapper.setDateFormat(sdf);
			json = mapper.writeValueAsString(etudiant);
	
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
