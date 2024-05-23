package project.controller;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.Connect;
import project.model.EmployeeDataModel;
import project.model.SignInModel;
public class ManagerSignInController {
	SignInModel model;
	public String name;
	public ManagerSignInController(SignInModel model){
		this.model=model;
	}
	public boolean checkexists() {
		try {
			Statement st=Connect.connectionStatement();
			String sql="select * from managers where username='"+model.getusername()+"'";
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
			String sql="select * from managers where username='"+model.getusername()+"' and password='"+model.getpassword()+"'";
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
}
