package PunchPro;

import java.util.ArrayList;
import java.util.Scanner;

public class PunchPro_AdminOperations {
	
	private DatabaseAddUserSchedule dbAddUserSchedule;
	private DatabaseViewUserSchedule dbViewUserSchedule;
	private DatabaseUpdateUserSchedule dbUpdateUserSchedule; 
	private DatabaseDeleteUserSchedule dbDeleteUserSchedule;
	private ArrayList<PunchProSchedule> arrUserSchedList;
	private DatabaseAddUser dbAddUser;
	private DatabaseViewUserRec dbViewUserRecords;
	private DatabaseUpdateUser dbUpdateUserRecords;
	private DatabaseDeleteUser dbDelUser;
	private DatabaseConnection dbConnection;
	private PunchProSchedule userSchedule;
	private PunchPro_Admin admin; //Creating a reference from the admin user.
	private PunchPro_User user; //for creating a of a new instance of the user.
	private Scanner scanner;
	
	public PunchPro_AdminOperations (PunchPro_Admin admin, DatabaseConnection dbConnection) {
		this.admin = admin;
		this.dbConnection = dbConnection;
		this.scanner = new Scanner(System.in);
		this.dbAddUser = new DatabaseAddUser();
		this.dbViewUserRecords = new DatabaseViewUserRec();
		this.dbUpdateUserRecords = new DatabaseUpdateUser();
		this.dbDelUser = new DatabaseDeleteUser();
		this.dbAddUserSchedule = new DatabaseAddUserSchedule();
		this.dbViewUserSchedule = new DatabaseViewUserSchedule();
		this.dbUpdateUserSchedule = new DatabaseUpdateUserSchedule();
		this.dbDeleteUserSchedule = new DatabaseDeleteUserSchedule();
		this.arrUserSchedList = new ArrayList<PunchProSchedule>();
	} 
	
	public void addNewUser(DatabaseConnection dbConnection) {
		System.out.println("Hello " + admin.getUser_fullname() + "\n");
		System.out.println("*****************************************");
		System.out.println("Please enter user full-name: ");
		String user_fullname = scanner.nextLine();
		
		System.out.println("Please enter user email-address: ");
		String user_email = scanner.nextLine();
		
		System.out.println("Please add the role of the user: ");
		String user_role = scanner.next();
		
		PunchPro_User user;
		
		if(user_fullname != null && user_email != null && user_role !=null) {
			user = new PunchPro_User(user_fullname, user_email, user_role);
			boolean userIsAdded = dbAddUser.addNewUser(dbConnection,user);
			
			if(userIsAdded) {
				System.out.println("User added sucessfully....");
			}else {
				System.out.println("User failed to be added....");
			}	
		}else {
			System.out.println("Please provide all valid input for the fields....");
		}
	}
	
	public void viewUserRecord(DatabaseConnection dbConnection, int pageNumber) {
		dbViewUserRecords = new DatabaseViewUserRec();
		dbViewUserRecords.viewUserRecords(dbConnection,pageNumber);		
	} 
	
	public void updateUserRecord(DatabaseConnection dbConnection) {
		
		System.out.println("Enter the user number of user to be updated: ");
		int user_number = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter updated user name: ");
		String user_fullname = scanner.nextLine();
		
		System.out.println("Enter updated email: ");
		String user_email = scanner.nextLine();
		
		System.out.println("Is role to be updated?");
		String updateRole = scanner.nextLine();
		
		if(updateRole.equalsIgnoreCase("Y")) {
			System.out.println("Enter the new user-role: ");
			String role = scanner.nextLine();
			user = new PunchPro_User(user_number, user_fullname, user_email ,role);
			boolean recordUpdated = dbUpdateUserRecords.updateUser(dbConnection, user);
			if(recordUpdated) {
			    System.out.println("Record updated successfully.");
			}else {
				System.out.println("Record-failed to update");
			}
		}else if(updateRole.equalsIgnoreCase("N")) {
			user = new PunchPro_User(user_number, user_fullname, user_email);
			boolean recordUpdated = dbUpdateUserRecords.updateUser(dbConnection, user);
			if(recordUpdated) {
				System.out.println("Record updated.....");
			}else {
				System.out.println("Record-failed to update");
			}
		}		
	}
	
	public void deleteUserRecord(DatabaseConnection dbConnection) {
		//instance of the delete user class.
		System.out.println("Enter the user_number of the user to be remove from records: ? ");
		int user_number = scanner.nextInt();

		if(user_number > 0) {
			user = new PunchPro_User(user_number);
			boolean isDeleted = dbDelUser.deleteUser(dbConnection, user);
			if(isDeleted) {
				System.out.println("User is remove...");
			}else {
				System.out.println("Failed to delete the user.");
			}
		}else {
			System.out.println("Please enter a positive number or the correct user_number.");
		}
	}
	
	public void addUserSchedule(DatabaseConnection dbConnection) {
		
		System.out.println("Enter user id: ");
		int user_number = scanner.nextInt();
		scanner.nextLine(); // to consume next line..
		
		System.out.println("Enter the user schedule format (YYYY-MM-DD: )");
		String user_schedule_date = scanner.nextLine();
		
		System.out.println("Enter the user shift start format (HH:MM:SS: )");
		String user_start_time = scanner.nextLine();
		
		System.out.println("Ente user end shfit time format (HH:MM:SS: )");
		String user_clockout_time = scanner.nextLine();
		
		if(user_number != 0 && user_schedule_date !=null && user_start_time !=null && user_clockout_time !=null) {
			userSchedule = new PunchProSchedule(user_number, user_number, user_schedule_date, user_start_time, user_clockout_time, user_clockout_time, user_clockout_time);
			boolean scheduleAdded = dbAddUserSchedule.addNewSchedule(dbConnection, userSchedule);
			
			if(scheduleAdded) {
				System.out.println("Schedule Added...");
			}else {
				System.out.println("Failed to add schedule...");
			}
		}else {
			System.out.println("Please provide all valid details needed.");
		}
	}
	
