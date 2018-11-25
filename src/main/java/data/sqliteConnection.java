package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class sqliteConnection {
     /**
     * Connect to a sample database
     */
	
	private static Connection conn = null;
	
    private static void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\UPC\\Becario\\Proyecto sistema recomnedacion\\RecommendationSystemOpenReq\\RecommendationSystemOpenReq\\src\\main\\resources\\OpenReqSystemRecommendation.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static Connection main() {
        if (conn == null) connect();
		return conn;
    }
}
