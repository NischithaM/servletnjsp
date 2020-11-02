<%@page import="com.cruds.entity.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dept Page</title>

<script type="text/javascript">

	var seldeptid,seldeptname;
	function setData(deptid,deptname)
	{
		//alert(deptid);
		seldeptid=deptid;
		seldeptname=deptname;
		
	}
	
	function deldept()
	{
		document.deptform.hdnDeptId.value=seldeptid;
		document.deptform.ACTION.value="DELETE";
		document.deptform.submit();
	}
	function editdept()
	{
		document.deptform.deptid.value=seldeptid;
		document.deptform.deptid.readOnly=true;
		document.deptform.deptname.value=seldeptname;
		
		document.deptform.btnsubmit.value="update";
		document.deptform.ACTION.value="UPDATE";
	}
</script>
</head>
<body>
	<h2>DEARTMENT INFO</h2>
	<form name="deptform" action="DepartmentServlet" method="post">
		<label>DEPT NO :</label>
		 <input type="text" name="deptid" />
		 </br> 
		 <label>DEPT NAME :</label> 
		 <input type="text" name="deptname" />
		 </br> 
		 <input type="hidden" name="ACTION" value="CREATE" />
		 <input type="hidden" name="hdnDeptId"/>
		 <input type="submit"  name="btnsubmit" value="CREATE"/>
	</form>

	<%
		List<Department> dlist=(List<Department>) request.getAttribute("DEPT_LIST");
		String msg=(String)request.getAttribute("MESSAGE");
		if(msg != null){
	%>
	<h1><%= msg  %></h1>
	<%
		}
	%>


	<table border="1">
		<thead>
			<tr>
				<td>DEPT ID</td>
				<td>DET NAME</td>
				<td> </td>
			</tr>
		</thead>

		<tbody>
			<%
			if(dlist !=null){
				for(Department d: dlist){
		%>

			<tr>
				<td><%= d.getId() %></td>
				<td><%= d.getName() %></td>
				<td><input type="checkbox" onclick="setData(<%= d.getId() %>,'<%=d.getName()%>');"/></td>
			</tr>

			<%
			}
		}
		%>
		</tbody>
	</table>
	<input type="button" value="delete" onclick="deldept();" />
	<input type="button" value="edit" onclick="editdept();" />
</body>
</html>