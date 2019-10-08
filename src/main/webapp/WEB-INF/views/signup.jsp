<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<h2>Signup Here</h2>
	<form:errors path="user1.*"/>
	<form action="saveuser" method="post" enctype="multipart/form-data">
		<pre>
UserName          		<input type="text" name="userName">
First Name 				<input type="text" name="firstName">
Last Name   			<input type="text" name="lastName">
email       			<input type="text" name="email">
Mobile No.  			<input type="text" name="mobileNo">
Company Name    		<input type="text" name="companyName">    
Password                <input type="text" name="password">
Profile Pic				<input type="file" name="userImg">
            			<input type="submit" name="submit">
</pre>
	</form>
</body>
</html>