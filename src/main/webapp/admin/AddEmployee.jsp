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
                    <h1>Add Employee</h1>
                    <form id="employeeForm" action="AddEmployeeServlet" method="post">
                        <div class="group">
                            <label for="employeeName">Employee Name:</label><br>
                            <input type="text" id="employeeName" name="employeeName" required>
                        </div>     
                        <div class="group">
                            <label for="employeeID">Employee ID:</label><br>
                            <input type="text" id="employeeID" name="employeeID" required>
                        </div>                 
                        <div class="group">
                            <label for="employeeDepartment">Department:</label><br>
                            <input type="text" id="employeeDepartment" name="employeeDepartment" required>
                        </div>
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