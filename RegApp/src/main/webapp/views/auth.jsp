<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter OTP</title>
</head>
<body>
<h3>Enter OTP sent to your mobile</h3>
<form action='/save' method='POST'>
<label for='otp'>OTP:</label><br>
<input type='text' name="otp" required>
<br>
<input type="hidden" id="name" name="name" value=${name } >
<input type="hidden" id="password" name="password" value=${password } >
<input type="hidden" id="username" name="username" value=${username } >
<input type="hidden" id="phone" name="phone" value=${phone} >
<input type="hidden" id="birthday" name="birthday" value=${birthday } >
<input type="hidden" id="address" name="address" value=${address } >
<input type="hidden" id="session_id" name="session_id" value=${session_id } >

<input type='submit' value='Verify'>
</form>
</body>
</html>