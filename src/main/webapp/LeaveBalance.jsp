<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.model.LeaveTrackingModel" %>
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
        <%@include file="EmployeeSidebarHead.jsp" %>
            <div class="report">
                 <br>
                <div class="table">
                    <div class="table-body">
                        <h1>Leave balances Tracking</h1>
                        <table>
                            <thead>
                                <td>S.No</td>
                                <td>Leave Types</td>
                                <td>Accrued Leaves</td>
                                <td>Utilized Leaves</td>
                                <td>Remaining Leaves</td>
                            </thead>
                            <tbody>
                            <% Object ListObj = session.getAttribute("List");
                            		int cnt=1;
                if(ListObj != null){
                	List<LeaveTrackingModel> List = (List<LeaveTrackingModel>) ListObj;
                for(LeaveTrackingModel model : List){
                    %>
                            	<tr>
                            	
                            	<td><%=cnt %></td>
                                <td><%=model.getleavetype() %></td>
                                <td><%=model.getaccrued() %></td>
                                <td><%=model.getutilized() %></td>
                                <td><%=model.getaccrued()-model.getutilized() %></td>
                            	
                            	</tr>
                            	<%cnt++;
                            	}
                            	}%>
                            </tbody>
                        </table>
                    </div>
                </div>
                <br>
            </div>
        </div>
    </div> 
</body>
</html>