package data;

import java.util.ArrayList;
import java.sql.*;

public class UserFinder {

	
	public ArrayList<UserGateway> findAll() throws SQLException {
			
		ArrayList<UserGateway> result = new ArrayList<>();
		
		String sql = "SELECT * FROM User";
	    
	         Connection conn = sqliteConnection.main();
	         Statement stmt  = conn.createStatement();
	         ResultSet rs    = stmt.executeQuery(sql);
	        
	        // loop through the result set
	        while (rs.next()) {
	            result.add(new UserGateway(rs.getString("id"), rs.getString("name"), rs.getString("password")));
	        }
			return result;
	}
	
	public UserGateway findById(String id) throws SQLException {
		
		//temporary
		UserGateway result = null;
		
		String sql = "SELECT * FROM User u WHERE u.id = '"+id+"'";
	    
	         Connection conn = sqliteConnection.main();
	         Statement stmt  = conn.createStatement();
	         ResultSet rs    = stmt.executeQuery(sql);
	        
	        // loop through the result set
	        while (rs.next()) {
	            result = new UserGateway(rs.getString("id"), rs.getString("name"), rs.getString("password"));
	        }
			return result;
	}

}