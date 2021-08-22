<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
<link rel="stylesheet" type="text/css" href="../css/user_home.css">
</head>
<body>

	<%
	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
		if(session.getAttribute("username") == null)
		{
			response.sendRedirect("login.jsp");
		}
	
	 %>
	 
	<div class = "top">
		<h1>Welcome To Falcon</h1>
	</div>

	<div class = "middle">		
		<a href="visit.jsp" class = "visit">Visit</a>
		<a href = "user_details.jsp" class = "details">Details</a> 
		<div class = "logout">
			<form action = "../logout" method = "post">
				<button class = "button">Logout</button>
			</form>
		</div>
		<h2>Hello <span class = "name">%Name%</span></h2>
		<h3> We are happy that you are here.We have all sorts of animals that you like.Hope that you enjoy the day
		   by sparing time with our animals</h3>
	</div>
	
	<script src = "../js/user_home.js" type="text/javascript"></script>
</body>
</html>