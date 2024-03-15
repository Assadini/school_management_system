package controllers.document;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

/**
 * Servlet implementation class DocumentUpload
 */
@WebServlet("/Document/Upload")
@MultipartConfig
public class DocumentUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		String result=null;
		//recuperer le dossirer de sauvegarde des données de l'application
		Properties prop = new Properties();
   	 	InputStream input = null;
   	 	//Ouvrir le fichier de configuration de l'application
   	 	input = getClass().getClassLoader().getResourceAsStream("config.properties");
        // Charger les propriétés
   	 	prop.load(input);
   	 	String storagePath=prop.getProperty("storagePath");
		String uploadDir="upload";
	   	String savePath = storagePath+ File.separator + uploadDir; 
	     File fileSaveDir=new File(savePath);
	     if(!fileSaveDir.exists()){
	         fileSaveDir.mkdir();
	     }
	     //Extraire le fichier reçu
		 Part part=request.getPart("file");
		 String fileName=extractFileName(part);
		 //Construire un nom unique pour le fichier reçu pour l'utiliser aprés
		
		 //	Extraire l'extension du fichier 
		 String extension = "";
		 int i = fileName.lastIndexOf('.');
		 if (i > 0) {
		     extension = fileName.substring(i+1);
		 }
		 //Extraire le nom du fichier sans extension
		 String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");
		 //Pour garantir l'unicité du nom de fichier nous allons lui ajouter la date systeme et un nombte aléatoire
		 Calendar time = Calendar.getInstance(); 
		 int randomNum = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
		 String fileNameToSave= fileNameWithOutExt+randomNum+time.getTimeInMillis()+"."+extension;
		 //System.out.println("nom du fichier : "+fileNameToSave);
		 //Sauvegarde du fichier reçu dans le dossier temporaire Uploads de l'application
		 part.write(savePath + File.separator + fileNameToSave);
   	 	
		String json = new Gson().toJson(fileNameToSave);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}
	private String extractFileName(Part part) {
	    String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    for (String s : items) {
	        if (s.trim().startsWith("filename")) {
	            return s.substring(s.indexOf("=") + 2, s.length()-1);
	        }
	    }
	    return "";
	}
}
