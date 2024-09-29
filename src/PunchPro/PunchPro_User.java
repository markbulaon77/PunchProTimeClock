package PunchPro;

public class PunchPro_User {
	private int user_number;
	private String user_fullname;
	private String user_email;
	private String user_username;
	private String user_password;
	private String user_role;

	PunchPro_User(int user_number) {
		this.user_number = user_number;
	}
	
	PunchPro_User(String user_username, String user_password){
		this.user_username = user_username;
		this.user_password = user_password;
	}
	
	PunchPro_User(int user_number, String user_fullname, String user_role) {
		this.user_number = user_number;
		this.user_fullname = user_fullname;
		this.user_role = user_role;
	}

	PunchPro_User(String user_fullname, String user_email, String user_role){
		this.user_fullname = user_fullname;
		this.user_email = user_email;
		this.user_role = user_role;
	}
	
	PunchPro_User(int user_number, String user_fullname, String user_email, String user_role){
		this.user_number = user_number;
		this.user_fullname = user_fullname;
		this.user_email = user_email;
		this.user_role = user_role;
	}
	
	PunchPro_User(int user_number, String user_fullname, String user_email, String user_username, String user_password, String user_role){
		this.user_number = user_number;
		this.user_fullname = user_fullname;
		this.user_email = user_email;
		this.user_username = user_username;
		this.user_password = user_password;
		this.user_role = user_role;
	}

	public int getUser_number() {
		return user_number;
	}

	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}

	public String getUser_fullname() {
		return user_fullname;
	}

	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	
	public String getUser_username() {
		return user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	
	
	@Override
	public String toString() {
		return String.format("| %-10d | %-20s | %-20s |", user_number, user_fullname, user_role);
	}
}

