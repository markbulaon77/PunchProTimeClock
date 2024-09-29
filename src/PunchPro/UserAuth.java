package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuth {
	private DatabaseConnection dbConnection;
	
	public UserAuth(DatabaseConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public boolean authenticate(PunchPro_User punchProUser) throws SQLException {

		boolean isAuthenticated = false;
		String query = "SELECT * FROM punchprodb.punch_pro_users WHERE user_username = ? AND user_password = ?";
 
		try {
			//Get the connection from the database connection class & Prepared statement to prevent SQL injection.
			Connection conn = dbConnection.connect_to_punchprodb();
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, punchProUser.getUser_username());
			pstmt.setString(2, punchProUser.getUser_password());
			
			try(ResultSet rs = pstmt.executeQuery()){ //cursor checking rows and executing the query.
				if(rs.next()) { 
					isAuthenticated = true;
					String userRole = rs.getString("role");
					String userFullName = rs.getString("user_fullname");
					punchProUser.setUser_role(userRole);
					punchProUser.setUser_fullname(userFullName);
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error: " + e);
		}
		
		return isAuthenticated;
	}
}
