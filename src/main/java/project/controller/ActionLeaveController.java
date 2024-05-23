package project.controller;

import java.sql.ResultSet;
import java.sql.Statement;

import project.Connect;
import project.model.EmployeeDataModel;
import project.model.LeaveDataModel;

public class ActionLeaveController {
	LeaveDataModel model;
	public ActionLeaveController(LeaveDataModel model)
	{
		this.model=model;
	}
	public boolean setaction() {
		try {
			Statement st=Connect.connectionStatement();
			String sql="UPDATE leaves SET status = '"+model.getstatus()+"' WHERE leaveid= '"+model.getleaveid()+"'";
			st.execute(sql);
			return true;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
