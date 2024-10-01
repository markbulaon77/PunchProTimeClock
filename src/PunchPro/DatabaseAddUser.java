package PunchPro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class DatabaseAddUser {	

	private Connection conn;

	public DatabaseAddUser(Connection conn) {
		this.conn = conn;
	}

	public boolean addNewUser(String full_name, String user_email, String user_role) {
		
		boolean isAdded = false;
		
		try {
			String sql = "INSERT INTO punchprodb.punch_pro_users (user_fullname , user_email, role) VALUES ( ?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, full_name);
			stmt.setString(2, user_email);
			stmt.setString(3, user_role);
			
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 0) {
				isAdded = true;
			}
		} catch (SQLException e) {			
			System.out.println("Error: " + e.getMessage());
		}
		
				/*
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
	    }*/
		
		return isAdded;

	}

}
