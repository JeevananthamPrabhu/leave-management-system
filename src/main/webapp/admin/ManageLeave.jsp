<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.model.LeaveDataModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave Management System</title>
</head>
<body>
    <div class="container">
        <div class="main">
        	<%@include file="AdminSidebarHead.jsp" %>
        	<div class="report">
                <br>
                <div class="table">
                    <div class="table-body">
                        <h1>Manage Leave</h1>
                        <table>
                            <thead>
                                <tr>
                                    <td>S.No</td>
                                    <td>Employee Name</td>
                                    <td>Employee ID</td>
                                    <td>Leave Type</td>
                                    <td>From Date</td>
                                    <td>To Date</td>
                                    <td>Reason</td>
                                    <td>Current Status</td>
                                    <td>Action</td>
                                </tr>    
                            </thead>
                            <tbody>
                                <tr>
                                    <% Object ListObj = request.getAttribute("leaveList");
                            		int cnt=1;
                if(ListObj != null){
                	List<LeaveDataModel> leaveList = (List<LeaveDataModel>) ListObj;
                for(LeaveDataModel model : leaveList){
                    %>
                            	<tr>
	                            	<td><%=cnt %> </td>
	                                <td><%=model.getempname() %></td>
		                            <td><%=model.getempid() %></td>
		                            <td><%=model.getleavetype() %></td>
		                            <td><%=model.getfromdate() %></td>
		                            <td><%=model.gettodate() %></td>
		                            <td><%=model.getreason() %></td>
		                             <%if(model.getstatus()==1){%>
		                             <td>Approved</td>
		                             <%}else if (model.getstatus()==0){%>
		                             <td>Pending</td>
		                             <%}else{ %>
		                             <td>Declined</td>
		                             <%} %>
		                             <td>                          
                                        <form  action="ActionLeaveServlet?action=1&leaveid=<%=model.getleaveid() %>" method="post">
                                            <button type="submit" > Approve </button>                    	                       
                                        </form>
                                        <br>
                                        <form action="ActionLeaveServlet?action=2&leaveid=<%=model.getleaveid() %>" method="post">
                                            <button type="submit"> Decline </button>
                                        </form>
                                    </td>
                               </tr>
                                <% cnt++;} 
                    }%>                             
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>   
  
</body>
</html>