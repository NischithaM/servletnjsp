<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN DEMO</title>
</head>
<body>
	<h3>second jsp</h3>
	<%
		
		String msg=(String)session.getAttribute("MESSAGE");
		if(msg != null){
	%>
<h1><%= msg  %></h1>
	<%
		}
	%>
	
	<h1> LOGIN SUCCESS</h1>
	<a href="LoginNextServlet"> second servlet</a>
</body>
</html>