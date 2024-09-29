package PunchPro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private Connection conn; // Single connection instance that to be use.
	private static final String URL = "jdbc:mysql://localhost:3306/punchprodb";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	
	//As per stack overflow one instance of connection and only once to be reuse.
	public Connection connect_to_punchprodb() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		
		if(conn !=null) {
			//System.out.println("Database connection is sucessful");
		}else {
			//System.out.println("Database connection failed");
		}
		return conn;
	}
	
	//Close the connection if no longer needed.
	public void closeConnection() {
		if(conn != null) {
			try {
				//Closing the connection to free resources.
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
