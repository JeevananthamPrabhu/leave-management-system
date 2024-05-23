package project.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.Connect;
import project.model.LeaveDataModel;

public class ApplyLeaveController {
	LeaveDataModel model;
	public List<LeaveDataModel> resultList = new ArrayList<>();
	public ApplyLeaveController(LeaveDataModel model){
		this.model=model;
	}
public boolean store() {
		try {
			Statement st=Connect.connectionStatement();
			String sql="insert into leaves (leavetype,fromdate,todate,reason,empid,name) values('"+model.getleavetype()+"','"+model.getfromdate()+"','"+model.gettodate()+"','"+model.getreason()+"','"+model.getempid()+"','"+model.getempname()+"')";
			st.execute(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
