package controllers.etudiant;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Domaine.etudiant.Etudiant;
import Domaine.utilisateur.Utilisateur;

import dao.etudiant.EtudiantDAO;
import dao.utilisateur.UtilisateurDAO;



/**
 * Servlet implementation class ClasseController
 */
@WebServlet("/Etudiant/Delete")
public class EtudiantDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EtudiantDAO etudiantDAO;
    private UtilisateurDAO utililisateurDAO;
    public EtudiantDelete() {
        super();
        etudiantDAO = new EtudiantDAO();
        utililisateurDAO = new UtilisateurDAO();
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int etudinatId = Integer.parseInt(request.getParameter("id"));
		Etudiant etudiant = new Etudiant();
		etudiant.setId(etudinatId);
		String result = null;
		try {
			etudiantDAO.delete(etudiant);
			Utilisateur utilisateur= new Utilisateur();
			utilisateur.setId(etudiant.getId());
			utililisateurDAO.delete(utilisateur);
			/*
			 * Supprimer le dosier de l'utilisateur
			 */
			Properties prop = new Properties();
       	 	InputStream input = null;
			//Ouvrir le fichier de configuration de l'application
       	 	input = getClass().getClassLoader().getResourceAsStream("config.properties");
            // Charger les propriétés
       	 	prop.load(input);
            // Lire la propriété path:
       	 	String path=prop.getProperty("storagePath");
			
			String etudiantDirectory = path+"\\users\\user_"+utilisateur.getId();
			
			//Supprimer le dossier de l'étudiant
			deleteDirectory(etudiantDirectory);
			//Supprimer le dossier de son parent
			//TODO :  à faire !!!
			
			
			result = "L'étudint à été supprimé avec succès";
			
		} catch (SQLException e) {
			result = "Inpossible de supprimer cet étudiant : "+e.getMessage();
			e.printStackTrace();
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}
	/*
	 * Suppression d'un dossier
	 */
	private void deleteDirectory(String userDirectory) throws IOException{
		Path directory = Paths.get(userDirectory);
		Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
		   @Override
		   public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
		       Files.delete(file); 
		       return FileVisitResult.CONTINUE;
		   }

		   @Override
		   public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		       Files.delete(dir);
		       return FileVisitResult.CONTINUE;
		   }
		});
	}
}
