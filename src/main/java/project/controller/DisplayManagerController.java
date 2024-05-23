package project.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.Connect;
import project.model.ManagerDataModel;

public class DisplayManagerController {
	public List<ManagerDataModel> managerList = new ArrayList<>();
	public boolean getdata() {
		try {
			Statement st=Connect.connectionStatement();
			String sql;
			sql="select * from managers";
			ResultSet r=st.executeQuery(sql);
			while(r.next()) {
				ManagerDataModel m=new ManagerDataModel();
				m.setusername(r.getString(2));
				m.setname(r.getString(1));
				m.setemail(r.getString(3));	
				managerList.add(m);
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
