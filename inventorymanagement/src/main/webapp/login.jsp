<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="inventory.css"></link>
</head>
<body>
	
	<% 
	
	if(session!=null&&session.getAttribute("uid")!=null){
		
		response.sendRedirect("home.jsp");
		}
	 %>
	<div class="bg-img">
	
        <form action = "LoginServlet" method = "POST" class="container">
          <h1>Login</h1>
      
          <label for="email"><b>Email</b></label>
          <input type="text" placeholder="Enter Email" name="email" required>
      
          <label for="psw"><b>Password</b></label>
          <input type="password" placeholder="Enter Password" name="psw" required>
      
          <input type="submit" class="btn" value="Login"/>
        </div>
      </div>
</body>
</html>