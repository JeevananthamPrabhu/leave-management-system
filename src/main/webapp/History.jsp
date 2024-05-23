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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="container">
    
        <div class="main">
           <%@include file="EmployeeSidebarHead.jsp" %>
            <div class="report">
            <br>
                <div class="table">
                    <div class="table-body">
                        <h1>Leave History</h1>
                        <table>
                            <thead>
                                <td>S.No</td>
                                <td>Leave Type</td>
                                <td>From Date</td>
                                <td>To Date</td>
                                <td>Reason</td>
                                <td>Current Status</td>
                            </thead>
                            <tbody>
                      <% Object ListObj = request.getAttribute("leaveList");
                        		int cnt=1;
                if(ListObj != null){
                	List<LeaveDataModel> leaveList = (List<LeaveDataModel>) ListObj;
                for(LeaveDataModel model : leaveList){
                    %>
                            	<tr>
	                            	<td><%=cnt %> </td>
	                                <td><%=model.getleavetype() %></td>
		                            <td><%=model.getfromdate() %></td>
		                            <td><%=model.gettodate() %></td>
		                            <td><%=model.getreason() %></td>
		                             <%if(model.getstatus()==1){%>
		                             <td>Approved</td>
		                             <%}else if(model.getstatus()==0){%>
		                             <td>Pending</td>
		                             <%}else{ %>
		                             <td>Declined</td>
		                             <%} %>
                            	</tr>
                                <% cnt++; } 
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