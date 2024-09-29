package PunchPro;

public class PunchPro_Admin extends PunchPro_User {
	
	private PunchPro_AdminOperations adminOperations; //Create a single-responsibilty as per OOP policy
	
	PunchPro_Admin(int user_number, String user_fullname, String user_email, String user_username, String user_password, String user_role, DatabaseConnection dbConnection) {
		super(user_number, user_fullname, user_email, user_username, user_password, user_role);
		this.adminOperations = new PunchPro_AdminOperations(this, dbConnection); //passing the current instance of the admin method.
	}
	
	// Method to handle admin options
	public void adminOptions() {
			adminOperations.admin_menu();
	}
}  
