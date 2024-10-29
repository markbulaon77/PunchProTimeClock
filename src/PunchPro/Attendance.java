package PunchPro;

public class Attendance {
	private int attendanceId;
	private int userId;
	private String date;
	private String clockInTime;
	private String breakTime;
	private String lunchTime;
	private String secondBreakTime;
	private String clockOutTime;
	
	public Attendance(int attendanceId, int userId, String date ) {
		this.attendanceId = attendanceId;
		this.userId = userId;
		this.date = date;
	}
	//Getter and Setter.
	public void setAttendanceId(int attendanceId){
		this.attendanceId = attendanceId;
	}

	public int getAttendanceId{
		return attendanceId;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId{
		return userId;
	}

	public void setDate(String date){
		this.date = date;
	}

	public string getDate{
		return date;
	}

	public void setClockInTime(String clockInTime){
		this.clockInTime = clockInTime;
	}

	public string getClockInTime{
		return clockInTime;
	}

	public void setBreakTime(String breakTime){
		this.breakTime = breakTime;
	}

	public String getBreakTime{
		return breakTime;
	}

	public void setLunchTime(String lunchTime){
		this.lunchTime = lunchTime;
	}

	public String getLunchTime{
		return lunchTime;
	}
	
	public void setsecondBreakTime(String secondBreakTime){
		this.secondBreakTime = secondBreakTime;
	}

	public String getSecondBreakTime{
		return secondBreakTime;
	}

	public void setClockOutTime(String clockOutTime ){
		this.clockOutTime = clockOutTime;
	}

	public String getclockOutTime{
		return clockOutTime;
	}
}

