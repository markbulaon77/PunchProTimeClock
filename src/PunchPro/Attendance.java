package PunchPro;

public class Attendance {
	private int attendanceId;
	private int userId;
	private String date;
	private String clockInTime;
	private String breakTime;
	private String lunchTime;
	private STring secondBreakTime;
	private String clockOutTime;
	
	public Attendance(int attendanceId, int userId, String date ) {
		this.attendanceId = attendanceId;
		this.userId = userId;
		this.date = date;
	}
	
	//Getter and Setter.
	
	public void updateBreak(String breakTime) {
		this.breakTime = breakTime;
		//SQL update to modify break time.
	}
	
	public void updateLunch(String lunchTime) {
	    this.lunchTime = lunchTime;
	    // SQL update to modify lunch time
	}

	public void 2ndBreak(String secondBreakTime){
		this.secondBreakTime = secondBreakTime;
	}
	public void clockOut(String clockOutTime) {
	    this.clockOutTime = clockOutTime;
	    // SQL update to record clock out time
	}
}
