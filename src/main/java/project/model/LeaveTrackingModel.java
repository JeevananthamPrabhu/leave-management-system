package project.model;

public class LeaveTrackingModel {
	private String empid;
	private String leavetypes[]= {"Sick Leave","Vacation Leave","Personal Leave","Casual Leave"};
	private String leavetype;
	private int accrued;
	private int utilized;
	public String[] getleavetypes() {
		return leavetypes;
	}
	public String getleavetype() {
		return leavetype;
	}
	public String getempid() {
		return empid;
	}
	public int getaccrued() {
		return accrued;
	}
	public int getutilized() {
		return utilized;
	}
	public void setleavetype(String a) {
		 leavetype=a;
	}
	public void setempid(String a) {
		 empid=a;
	}
	public void setaccrued(int a) {
		accrued=a;
	}
	public void setutilized(int a) {
		utilized=a;
	}
}
