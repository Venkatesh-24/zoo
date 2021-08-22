<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZOO VISIT</title>
<link rel="stylesheet" type="text/css" href="../css/visit.css">
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
		<div class = "logout">
			<form action = "../logout" method = "post">
				<button class = "button">Logout</button>
			</form>
		</div>
		<h2>Welcome To Falcon</h2>
	</div>
	<div class = "fullmiddle">
		<div class = "middle">
			<form action="../Visit" method="post">
				<p class = "center">Enter Fare</p>
				<input type="number" name="fare" class = "fare" autocomplete = "off">
				<a href="#" class = "pay">PAY</a>
				<div class = "animalsPresent">
					<h3>Select Animals</h3>
					<input type="checkbox" autocomplete = "off" name="animal_1_2500" class = "animal" id = "animal_1_2500">Lion<span> - $2500</span><br>
					<input type="checkbox" autocomplete = "off" name="animal_2_2350" class = "animal" id = "animal_2_2350" >Tiger<span> - $2350</span><br>
					<input type="checkbox" autocomplete = "off" name="animal_3_1700" class = "animal" id = "animal_3_1700">Elephant<span> - $1700</span><br>
					<input type="checkbox" autocomplete = "off" name="animal_4_2200" class = "animal" id = "animal_4_2200">Cheetah<span> - $2200</span><br>
					<input type="checkbox" autocomplete = "off" name="animal_5_2100" class = "animal" id = "animal_5_2100">Giraffe<span> - $2100</span><br>
					<input type="checkbox" autocomplete = "off" name="animal_6_2300" class = "animal" id = "animal_6_2300">Crocodile<span> - $2300</span><br>
					<input type="checkbox" autocomplete = "off" name="animal_7_2250" class = "animal" id = "animal_7_2250">Snake<span> - $2250</span><br>
					<input type="hidden" autocomplete = "off" name = "userId" class = "userId" value = "">
				</div>	
				<button class = "visit"	>Visit Now</button>
			</form>	
	</div>

	<script src = "../js/visit.js" type="text/javascript"></script>
</body>
</html>