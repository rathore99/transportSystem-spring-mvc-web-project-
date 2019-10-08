<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forgot Password </title>
</head>
<body>
<a href="index">Home</a>
<h2>Reset Password</h2>
<hr>
<form action="resetPassword" method="POST">
<label> Enter your email to reset password</label><br/>
<input type="email" name="email"><br/><br/>
<input type="submit" value="Submit"><br/>
</form>
<a href="login">Login  </a><nbsp/><nbsp/><a href="register">Register</a>
</body>
</html>
