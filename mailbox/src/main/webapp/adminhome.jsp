<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELearning - Admin Home</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<%
String username =(String) session.getAttribute("adminusername");
if(username==null)
{
	response.sendRedirect("/admin/");
}
%>
<div class="header1">
<h1 style="text-align: center"> Welcome<span style="color: yellow;"> <%=username.toUpperCase() %></span></h1> 

<ul>

<li ><a href="/admin/viewUsers">view users</a></li>
<li ><a href="/admin/acceptuserregisteration">accept user registeration</a></li>
<li ><a href="/admin/deleteuseracount">delete user account</a></li>
<li ><a href="/admin/searchbyusername">search by username</a></li>
<li><a href="/admin/logout">logout</a></li>
</ul>

</div>
</body>
</html>