package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class DatabaseAddUser {

	private Connection conn;
	
	public boolean addNewUser(DatabaseConnection dbConnection, PunchPro_User user) {
		
		boolean isAdded = false;
		
		String sql = "INSERT INTO punchprodb.punch_pro_users (user_fullname , user_email, role) VALUES ( ?,?,?)";
		
		try(Connection conn = dbConnection.connect_to_punchprodb();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, user.getUser_fullname());
			stmt.setString(2, user.getUser_email());
			stmt.setString(3, user.getUser_role());
			
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected > 0) {
				isAdded = true;
			}	
		}catch (SQLIntegrityConstraintViolationException e) {
	        System.out.println("User already exists. Duplicate entry detected.");
	    } catch (SQLException e) {
	        System.out.println("SQL Error: " + e.getMessage());
	    } catch (ClassNotFoundException e) {
	        System.out.println("Database driver not found: " + e.getMessage());
	    }
		
		return isAdded;

	}
}
