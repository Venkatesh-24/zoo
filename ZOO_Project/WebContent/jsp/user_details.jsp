<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.ArrayList, pojo.VisitDetails, java.sql.Date"
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
	 
	 <%
	 	ArrayList<VisitDetails> detailList = (ArrayList) request.getAttribute("detailList");
	 	response.setContentType("text/html");  
     	out.println("<html><body><h3>Visit Details</h3><br>"); 

     	if(detailList.isEmpty()) {
     		out.println("<h2>No Visit details to display");
     	}
     	else {
     		out.println("<table border=1 width=80% height=80% >");  
         	out.println("<tr><th>Visit Count\t</th><th>Date\t</th><th>Animal Name\t</th><th>Amount\t</th><tr>");
	     	for(VisitDetails detail : detailList) {
		 		int visitId = detail.getVisitId();
	            String animalName = detail.getAnimalName();  
	            int amount = detail.getAmount();   
	            Date date = detail.getVisitTime();
	            out.println("<tr><td>" + visitId + "\t</td><td>" + date + "\t</td><td>" + animalName + "\t</td><td>" + amount + "\t</td></tr>"); 
		 	}
	     	out.println("</table>");  
     	}
     	out.println("</html></body>");  
	 %>
		
		<div class = "container">
			<form action = "./details" method="get">
				<div class = "detail">
						<br><button class = "submit">Next</button>
				</div>
				<input type = "hidden" id = "userId" name = "userId" value = "">
				<input type = "hidden" id = "from" name = "from" value = "">
				<input type = "hidden" id = "limit" name = "limit" value = "">
			</form>
		</div>	
		
	<script src ="./js/user_details.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
</body>
</html>