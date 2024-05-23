package project.model;

public class LeaveDataModel {
	private String leavetype;
	private String fromdate;
	private String todate;
	private String reason;
	private String empname;
	private String empid;
	private String leaveid; 
	private int status;
	public void setleaveid(String leaveid) {
		this.leaveid=leaveid;
	}
	public void setempname(String empname) {
		this.empname=empname;
	}
	public void setleavetype(String leavetype) {
		this.leavetype=leavetype;
	}
	public void setfromdate(String fromdate) {
		this.fromdate=fromdate;
	}
	public void settodate(String todate) {
		this.todate=todate;
	}
	public void setreason(String reason) {
		this.reason=reason;
	}
	public void setempid(String empid) {
		this.empid=empid;
	}
	public void setstatus(int status) {
		this.status=status;
	}
	public String getleavetype() {
		return leavetype;
	}
	public String getfromdate() {
		return fromdate;
	}
	public String gettodate() {
		return todate;
	}
	public String getreason() {
		return reason;
	}
	public String getempid() {
		return empid;
	}
	public int getstatus() {
		return status;
	}
	public String getempname() {
		return empname;
	}
	public String getleaveid() {
		return leaveid;
	}

}
