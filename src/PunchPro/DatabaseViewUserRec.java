package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseViewUserRec {
	
	private Connection conn;

	public ArrayList<PunchPro_User> viewUserRecords(DatabaseConnection dbConnection, int pageNumber){
		
		int PAGE_SIZE = 5;
		int offset = pageNumber * PAGE_SIZE;
		ArrayList<PunchPro_User> userList = new ArrayList<>();
		
		String query = "SELECT * FROM punchprodb.punch_pro_users LIMIT ? OFFSET ? ";
		
		try {
			conn = dbConnection.connect_to_punchprodb();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setInt(1, PAGE_SIZE);
			stmt.setInt(2, offset);
			
			try(ResultSet rs = stmt.executeQuery()){
				System.out.println("---------------------------------------------------------------");
				System.out.printf("| %-10s | %-20s | %-20s |%n", "USERID", "USER_FULLNAME", "USER_ROLE");
				System.out.println("---------------------------------------------------------------");
				
				while(rs.next()) {
					// Fetch data from ResultSet and create a User object and to be added to the arraylist
					
					PunchPro_User user = new PunchPro_User(
							rs.getInt("user_number"),
							rs.getString("user_fullname"),
							rs.getString("role")
							);
					/*
					System.out.printf("| %-10d | %-20s | %-20s |%n",
					            rs.getInt("user_number"),
					            rs.getString("user_fullname"),
					            rs.getString("role"));*/
					
					//Add the User object to the arrayList
					userList.add(user);
					
					//Print the result to the console (optional);
					System.out.println(user.toString());
				}
				System.out.println("---------------------------------------------------------------");
			}
				
			}catch(SQLException e) {
				System.out.println("Error fetching user records: " + e.getMessage());
		}
		return userList;
	}
}	
	

