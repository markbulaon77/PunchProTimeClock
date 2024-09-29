package PunchPro;

public class PunchPro_RegularUser extends PunchPro_User {

	PunchPro_RegularUser(int user_number, String user_fullname, String user_email, String user_username, String user_password,
			String user_role) {
		super(user_number, user_fullname, user_email, user_username, user_password, user_role);
	}
	
	public void user_clockin() {
		System.out.println(getUser_fullname() + " clocked in: ");
	}	
	
	public void user_take_break() {
		System.out.println(getUser_fullname() + " is on break" );
	}
	
	public void user_logout() {
		System.out.println(getUser_fullname() + " clocked out. ");
	}
	
	public void user_view_time_record() {
		System.out.println("Viewing your record.");
	}
}
