<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>    </style>
<title>LOGIN PAGE</title>
</head>
<body>
<form action='/login' method='POST'>
<label for='Username'>Username:</label><br>
<input type='text' name="username" required>
<br>
<label for='password'>Password:</label><br>
<input type='password' name="password"required>
<br>
<input type='submit' value='login'>

</form>
</body>
</html>