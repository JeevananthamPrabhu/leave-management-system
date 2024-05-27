package project.controller;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.Connect;
import project.model.EmployeeDataModel;
import project.model.SignInModel;
public class EmployeeSignInController {
	SignInModel model;
	public String name;
	public List<EmployeeDataModel> empList = new ArrayList<>();
	public List<EmployeeDataModel> leaveList = new ArrayList<>();
	public EmployeeSignInController(SignInModel model){
		this.model=model;
	}
	public boolean checkexists() {
		try {
			Statement st=Connect.connectionStatement();
			String sql="select * from employees where empid='"+model.getusername()+"'";
			ResultSet r=st.executeQuery(sql);
			if(r.next())
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;	
	}
	public boolean get() {
		try {
			Statement st=Connect.connectionStatement();
			String sql="select name from employees where empid='"+model.getusername()+"' and password='"+model.getpassword()+"'";
			ResultSet r=st.executeQuery(sql);
			if(r.next()) {
				name=r.getString(1);
				return true;
			}
	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;	
	}
	public boolean getempdata() {
		try {
			Statement st=Connect.connectionStatement();
			String sql="select * from employees";
			ResultSet r=st.executeQuery(sql);
			while(r.next()) {
				EmployeeDataModel m=new EmployeeDataModel();
				m.setempid(r.getString(1));
				m.setname(r.getString(3));
				m.setdept(r.getString(4));
				empList.add(m);
			}
			return true;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
