package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUpdateUserSchedule {
	
	private Connection conn;
	
	public DatabaseUpdateUserSchedule(Connection conn) {
		this.conn = conn;
	}

	public boolean DBUpdateUserSchedule(PunchProSchedule userSchedule) {
		boolean isUpdated = false;

		try {
			String sql = "UPDATE punchprodb.schedule SET schedule_date = ?, start_time = ?, clock_out_time = ? WHERE user_number = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userSchedule.getDate());
			stmt.setString(2, userSchedule.getStartTime());
			stmt.setString(3, userSchedule.getClockOutTime());
			stmt.setInt(4, userSchedule.getUserNumber());
			
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected > 0) {
				isUpdated = true;
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage() );
		}
		
	
		return isUpdated;
	}
	
}
