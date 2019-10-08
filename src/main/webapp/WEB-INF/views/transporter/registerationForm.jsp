<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<body>
<a href="index">Home</a>
<p>${error}</p>
<p>${result}</p>
<h2>Register Here</h2>
<hr>
<form:form action="saveTransporter" modelAttribute="transporter" enctype="multipart/form-data">
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
<form:label path="noOfVehicles">noOfVehicles</form:label><br/>
<form:input path="noOfVehicles"  /><br/><br/>
<form:errors path="noOfVehicles"></form:errors>
<form:label path="panCardNo">PANCardNo</form:label><br/>
<form:input path="panCardNo"  /><br/><br/>
<form:errors path="panCardNo"></form:errors>
<form:label path="gstNo">GSTINNo</form:label><br/>
<form:input path="gstNo"  /><br/><br/>
<form:errors path="gstNo"></form:errors>
<input type="file" name="panCardfile"><br/><br/>
<input type="file" name="gstPaperfile"><br/><br/>

<input type="submit" value="register"><br/><br/>
<p>Already a User <a href="login">Login here</a></p>
</form:form>
</body>
</html>
