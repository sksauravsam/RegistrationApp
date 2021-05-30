<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Output</title>
</head>
<body>
<div>
<h2>Registration form</h2>
<span><%= request.getParameter("Username") %></span><br>
<span><%= request.getParameter("name") %></span><br>
<span><%= request.getParameter("phone") %></span><br>
<span><%= request.getParameter("birthday") %></span><br>
<span><%= request.getParameter("address") %></span><br>
</div>
</body>
</html>