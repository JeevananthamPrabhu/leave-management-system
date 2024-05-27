<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave Management System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style type="text/css">
    	*{
    padding: 0%;
    margin: 0%;
}
body{
    background-image: url(img/bg-01.jpg);
    background-attachment: fixed;
    background-repeat: no-repeat;
    background-size: cover;
}
.container{
    background-color: white;
    position: absolute;
    top: 50%;
    left: 50%;
    translate: -50% -50%;
    padding: 50px ;
    width: fit-content;
    text-align: center;
    font-family:'Lucida Sans', sans-serif;
    border-radius: 15px;
}
h1{
    padding: 10px 0 15px 0;
}
.login-head{
    padding-bottom: 40px;
    color: rgb(102, 7, 190);
}
.form-group{
    margin-bottom: 20px;
    position: relative;
    color: gray;
}
.form-group i{
    position: absolute;
    top: 50%;
    left: 90%;
    translate: -50% -50%;
}
.form-group input{
    box-sizing: border-box;
    height: 30px;
    width: 100%;
    border: 1px solid gray;
    padding: 20px 10px;
    outline: none;
    border: none;
    border-radius: 5px;
    color: gray;
    background-color: rgba(128, 128, 128, 0.123);
    font-size: 15px;
}
.btn{
    text-transform: uppercase;
    cursor: pointer;
    box-shadow: 0 0 22px rgba(0, 0, 0, 0.05);
}
form a{
    text-decoration: none;
    cursor: pointer;
    color: rgb(86,22,179);
    font-weight: 700;
}
.btn{
    display: block;
    box-sizing: border-box;
    width: 100%;
    height: 40px;
    margin: 20px 0;
    padding: 10px;
    border: none;
    border-radius: 50px;
    background-image: linear-gradient(to right,rgba(0, 0, 255, 0.425),violet);
    color: white;
}
    	
    </style>
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
                    <i class="fa-solid fa-user"></i>
                </div>
                <div class="form-group">
                    <input type="password" id="pwd" placeholder="Password" name="password" required> 
                    <i class="fa-solid fa-lock"></i>
                </div>
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
    </script>
</body>
</html>