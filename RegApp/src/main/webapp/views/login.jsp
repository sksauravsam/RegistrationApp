<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style> form
 {
text-align:center;

}
title{text-align:center;}
h2{text="red"; bgcolor="yellow"; text-align:center;}

   </style>
<title>LOGIN PAGE</title>
<h2> LOGIN PAGE</h2>
</head>
<body text="blue" bgcolor="aqua"=>
<div id="container">
<form action='/login' method='POST'>
<label for="Username">Username:</label><br>
<input type='text' id="username" name="username" required>
<br>
<label for='password'>Password:</label><br>
<input type='password' name="password"required>
<div id="lower">
<br>
<input type='submit' value='login'>
</div><!-- /lower-->
</form>
</div>
</body>
</html>