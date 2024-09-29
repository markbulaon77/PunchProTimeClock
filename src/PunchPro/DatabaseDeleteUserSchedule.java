package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseDeleteUserSchedule {
	
	private Connection conn;
	
	public boolean DatabaseDeleteUserSchedule(DatabaseConnection dbConnection, PunchProSchedule userSchedule ) {
		
		boolean isDeleted = false;
		try {
			conn = dbConnection.connect_to_punchprodb();
			try {
				String sql = "DELETE FROM punchprodb.schedule where user_number = ? AND schedule_date = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1,userSchedule.getScheduleId());
				stmt.setString(2, userSchedule.getDate());
				int rowsDeleted = stmt.executeUpdate();
				if(rowsDeleted > 0) {
					isDeleted = true;
				}
			} catch (SQLException e) {
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage() + " call support at 1-888-255-3756");
		}

	
		
		
		return false;
	}
}
