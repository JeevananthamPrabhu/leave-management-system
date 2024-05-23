package project.model;

public class EmployeeDataModel {
	private String empid;
	private String password;
	private String name;
	private String dept;
	public void setdept(String dept)
	{
		this.dept=dept;
	}
	public void setempid(String empid)
	{
		this.empid=empid;
	}
	public void setpassword(String password)
	{
		this.password=password;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getdept() {
		return dept;
	}
	public String getempid() {
		return empid;
	}
	public String getpassword() {
		return password;
	}
	public String getname() {
		return name;
	}
	
}
