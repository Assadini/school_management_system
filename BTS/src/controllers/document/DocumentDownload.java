package controllers.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocumentUpload
 */
@WebServlet("/Document/Download")
@MultipartConfig
public class DocumentDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path;
	private String uploadPath;
	private static final String DATA_DIRECTORY = "data";
	private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 3;
	private static final int MAX_REQUEST_SIZE = 1024 * 1024*2;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentDownload() {
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
	protected synchronized void doGet ( HttpServletRequest request, HttpServletResponse response ) 
	  throws ServletException, IOException 
	{
	  request.setCharacterEncoding("UTF-8");
	  OutputStream streamOut = response.getOutputStream();
	  String fileName = ( request.getParameter ("file") );
	  File file = new File ( fileName );
	  response.setContentLength ( ( int ) file.length() );
	 
	  // Changer le content-type de la réponse. 
	  //TODO : A Généraliser pour traiter les autres types de fichiers/
	  //       Utiliser peut etre une structure Switch Case pour traiter tous les types MIME (Les plus essentieles)
	  //	   Car ici seules les images sont prises en considération.
	  response.setContentType ( "image/" + fileName.substring ( fileName.lastIndexOf ( "." ) + 1 ) );
	  
	  InputStream streamIn = new FileInputStream (file);
	   
	  // Retourner le contenu du fichier dans le  output stream  
	  byte[] buffer = new byte [ 1024 ];
	  int count = 0;
	  while ( ( count = streamIn.read ( buffer ) ) >= 0 ) 
	  {
	    streamOut.write ( buffer, 0, count );
	  }
	}  
}
