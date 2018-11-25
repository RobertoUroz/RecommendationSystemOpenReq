package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FinalizedRequirementsFinder {

	public ArrayList<FinalizedRequirementsGateway> findAll() throws SQLException {
		
		ArrayList<FinalizedRequirementsGateway> result = new ArrayList<>();
		
		String sql = "SELECT * FROM FinalizedRequirement";
	    
	         Connection conn = sqliteConnection.main();
	         Statement stmt  = conn.createStatement();
	         ResultSet rs    = stmt.executeQuery(sql);
	        
	        // loop through the result set
	        while (rs.next()) {
	            result.add(new FinalizedRequirementsGateway(rs.getString("idRequirement"), rs.getString("idUser")));
	        }
			return result;
		
	}
	
}
