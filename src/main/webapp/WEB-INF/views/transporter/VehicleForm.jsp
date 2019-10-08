<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register vehicle</title>
</head>
<body>
<a href="transporterHome" >Home</a>
<a href="login">Logout</a>
<h2>register new vehicle</h2>
<hr>
<p>${error}</p>
<p>${result}</p>
<hr>
<form:form action="saveVehicle" modelAttribute="vehicle" enctype="multipart/form-data">
<form:label path="registrationNo">registration Number</form:label><br/>
<form:input  path="registrationNo"  /><br/><br/>
<form:errors path="registrationNo"></form:errors>
<form:label path="chasisNo">chasisNo</form:label><br/>
<form:input path="chasisNo"  /><br/><br/>
<form:errors path="chasisNo"></form:errors>
<form:label path="ownerName">ownerName</form:label><br/>
<form:input path="ownerName" /><br/><br/>
<form:errors path="ownerName"></form:errors>
<form:label path="vehicleType">Vehicle type</form:label><br/>
<form:input path="vehicleType"></form:input>
<form:label path="model">model</form:label><br/>
<form:input path="model"  /><br/><br/>
<form:errors path="model"></form:errors>
<form:label path="insuranceProvider">insuranceProvider</form:label><br/>
<form:input path="insuranceProvider"  /><br/><br/>
<form:errors path="insuranceProvider"></form:errors>
<form:label path="insuranceValidity">insuranceValidity</form:label><br/>
<form:input path="insuranceValidity" type="date" /><br/><br/>
<form:errors path="insuranceValidity"></form:errors>
<form:label path="fitnessValidity">fitnessValidity</form:label><br/>
<form:input path="fitnessValidity" type="date" /><br/><br/>
<form:errors path="fitnessValidity"></form:errors>

<input type="file" name="insurancePapers"><br/><br/>
<input type="file" name="fitnesscerts"><br/><br/>

<input type="submit" value="register"><br/><br/>
</form:form>
</body>
</html>