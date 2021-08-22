																																																																																																																																					<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZOO-Login</title>
<link rel="stylesheet" type="text/css" href="../css/login.css"></head>
<body>
	<a href="#" class = "signIn">sign in</a>
		<a href="#" class = "signUp">sign up</a>
		<div class = "signIn-form">
			<form action = "../login" method = "post">
				<p>Username:</p>
				<input type="text" class = "tbox" id = "uname" name = "username" placeholder="franklinJosh" required>
				<p>Password:</p>
				<input type = "password" class = "tbox" id = "pass" name = "password" placeholder="abc__123" required>
				<br>
				<button class = "tbox btn" id = "signin">LOGIN</button>
			</form>
		</div>
		<div class = "signUp-form hidden">
			<form action = "../SignUp" method = "post">
				<p>Username:</p>
				<input type="text" class = "tbox" name = "username" id = "uname" placeholder="FranklinJosh" required>
				<p id = "mailtext">Email:</p>
				<input type="email" class = "tbox" id = "mail" name = "emailId" placeholder="abc@gmail.com" required>
				<p id = "regiontext">Country:</p>
				<select class = "tbox" id = "region" name = "country" required>
					<option >India</option>
					<option>USA</option>
					<option>Europe</option>
					<option>Australia</option>
					<option>Antartica</option>
				</select>
				<p>Password:</p>
				<input type = "password" class = "tbox" id = "pass" name = "password" placeholder="abc__123" required>
				<br>
				<button class = "tbox btn" id = "signUp">LOGIN</button>
			</form>
		</div>

		<script src = "../js/login.js" type="text/javascript"></script>
</body>
</html>