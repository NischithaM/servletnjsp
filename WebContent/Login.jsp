<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="LoginServlet" method="post">
	<label>USER NAME</label>
		 <input type="text" name="username" />
		 </br> 
	 <label>PASSWORD</label> 
		 <input type="password" name="password" />
		 </br> 
	<input type="hidden" name="hdnrole"/>
	 <input type="submit"  name="btnsubmit" value="LOGIN"/>
	
	</form>
	
	<%
		
		String msg=(String)request.getAttribute("MESSAGE");
		if(msg != null){
	%>
	<h1 style="color: red"><%= msg  %></h1>
	<%
		}
	%>
</body>
</html>