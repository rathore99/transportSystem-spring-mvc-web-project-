<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login here</title>
</head>
<body>
<a href="index">Home</a>
<h2>Login here</h2>
<hr>
<p>${error}</p> 
<form action="verifytransporter" method="POST">
<label>Email</label><br/>
<input type="email" name="email"><br/><br/>
<label>Password</label><br/> 
<input type="password" name="password"><br/><br/>
<input type="submit" value="Login"> <nbsp/><nbsp/><nbsp/> <a href="forgotPassword">Forgot Password</a>
<p>New user <a href="register">register here</a></p>

</form>
</body>
</html>