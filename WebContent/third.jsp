<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SESSION HANDLING DEMO</title>
</head>
<body>

	<h3> third page</h3>
		<%
			//String name=(String)request.getAttribute("USER_NAME");
			String name=(String)session.getAttribute("USER_NAME");
		%>
	<h4><%= name %></h4>
	
	<a href="LogoutServlet">LOGOUT</a>
</body>
</html>