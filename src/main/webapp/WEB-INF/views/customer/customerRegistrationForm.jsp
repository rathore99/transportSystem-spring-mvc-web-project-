<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register </title>
</head>
<body>
<a href="index">Home</a>
<h2>Register Here</h2>
<hr>
<form:form action="saveCustomer" modelAttribute="customer" enctype="multipart/form-data">
<form:label path="firstName">First Name</form:label><br/>
<form:input  path="firstName"  /><br/><br/>
<form:errors path="firstName"></form:errors>
<form:label path="lastName">Last Name</form:label><br/>
<form:input path="lastName"  /><br/><br/>
<form:errors path="lastName"></form:errors>
<form:label path="email">email</form:label><br/>
<form:input path="email" type="email"/><br/><br/>
<form:errors path="email"></form:errors>
<form:label path="mobileNo">Mobile No</form:label><br/>
<form:input path="mobileNo"  /><br/><br/>
<form:errors path="mobileNo"></form:errors>
<form:label path="password">password</form:label><br/>
<form:password path="password"  /><br/><br/>
<form:errors path="password"></form:errors>
<form:label path="address">address</form:label><br/>
<form:input path="address"  /><br/><br/>
<form:errors path="address"></form:errors>
<input type="file" name="profileImgs"><br/><br/>

<input type="submit" value="register"><br/><br/>
<p>Already a User <a href="login">Login here</a></p>
</form:form>
</body>
</html>
