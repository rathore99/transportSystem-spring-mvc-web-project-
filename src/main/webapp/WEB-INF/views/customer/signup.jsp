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
	<form:errors path="user1" />
	<form action="saveuser" method="post" enctype="multipart/form-data">
		<label>UserName</label> <br> 
		<input type="text" name="userName">
		<form:errors path="user1.userName" />
		<br>
		<br><label>First Name</label> <br>   <input type="text" name="firstName">
		<form:errors path="user1.firstName" />
		<br>
		<br>
		<label>Last Name</label> <br> <input type="text" name="lastName">
		<form:errors path="user1.lastName" />
		<br>
		<br> <label>Email</label> <br> <input type="text" name="email">
		<form:errors path="user1.email" />
		<br>
		<br> <label>Mobile No</label> <br><input type="text" name="mobileNo">
		<form:errors path="user1.mobileNo" />
		<br>
		<br> <label>company name</label> <br><input type="text" name="companyName">
		<form:errors path="user1.companyName" />
		<br>
		<br> <label>Password</label> <br> <input type="text" name="password">
		<form:errors path="user1.password" />
		<br>
		<br> <label>Profile pic</label> <input type="file" name="userImg"><br>
		<br> <input type="submit" name="submit"><br>
		<br>

	</form>
</body>
</html>