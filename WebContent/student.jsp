<%@page import="com.cruds.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dept Page</title>
</head>
<body>
<h2> STUDENT INFO </h2>
	<form action="StudentServlet" method="post" >
		<label>ROLL NO :</label>
		<input type="text" name="rollno" /></br>
		<label>NAME :</label>
		<input type="text" name="name" /></br>
		<input type="submit" value="Create"/>
	</form>
	
	<%
		List<Student> slist=(List<Student>) request.getAttribute("STUD_LIST");
		String msg=(String)request.getAttribute("MESSAGE");
		if(msg != null){
	%>
<h1><%= msg  %></h1>
	<%
		}
	%>
	
	
	<table>
		<thead>
			<tr>
				<td>ROLL NO</td>
				<td>NAME</td>
			</tr>
		</thead>
		
		<tbody>
		<%
			if(slist !=null){
				for(Student s: slist){
		%>
		
		<tr>
			<td> <%= s.getRoll_no() %></td>
			<td> <%= s.getName() %></td>
		</tr>
		
		<%
			}
		}
		%>
		</tbody>
	</table>	

</body>
</html>