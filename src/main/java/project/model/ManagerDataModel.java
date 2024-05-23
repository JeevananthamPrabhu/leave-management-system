package project.model;

public class ManagerDataModel {
	private String username;
	private String name;
	private String email;
	public void setusername(String username)
	{
		this.username=username;
	}
	public void setemail(String email)
	{
		this.email=email;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getusername() {
		return username;
	}
	public String getemail() {
		return email;
	}
	public String getname() {
		return name;
	}
	
}
