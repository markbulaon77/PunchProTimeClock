package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseViewUserSchedule {
	
	private Connection conn;
	
	public DatabaseViewUserSchedule(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<PunchProSchedule> viewUserSchedule(int user_number, int year, int month){
		ArrayList<PunchProSchedule> userSchedList = new ArrayList<>();	
		
		//Query to filter by month and year
		String sql = "SELECT * FROM punchprodb.schedule WHERE user_number = ? AND YEAR(schedule_date) = ? AND MONTH(schedule_date) = ? ORDER BY DAY(schedule_date)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user_number);
			stmt.setInt(2, year);
			stmt.setInt(3, month);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				PunchProSchedule schedule = new PunchProSchedule(
						rs.getInt("schedule_id"),
						rs.getInt("user_number"),
						rs.getString("schedule_date"),
						rs.getString("start_time"),
						rs.getString("break_time"),
						rs.getString("lunch_time"),
						rs.getString("clock_out_time")
						);
				userSchedList.add(schedule);	
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return userSchedList;
	}
}
