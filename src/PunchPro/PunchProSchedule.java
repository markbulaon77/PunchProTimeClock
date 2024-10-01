package PunchPro;

public class PunchProSchedule {
	
	private int scheduleId; 
	private int user_number; //Refers to the User Class or user number.
	private String date; //Scheduled Date or day of work. 
	private String startTime; //Start time of work.
	private String breakTime; //Break time.
	private String lunchTime; //Lunch time.
	private String clockOutTime; //Clock out time
	
	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getUserNumber() {
		return user_number;
	}

	public void setUserId(int user_number) {
		this.user_number = user_number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getBreakTime() {
		return breakTime;
	}

	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}

	public String getLunchTime() {
		return lunchTime;
	}

	public void setLunchTime(String lunchTime) {
		this.lunchTime = lunchTime;
	}

	public String getClockOutTime() {
		return clockOutTime;
	}

	public void setClockOutTime(String clockOutTime) {
		this.clockOutTime = clockOutTime;
	}

	public PunchProSchedule(int user_number, String date) {
		this.user_number = user_number;
		this.date = date;
	}
	
	public PunchProSchedule(int user_number, String date, String startTime, String clockOutTime) {
		this.user_number = user_number;
		this.date = date;
		this.startTime = startTime;
		this.clockOutTime = clockOutTime;
	}

	public PunchProSchedule (int scheduleId, int user_number, String date, String startTime, String breakTime, String lunchTime, String clockOutTime) {
		this.scheduleId = scheduleId;
		this.user_number = user_number;
		this.date = date;
		this.startTime = startTime;
		this.breakTime = breakTime;
		this.lunchTime = lunchTime;
		this.clockOutTime = clockOutTime;
	}	
}
