package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseAddUserSchedule {
	
	public boolean addNewSchedule(DatabaseConnection dbConnection, PunchProSchedule userSchedule) {
		
		boolean isAdded = false;
		String sql = "INSERT INTO punchprodb.schedule (user_number, schedule_date, start_time, clock_out_time) VALUES (?,?,?,?)";
		Connection conn = null;
		
		try {
			conn = dbConnection.connect_to_punchprodb();
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, userSchedule.getUserId());
				stmt.setString(2, userSchedule.getDate());
				stmt.setString(3, userSchedule.getStartTime());
				stmt.setString(4, userSchedule.getClockOutTime());
				
				int rowsAffected = stmt.executeUpdate();
				if(rowsAffected > 0) {
					isAdded = true;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		
		
		
		return isAdded;
	
	}	
}
