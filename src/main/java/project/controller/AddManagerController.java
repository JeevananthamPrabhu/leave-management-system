package project.controller;

import java.sql.Statement;

import project.Connect;
import project.model.EmployeeDataModel;
import project.model.ManagerDataModel;

public class AddManagerController {
	ManagerDataModel model;
	public AddManagerController(ManagerDataModel model)
	{
		this.model=model;
	}
	public boolean store() {
		
		try {
			Statement st=Connect.connectionStatement();
			String sql="insert into managers(username,name,email) values('"+model.getusername()+"','"+model.getname()+"','"+model.getemail()+"')";
			st.execute(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
