package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseDeleteUser {
	
	private Connection conn;
	
	public boolean deleteUser(DatabaseConnection dbConnection, PunchPro_User user) {
		boolean isDeleted = false;
		
		try {
			conn = dbConnection.connect_to_punchprodb();

			try {
				String sql = "DELETE FROM punchprodb.punch_pro_users where user_number = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, user.getUser_number());	
				int rowsDeleted = stmt.executeUpdate();
				
				if(rowsDeleted > 0) {
					isDeleted = true;
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver exception error: " + e);
		}
	
		return isDeleted;
	}
}
