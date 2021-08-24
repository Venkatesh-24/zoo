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
	<div class = "container">
		<a href="visit.jsp" class = "visit">Visit</a><br>
		<form action = "../details" method="get">
				<div class = "detail">
						<button class = "submit">Details</button>
				</div>
				<input type = "hidden" id = "userId" name = "userId" value = "">
				<input type = "hidden" id = "from" name = "from" value = "">
				<input type = "hidden" id = "limit" name = "limit" value = "">
		</form><br>
		<form action = "../logout" method = "post">
				<button class = "button">Logout</button>
		</form><br>
	</div>
		<h2>Hello <span class = "name">%Name%</span></h2>
		<h3> We are happy that you are here.We have all sorts of animals that you like.Hope that you enjoy the day
		   by sparing time with our animals</h3>
	</div>
	
	<script src ="../js/user_home.js" type="text/javascript"></script>
</body>
</html>