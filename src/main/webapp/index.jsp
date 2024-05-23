<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave Management System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="index.css">
</head>
<body>
    <div class="container">
        <div class="emp">
            <div class="login-head">
                <h1>Employee Login</h1>
                <h2>Leave Management System</h2>
            </div>
            <form action="EmployeeSignInServlet" method="post">
                <div class="form-group ">
                    <input type="text" id="Username" placeholder="Username" name="username" required>
                    <i class="fa-solid fa-envelope"></i>
                </div>
                <div class="form-group">
                    <input type="password" id="pwd" placeholder="Password" name="password" required> 
                    <i class="fa-solid fa-lock"></i>
                </div>
                <a href="#">Forgot Password?</a>
                <input class="btn" type="submit" value="Submit">
                <a onclick="manager()">Manager Login <i class="fa-solid fa-arrow-right"></i></a>
            </form>
        </div>
        <div class="admin" style=" display: none;">
            <div class="login-head">
                <h1>Manager Login</h1>
                <h2>Leave Management System</h2>          
            </div>
            <form action="ManagerSignInServlet" method="post">
                <div class="form-group ">
                    <input type="text" id="Username" placeholder="Username" name="username" required>
                    <i class="fa-solid fa-user"></i>
                </div>
                <div class="form-group">
                    <input type="text" id="pwd" placeholder="Password" name="password" required> 
                    <i class="fa-solid fa-lock"></i>
                </div>
                <input class="btn" type="submit" value="Submit">
                <a onclick="emp()"><i class="fa-solid fa-arrow-left"></i> Employee Login</a>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
            function emp()
            {
                document.querySelector(".admin").style.cssText = "display: none;";    
                document.querySelector(".emp").style.cssText = "display: block;";
            }
            function manager()
            {
                document.querySelector(".emp").style.cssText = "display: none;";
                document.querySelector(".admin").style.cssText = "display: block;";                
            }
            <% if (request.getAttribute("signinfail") != null) { %>
            Swal.fire({
                title: 'No Account Found !!!',
                text: 'Please Contact Manager..',
                icon: 'error',
                confirmButtonText: "Ok"            
              });
            <% } %>  
            <% if (request.getAttribute("signinfailinvalid") != null) { %>
            Swal.fire({
                title: 'Invalid Username or Password!',
                text: 'Check Login credentials...',
                icon: 'error',
                confirmButtonText: "Ok"            
              });
            <% } %>
    </script>
</body>
</html>