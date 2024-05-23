package project.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.Connect;
import project.model.LeaveDataModel;
import project.model.SignInModel;

public class DisplayLeaveController {
	SignInModel model;
	public List<LeaveDataModel> leaveList = new ArrayList<>();
	public DisplayLeaveController(SignInModel model){
		this.model=model;
	}
	public boolean getleavedata() {
		try {
			Statement st=Connect.connectionStatement();
			String sql="select * from leaves where empid='"+model.getusername()+"'";
			ResultSet r=st.executeQuery(sql);
			while(r.next()) {
				LeaveDataModel m=new LeaveDataModel();
				m.setleavetype(r.getString(1));
				m.setfromdate(r.getString(2));
				m.settodate(r.getString(3));
				m.setreason(r.getString(4));
				m.setempname(r.getString(5));
				m.setempid(r.getString(6));
				m.setstatus(Integer.parseInt(r.getString(7)) );
				
				leaveList.add(m);
			}
			return true;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean getallleavedata(String username) {
		try {
			Statement st=Connect.connectionStatement();
			String sql;
			if(username.equals("admin"))
			 sql="select * from leaves";
			else
				sql="select leaves.leavetype,leaves.fromdate ,leaves.todate, leaves.reason, leaves.name, leaves.empid, leaves.status,leaves.leaveid from leaves inner join employees on leaves.empid=employees.empid where addby='"+username+"'";
			ResultSet r=st.executeQuery(sql);
			while(r.next()) {
				LeaveDataModel m=new LeaveDataModel();
				m.setleavetype(r.getString(1));
				m.setfromdate(r.getString(2));
				m.settodate(r.getString(3));
				m.setreason(r.getString(4));
				m.setempname(r.getString(5));
				m.setempid(r.getString(6));
				m.setstatus(Integer.parseInt(r.getString(7)) );
				m.setleaveid(r.getString(8));
				leaveList.add(m);
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
