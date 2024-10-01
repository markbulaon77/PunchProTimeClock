package PunchPro;

import java.sql.SQLException;
import java.util.Scanner;

public class PunchPro {

	public static void main(String[] args) throws ClassNotFoundException {
		DatabaseConnection dbConnection = new DatabaseConnection();
		Scanner scanner = new Scanner(System.in);
		UserAuth userAuth = new UserAuth(dbConnection); //create an instance of the userAuth and pass the existing dbConnection to it.
		
		try {
			dbConnection.connect_to_punchprodb(); //Establishing connection
			loginMenu(scanner, dbConnection, userAuth);
		}catch(ClassNotFoundException e) {
			System.out.println("Database connection error: " + e.getMessage());
			e.printStackTrace();
		}finally {
			//make sure the scannner is closed when done.
			if(scanner !=null) {
				scanner.close();
			}
		}
			
		
		
		
		/*
		try {
			dbConnection.connect_to_punchprodb();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		while(true) {
			System.out.println("--------------------------WELCOME--------------------------");
			System.out.println("1. Login ");
			System.out.println("2. Exit");	
			
			int choice = scanner.nextInt();
		if(choice == 1){
			System.out.println("Please enter your username: ");
			String user_username = scanner.next();
				
			System.out.println("Please enter your password: ");
			String user_password = scanner.next();
				
			PunchPro_User punchProUser = new PunchPro_User(user_username,user_password);
			
			try {
				boolean isAuthenticated = userAuth.authenticate(punchProUser);
				if(isAuthenticated) {
					if(punchProUser.getUser_role().equals("admin")) {
						
						//this created an admin specific object using existing authenticated user details.
						PunchPro_Admin adminUser = new PunchPro_Admin(
								punchProUser.getUser_number(),
								punchProUser.getUser_fullname(),
								punchProUser.getUser_email(),
								punchProUser.getUser_username(),
								punchProUser.getUser_password(),
								punchProUser.getUser_role(),
								dbConnection
								);
						System.out.println("Hello admin " + punchProUser.getUser_fullname());
						PunchPro_AdminOperations adminOps = new PunchPro_AdminOperations(adminUser, dbConnection);
						adminOps.admin_menu();
						break;
					}else if(punchProUser.getUser_role().equals("user")) {
						System.out.println("Hello-User");
						break;
					}else {
						System.out.println("Unable to verify user role.");
						break;
					}
				}else {
                    System.out.println("Authentication failed. Please check your username and password.");
                }
			}catch(SQLException e) {
				System.out.println("Error: " + e);
			}
		}else if(choice == 2) {
				System.exit(0);
				scanner.close();
			}
		}*/	
	} 
	
	private static void loginMenu(Scanner scanner, DatabaseConnection dbConnection, UserAuth userAuth) throws ClassNotFoundException 
	{
		System.out.println("Please enter your username: ");
		String user_username  = scanner.nextLine();
		
		System.out.println("Please enter your password: ");
		String user_password = scanner.nextLine();
		
		PunchPro_User punchProUser = new PunchPro_User(user_username, user_password);
		try {
			boolean isAuthenticated = userAuth.authenticate(punchProUser);
			if(isAuthenticated) 
			{
				handleUserRole(punchProUser, dbConnection);
			}else {
				System.out.println("Authentication failed. Please check your credentials (Username or Password) ");
			}
		}catch(SQLException e) {
			System.out.println("Error during athentication: " + e.getMessage());
		}
	}
	
	private static void handleUserRole(PunchPro_User punchProUser, DatabaseConnection dbConnection) throws ClassNotFoundException {
		
		String userRole = punchProUser.getUser_role();
		
		if("admin".equalsIgnoreCase(userRole)) {
			PunchPro_Admin adminUser = new PunchPro_Admin(punchProUser.getUser_number(),
					punchProUser.getUser_fullname(),
					punchProUser.getUser_email(),
					punchProUser.getUser_username(),
					punchProUser.getUser_password(),
					punchProUser.getUser_role(),
					dbConnection);
			System.out.println("Hello admin " + punchProUser.getUser_fullname());
			PunchPro_AdminOperations adminOps = new PunchPro_AdminOperations(adminUser, dbConnection);
			adminOps.admin_menu();
			
		}else if("user".equalsIgnoreCase(userRole)) {
			System.out.println("Hello, " + punchProUser.getUser_fullname());
			//To do logic if User.
		}else {
			System.out.println("Unable to verify access to this app.... Please contact your system administrator.");
		}
	}
}

