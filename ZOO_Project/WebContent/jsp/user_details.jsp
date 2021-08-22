<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
<link rel="stylesheet" type="text/css" href="../css/user_details.css">
</head>
<body>
	
	<%
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
		if(session.getAttribute("username") == null)
		{
			response.sendRedirect("login.jsp");
		}
	
	 %>
	 
	<h3>Visit Details</h3>
		
		<div class = "container">
			<form action = "../details" method = "post">
					<input type="hidden" autocomplete = "off" name = "customerId" class = "customerId" value = "">
					<div class = "details">
						<button class = "submit">Back</button>
					</div>	
			</form>

			<form action = "../logout" method="post">
				<div class = "logout">
						<button class = "submit">Logout</button>
				</div>
			</form>
		</div>	
		
		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src = "../js/user_details.js" type="text/javascript"></script>
</body>
</html>