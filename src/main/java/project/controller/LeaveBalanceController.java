package project.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.Connect;
import project.model.EmployeeDataModel;
import project.model.LeaveDataModel;
import project.model.LeaveTrackingModel;

public class LeaveBalanceController {
	String empid ;
	LeaveTrackingModel model;
	public List<LeaveTrackingModel> List = new ArrayList<>();
	public LeaveBalanceController(String model) {
		empid=model;
	}
	public LeaveBalanceController(LeaveTrackingModel model) {
		this.model=model;
	}
	public boolean getleavedata() {
		try {
			Statement st=Connect.connectionStatement();
			String sql;
			sql="select * from leavestracking where empid='"+empid+"'";
			ResultSet r=st.executeQuery(sql);
			while(r.next()) {
				LeaveTrackingModel m=new LeaveTrackingModel();
				m.setleavetype(r.getString(2));
				m.setaccrued(Integer.parseInt(r.getString(3)));
				m.setutilized(Integer.parseInt(r.getString(4)));
				List.add(m);
			}
			return true;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean update() {
		try {
			Statement st=Connect.connectionStatement();
			System.out.println(model.getleavetype());
			String sql="UPDATE leavestracking SET utilized = utilized+1 WHERE empid= '"+model.getempid()+"' and leavetype='"+model.getleavetype()+"'";
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
