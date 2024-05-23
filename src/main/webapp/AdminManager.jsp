<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="project.model.ManagerDataModel" %>
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
                        <h1>Managers</h1>
                        <table>
                            <thead>
                 
                                <td>S.No</td>
                                <td>Manager Name</td>
                                <td>Username</td>
                                <td>email</td>
                                <td>Current Status</td>
                            </thead>
                            <tbody>
                            <% Object ListObj = request.getAttribute("managerList");
                            		int cnt=1;
                if(ListObj != null){
                	List<ManagerDataModel> List = (List<ManagerDataModel>) ListObj;
                for(ManagerDataModel model : List){
                    %>
                            	<tr>
                            	
                            	<td><%=cnt %></td>
                                <td><%=model.getname() %></td>
                                <td><%=model.getusername() %></td>
                                <td><%=model.getemail() %></td>
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