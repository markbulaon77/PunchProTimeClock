package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseDeleteUserSchedule {
	
	private Connection conn;
	
	public DatabaseDeleteUserSchedule(Connection conn) 
	{
		this.conn = conn;
	}
	
	public boolean databaseDeleteUserSchedule(PunchProSchedule userSchedule) {
		
		boolean isDeleted = false;
		
		try {
			String sql = "DELETE FROM punchprodb.schedule where user_number = ? AND schedule_date = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1,userSchedule.getUserNumber());
			stmt.setString(2, userSchedule.getDate());
			
			int rowsDeleted = stmt.executeUpdate();
				if(rowsDeleted > 0) 
				{
					isDeleted = true;
				}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return isDeleted;
	}
}