	public void updateUserSchedule(DatabaseConnection dbConnection) {
		System.out.println("Enter user id: ");
		int user_number = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the user updated scheduled date: format (YYYY-MM-DD: )");
		String user_schedule_date = scanner.nextLine();
		
		System.out.println("Enter the user updated time start format (HH:MM:SS: )");
		String user_start_time = scanner.nextLine();
		
		System.out.println("Enter the user updated end time format (HH:MM:SS: )");
		String user_clockout_time = scanner.nextLine();
		
		if(user_number != 0 && user_schedule_date != null && user_start_time != null && user_clockout_time != null) {
			userSchedule = new PunchProSchedule(user_number, user_schedule_date, user_start_time, user_clockout_time );
			boolean scheduleUpdate = dbUpdateUserSchedule.DatabaseUpdateUserSchedule(userSchedule, dbConnection);
			if(scheduleUpdate) {
				System.out.println("Schedule have updated....");
			}else {
				System.out.println("Schedule update failed...");
			}
		}
	}
	
	public void viewUserSchedule(DatabaseConnection dbConnection) {
	this.dbConnection = dbConnection;
		
	System.out.println("Enter user id: ");
	int user_number = scanner.nextInt();

	System.out.println("Enter the year (e.g 2023): ");
	int year = scanner.nextInt();
	
	System.out.println("Enter the month (1-12)");
	int month = scanner.nextInt();
	
	arrUserSchedList = 	dbViewUserSchedule.viewUserSchedule(dbConnection, user_number, year, month);
	
	//Displaying the schedules.
	if(!arrUserSchedList.isEmpty()) {
		for(PunchProSchedule schedule : arrUserSchedList) {
				System.out.println("Date: " + schedule.getDate() +
						" | Start Time: " + schedule.getStartTime() +
						" | Break Time: " + schedule.getBreakTime() + 
						" | Lunch Time: " + schedule.getLunchTime() + 
						" | Clock-Out Time: " + schedule.getClockOutTime());
			}
		}else {
			System.out.println("No schedules found for the selected month and year.");
		}
	
	
	while(true) {
		System.out.println("Schedule options. \n"
				+ "1. Add a new user schedule: \n"
				+ "2. View user schedule: \n"
				+ "3. Update/Edit a user schedule: \n"
				+ "4. Delete a user schedule: \n"
				+ "5. Back to admin menu: \n");
		
		int choice = scanner.nextInt();
		
		switch(choice){
		case 1:
			addUserSchedule(dbConnection);
			break;
		case 2:
			viewUserSchedule(dbConnection);
			break;
		case 3:
			updateUserSchedule(dbConnection);
			break;
		case 4:
			deleteUserSchedule(dbConnection);
			break;
		case 5:
			admin_menu();
			break;
		default:
			System.out.println("Select from the option only");
			break;
			}	
		} 
	}
	
	public void deleteUserSchedule(DatabaseConnection dbConnection) {
		System.out.println("Enter the user number:");
		int user_number = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the date of the be deleted...");
		String user_schedule_date = scanner.nextLine();
		
		if(user_number != 0 && user_schedule_date != null) {
			userSchedule = new PunchProSchedule(user_number, user_schedule_date);
			boolean scheduleDeleted = dbDeleteUserSchedule.DatabaseDeleteUserSchedule(dbConnection, userSchedule);
			if(scheduleDeleted) {
				System.out.println("Schedule deleted...");
			}else {
				System.out.println("Failed to delete user record....");
			}
		}else {
			System.out.println("Please provide the asked details.");
		}
	}
	
	public void admin_menu(){	
		boolean choosing = true;
		int currentPage = 0;
		scanner = new Scanner(System.in);
		
		while(choosing) {
				System.out.println("\n"
						+ "1. ADD NEW USER. \n"
						+ "2. VIEW ALL USER RECORD. \n"
						+ "3. UPDATE USER RECORD \n"
						+ "4. REMOVE A USER RECORD \n"
						+ "5. ADD USER SCHEDULE \n"
						+ "6. VIEW USER SCHEDULE \n"
						+ "7. UPDATE USER SCHEDULE \n"
						+ "8. REMOVE USER SCHEDULE \n"
						+ "9. BACK TO HOME SCREEN \n"
						+ "0. LOGOUT OR EXIT.... \n");
			int choice = scanner.nextInt();	
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				addNewUser(dbConnection);
				break;
			case 2:
				String command = "";
				do {
					viewUserRecord(dbConnection, currentPage);
					System.out.println("Commands: 'next', 'prev', 'exit'.");
					command = scanner.nextLine().trim().toLowerCase();
					
					if(command.equals("next")) {
						currentPage++;
					}else if(command.equals("prev") && currentPage > 0) {
						currentPage--;
					}
				}while(!command.equals("exit"));
				break;
			case 3:
				updateUserRecord(dbConnection);
				break;
			case 4:
				deleteUserRecord(dbConnection);
				break;
			case 5:
				addUserSchedule(dbConnection);
				break;
			case 6:
				viewUserSchedule(dbConnection);
				break;
			case 7: 
				updateUserSchedule(dbConnection);
				break;
			case 8:
				deleteUserSchedule(dbConnection);
				break;
			case 0:
				choosing = false;
				break;
			default:
				System.out.println("Please select a valid selection.");
			}
		}
		
		System.out.println();
	}
}
