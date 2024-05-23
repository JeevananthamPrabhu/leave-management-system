<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                <div class="add">
                    <h1>Add Manager</h1>
                    <form id="managerForm" action="AddManagerServlet" method="post">
                        <div class="group">
                            <label for="managerName">Manager Name:</label><br>
                            <input type="text" id="managerName" name="managerName" required>
                        </div>     
                        <div class="group">
                            <label for="managerID">Manager ID:</label><br>
                            <input type="text" id="managerID" name="managerID" required>
                        </div>         
                        <div class="group">
                            <label for="emailID">Email ID:</label><br>
                            <input type="text" id="emailID" name="emailID" required>
                        </div>         
                        <div class="group">
                        <div class="group">
                            <button type="submit">Add</button>
                        </div>
                    </form>
                 </div>
                 <br>
            </div>
        </div>
    </div>
</body>
</html>