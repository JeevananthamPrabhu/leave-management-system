package project.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.Connect;
import project.model.EmployeeDataModel;

public class DisplayEmployeeController {
	public List<EmployeeDataModel> empList = new ArrayList<>();
	String addby;
	public DisplayEmployeeController(String addby)
	{
		this.addby=addby;
	}
	public boolean getempdata() {
		try {
			Statement st=Connect.connectionStatement();
			String sql;
			if(addby.equals("admin"))
				 sql="select * from employees";
			else
				 sql="select * from employees where addby='"+addby+"'";
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
