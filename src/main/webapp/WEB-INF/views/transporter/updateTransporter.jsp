<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
<form:form action="updateTransporter" method="POST" modelAttribute="transporter">
<form:label path="firstName">First Name</form:label><br/>
<form:input  path="firstName" value="${transporter.firstName}" /><br/><br/>
<form:errors path="firstName"></form:errors>
<form:label path="lastName">Last Name</form:label><br/>
<form:input path="lastName" value="${transporter.lastName}"  /><br/><br/>
<form:errors path="lastName"></form:errors>
<form:label path="email">email</form:label><br/>
<form:input path="email" type="email"/><br/><br/>
<form:errors path="email" value="${transporter.email}"></form:errors>
<form:label path="mobileNo">Mobile No</form:label><br/>
<form:input path="mobileNo" value="${transporter.mobileNo}" /><br/><br/>
<form:errors path="mobileNo"></form:errors>
<form:label path="address">address</form:label><br/>
<form:input path="address" value="${transporter.address}" /><br/><br/>
<form:errors path="address"></form:errors>
<form:label path="noOfVehicles">noOfVehicles</form:label><br/>
<form:input path="noOfVehicles" value="${transporter.noOfVehicles}" /><br/><br/>
<form:errors path="noOfVehicles"></form:errors>
<form:label path="panCardNo">PANCardNo</form:label><br/>
<input name="panCardNo" value="${transporter.panCardNo}"  readonly><br/><br/>
<form:errors path="panCardNo"></form:errors>
<form:label path="gstNo">GSTINNo</form:label><br/>
<form:input path="gstNo" value="${transporter.gstNo}" /><br/><br/>
<form:errors path="gstNo"></form:errors>
<input type="submit" value="update">

</form:form>


</body>
</html>