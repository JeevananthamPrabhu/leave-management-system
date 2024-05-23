package project.controller;

import java.sql.Statement;

import project.Connect;
import project.model.EmployeeDataModel;


public class AddEmployeeController {
	EmployeeDataModel model;
	String addby;
	public AddEmployeeController(EmployeeDataModel model,String addby)
	{
		this.model=model;
		this.addby=addby;
	}
	public boolean store() {
		
		try {
			Statement st=Connect.connectionStatement();
			String sql="insert into employees(empid,name,dept,addby) values('"+model.getempid()+"','"+model.getname()+"','"+model.getdept()+"','"+addby+"')";
			st.execute(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
