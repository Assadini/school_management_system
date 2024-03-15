package dao.database;



import com.mysql.jdbc.Connection;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

public final class Db {
    public Connection con;
    public static Db db;
    private String url;
    private String dbName;
    private String charsetEncoding;
    private String driver;
    private String userName;
    private String password;
    private Db() {
        
        try {
        	 DriverManager.registerDriver( new com.mysql.jdbc.Driver());
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
        	 Properties prop = new Properties();
        	 InputStream input = null;
        	 //Ouvrir le fichier de configuration de l'application
        	 input = getClass().getClassLoader().getResourceAsStream("config.properties");
             // Charger les propriétés
        	 prop.load(input);
             // Lire les valeurs des propriétés
        	 this.dbName=prop.getProperty("dbName");
             this.url=prop.getProperty("url");
             this.userName=prop.getProperty("userName");
             this.password=prop.getProperty("password");
             this.charsetEncoding="?characterEncoding="+prop.getProperty("charsetEncoding");
             this.driver="com.mysql.jdbc.Driver";
             //Créer la connection à la base de données
             this.con = (Connection)DriverManager.getConnection(url+dbName+charsetEncoding,userName,password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @return Db objet
     */
    public static synchronized Db getInstance() {
        if ( db == null ) {
            db = new Db();
        }
        return db;
    }
}
