<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Vehicle</title>
</head>
<body>
<a href="transporterHome" >Home</a>
<a href="login">Logout</a>
<h2>register new vehicle</h2>
<hr>
<p>${error}</p>
<p>${result}</p>
<hr>
<form:form action="updatevehiclerecord" modelAttribute="vehicle" method="POST" >
<form:label path="registrationNo">registration Number</form:label><br/>
<input  name="registrationNo" value="${vehicle.registrationNo}" readonly><br/><br/>
<form:errors path="registrationNo"></form:errors>
<form:label path="chasisNo">chasisNo</form:label><br/>
<input name="chasisNo" value="${vehicle.chasisNo}" readonly><br/><br/>
<form:errors path="chasisNo"></form:errors>
<form:label path="ownerName">ownerName</form:label><br/>
<form:input path="ownerName" value="${vehicle.ownerName}" /><br/><br/>
<form:errors path="ownerName"></form:errors>
<form:label path="vehicleType">Vehicle type</form:label><br/>
<form:input path="vehicleType" value="${vehicle.vehicleType}"></form:input>
<form:label path="model">model</form:label><br/>
<form:input path="model" value="${vehicle.model}" /><br/><br/>
<form:errors path="model"></form:errors>
<form:label path="insuranceProvider">insuranceProvider</form:label><br/>
<form:input path="insuranceProvider" value="${vehicle.insuranceProvider} " /><br/><br/>
<form:errors path="insuranceProvider"></form:errors>
<form:label path="insuranceValidity">insuranceValidity</form:label><br/>
<form:input path="insuranceValidity" type="date" value="${vehicle.insuranceValidity} "  /><br/><br/>
<form:errors path="insuranceValidity"></form:errors>
<form:label path="fitnessValidity">fitnessValidity</form:label><br/>
<form:input path="fitnessValidity" type="date" value="${vehicle.fitnessValidity} "  /><br/><br/>
<form:errors path="fitnessValidity"></form:errors>
<input type="submit" value="update"><br/><br/>
</form:form>
</body>
</html>