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
    <style>
        *{
    margin: 0%;
    padding: 0%;
    list-style: none; 
    text-decoration: none;  
    font-family:Verdana, Geneva, Tahoma, sans-serif ;
}
.sidebar{
    background-color: blue ;
    position: fixed;
    left: -250px;
    height: 100vh;
    min-width: 250px;
    transition: 0.5s;
}
.sidebar ul{
    margin-top: 100px;
}
.sidebar li{
    padding-left: 20px;
}
.sidebar li a{
    display: block;
    color: white;
    box-sizing: border-box;
    width: 100%;
    padding: 20px;
    border-radius: 20px 0 0 20px;
}
.sidebar li i{
    padding: 0 30px 0 10px;
    font-size: x-large;
}
.sidebar li a:hover{
    color: white;
    background-color: #eeeeeea1;
}
.sidebar li a.active{
    color: blue;
    background-color: rgb(255, 255, 255);
}
.main-header{
    border-bottom: 1px solid rgba(0, 0, 0, 0.075);
    box-sizing: border-box;
    height: 70px;   
    display: flex;
}
.head-left{
    display: flex;
    align-items: center;
    width: 50%;
    height: 70px; 
    box-sizing: border-box;
    padding: 20px;
}
.head-left 
.fa-bars, .fa-xmark{
    cursor: pointer;
    font-size: 1.6rem;
}
#check{
    visibility:hidden;
}
.fa-xmark{
    display: none;
}
#check:checked ~ label .fa-bars{
    display: none;
}
#check:checked ~ label .fa-xmark{
    display: inline;
}
.head-left .heading{
    box-sizing: border-box;
    padding: 20px;
}
.head-left .heading h2{
    font-weight: 500;
}
.sidebar.active{
    left: 0px;  
}
.main{
    padding: 0;
    transition: 0.5s;
}   
.main.addpadding{
    padding-left: 250px;
}
.head-right{
    position: relative;      
    display: flex;
    align-items: center;
    justify-content: flex-end;
    width: 50%;
    height: 70px; 
}
.main-header .user-align{
    background-color: blue;
    color: white;
    display: flex;
    align-items: center;
    justify-content: space-around;
    box-sizing: border-box;
    padding: 15px;
    font-size: 20px;
    width: 220px;
    height: 70px;
    cursor: pointer;
}
.user-align > i{
    transition:  0.5s;    
}
.user-align:hover > i{
    transform: rotate(180deg);
}
.drop-logout{
    display: block;
    background-color: white;
    position: absolute;
    top: 100%;
    right: 10px;
    width: 200px;
    height: 0px;
    border-radius: 5px 5px 10px 10px;    
    text-align: center;
    box-shadow: 0 0 45px rgba(0, 0, 0, 0.041);
    overflow: hidden;
    transition: height 0.5s;
}
.drop-logout a{
    display: inline-block;
    text-decoration: none;
    box-sizing: border-box;
    font-size: large;
    font-weight: 500;
    width: 200px;
    height: 60px;
    border-radius: 5px 5px 10px 10px; 
    padding: 20px;
}
.drop-logout i{
    padding-right: 15px;
}
.drop-logout a:hover{
    color: blue;
}
.user-align:hover
.drop-logout{
    height: 60px;
}

.cards{
    display: grid;
    grid-template-columns: repeat(3,1fr);
    grid-gap: 2rem;
    margin: 1.5rem 1rem;
}


.table{
    padding: 1rem;
}
.table-body{
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.0963);
    padding: 1.7rem;
} 
table{
    width: 100%;
}
td{
    padding: 0.8rem;
}
table,td{
    text-align: center;
    border: 1px solid rgba(120, 130, 140, 0.13);
    border-collapse: collapse;    
}
.addleave{
    padding: 1rem;
}
.addleave h1{
    margin-bottom: 1rem;
}
.addleave{
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.0963);
    padding: 1.7rem;
    margin: 1rem;
}
.addleave h1{
    color: rgba(0, 0, 0, 0.658);
    font-size: large;
}
.addleave .group{
    padding: 1rem;
}
.group label{
    font-size: medium;
}
.group input{
    height: 30px;
    margin-top: 10px;
    width: 100%;
    outline: none;
    padding: 5px 10px ;
    border: 1px solid rgba(170, 170, 170, 0.3);
    border-radius: 4px;
    font-size: medium;
    color: #495057;
}
.group button{
    padding: 5px 10px;
    font-size: large;
}
h1{
    margin-bottom: 1rem;
    color: rgba(0, 0, 0, 0.658);
    font-size: large;
}
    </style>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <ul>
                <li>
                    <a href="Apply.jsp" ><i class="fa-solid fa-gauge"></i><span>Apply Leave</span></a>
                </li>
                <li>
                    <a href="DisplayLeaveServlet" class="active"><i class="fa-solid fa-id-card"></i><span>Leave History</span></a>
                </li>
            </ul>
        </div>
        <div class="main">
            <div class="main-header">
                <div class="head-left">
                    <div class="menu-icon">
                        <input type="checkbox" id="check">
                        <label for="check">
                            <i class="fa-solid fa-bars"></i>
                            <i class="fa-solid fa-xmark"></i>
                        </label>
                    </div>
                    <div class="heading">
                        <h2>Leave Management System</h2>
                    </div>                    
                </div>
                <div class="head-right">
                    <span class="user-align"><img src="img/emp.png" alt="user-logo" width="35px"><%=session.getAttribute("empname") %> <i class="fa-solid fa-angle-down"></i>
                        <div class="drop-logout">
                            <a href="LogoutServlet"><i class="fa-solid fa-right-from-bracket"></i>Log Out </a>
                        </div>
                    </span>
                </div>
            </div>
            <div class="report">
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
    <script>
         const check=document.querySelector('#check');
        const sidebar=document.querySelector('.sidebar');
        const main=document.querySelector('.main');
        check.addEventListener('change', function() {
            if (this.checked) {
                sidebar.classList.add('active');
                main.classList.add('addpadding');
            } else {
                sidebar.classList.remove('active'); 
                main.classList.remove('addpadding');
            }
        });
    </script>
</body>
</html>