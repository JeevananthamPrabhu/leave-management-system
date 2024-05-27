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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="container">
    	<div class="main">
        	<%@include file="EmployeeSidebarHead.jsp" %>
            <div class="report">
                <div class="add">
                    <h1>Apply Leave</h1>
                    <form action="ApplyLeaveServlet" method="post">
                        <div class="group">
                            <label for="fromdate">From Date:</label><br>
                            <input type="date" id="fromdate" name="fromdate" required>
                        </div>     
                        <div class="group">
                            <label for="todate">To Date:</label><br>
                            <input type="date" id="todate" name="todate" required>
                        </div>                 
                        <div class="group">
                            <label for="leavetype">Leave Type:</label><br>
                            <select name="leavetype" id="leavetype" required>
                              <option disabled selected >--choose leave type--</option>
                                                          <% Object ListObj = session.getAttribute("List");
                            		int cnt=1;
                if(ListObj != null){
                	List<LeaveTrackingModel> List = (List<LeaveTrackingModel>) ListObj;
                for(LeaveTrackingModel model : List){
                    %>
							  <option value="<%=model.getleavetype() %>"
							  <% if(model.getutilized()>=4){ %>
								  disabled 
							  ><%=model.getleavetype() %> - No Remaining Leaves</option>
							  <%}else{ %>
							  ><%=model.getleavetype() %></option>
							  <%} %>
							  <%cnt++;
                            	}
                            	}%>
							</select>
                        </div>
                        <div class="group">
                            <label for="Reason">Reason:</label><br>
                            <input type="text" id="Reason" name="reason" required>
                        </div>
                        <div class="group">
                            <button type="submit">Apply</button>
                        </div>
                    </form>
                 </div>
            </div>
        </div>
    </div>
</body>
</html>