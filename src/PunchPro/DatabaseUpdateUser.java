package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUpdateUser {
	
	private Connection conn;
	
	DatabaseUpdateUser(Connection conn) {
		this.conn = conn;
	} 
	
	public boolean updateUserRecord(PunchPro_User user) {
		boolean isUpdated = false;
		
		try {
			String sql = "UPDATE punchprodb.punch_pro_users SET user_fullname = ?, user_email = ?, role = ? WHERE user_number = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUser_fullname());
			stmt.setString(2, user.getUser_email());
			stmt.setString(3, user.getUser_role());
			stmt.setInt(4, user.getUser_number());
			
			int rowsUpdated = stmt.executeUpdate();
			
			if(rowsUpdated > 0) {
				isUpdated = true;
			}
			
		} catch (SQLException e) {
			System.out.println("Unable to connect to the database." + e.getMessage());
		}
		
		return isUpdated;
	}
}
