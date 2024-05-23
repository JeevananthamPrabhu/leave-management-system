<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.model.EmployeeDataModel" %>
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
                        <h1>Employees</h1>
                        <table>
                            <thead>
                 
                                <td>S.No</td>
                                <td>Employee Name</td>
                                <td>Employee ID</td>
                                <td>Department</td>
                                <td>Current Status</td>
                            </thead>
                            <tbody>
                            <% Object empListObj = request.getAttribute("empList");
                            		int cnt=1;
                if(empListObj != null){
                	List<EmployeeDataModel> empList = (List<EmployeeDataModel>) empListObj;
                for(EmployeeDataModel model : empList){
                    %>
                            	<tr>
                            	
                            	<td><%=cnt %></td>
                                <td><%=model.getname() %></td>
                                <td><%=model.getempid() %></td>
                                <td><%=model.getdept() %></td>
                                <td>Active</td>
                            	
                            	</tr>
                            	<% cnt++;} 
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