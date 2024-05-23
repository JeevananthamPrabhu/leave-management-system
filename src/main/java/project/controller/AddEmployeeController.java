package project.controller;

import java.sql.Statement;

import project.Connect;
import project.model.EmployeeDataModel;
import project.model.LeaveTrackingModel;


public class AddEmployeeController {
	EmployeeDataModel model;
	LeaveTrackingModel trackmodel=new LeaveTrackingModel();
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
public boolean storeleave() {
		
		try {
			Statement st=Connect.connectionStatement();
			for(String leavetype :trackmodel.getleavetypes()) {
				String sql="insert into leavestracking(empid,leavetype) values('"+model.getempid()+"','"+leavetype+"')";
				st.execute(sql);				
			}			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
