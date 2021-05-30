<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Registration form</title>
<style>
title {
text-align: center;}
form{
line-height:50px;
margin:0 auto;
width:250px;
}
address{
display:block;
font-style:italic;
}
h2 {text-align: center;}
h3 {text-align: center;}
input {
text-align:center;
}

</style>
</head>
<body text = "blue" bgcolor = "aqua">
<h2>Registration Form</h2>

<h3>Enter your details</h3>
<div>
<form action='/auth' method='POST'>
<label for='Username'>Username:</label><br>
<input type='text' name="username" required>
<br>
<label for='password'>Password:</label><br>
<input type='password' name="password"required>
<br>
<label for='name'>Name:</label><br>
<input type='text' name="name" required >
<br>
<label for ="phone">Mobile no.:</label><br>
<input type ="tel" id="phone" name="phone" pattern ="[0-9]{3}[0-9]{3}[0-9]{4}">
<br>
<label for="birthday">Birthday:</label><br>
<input type="date" id="birthday" name ="birthday">
<br>

<address> 
<label for='address'>Full address:</label><br>
<input type='text' name ="address" height = 50>
</address>
<input type='submit' value='Submit'>
</form>

</div>
</body>
</html>