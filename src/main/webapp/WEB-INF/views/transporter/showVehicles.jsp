<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicles</title>
</head>
<body>
<a href="transporterHome" >Home</a>
<a href="login">Logout</a>
<h2>List of all vehicles of a transporter</h2>
<hr>
<c:forEach var="vehicle" items="${vehicleList}">
				<p>RegistrationNo: ${vehicle.registrationNo} chasisNo: ${vehicle.chasisNo} </p>
				<p>ownerName: ${vehicle.ownerName}  model:${vehicle.model} vehicleType:${vehicle.vehicleType}</p>
				<p>insuranceProvider: ${vehicle.insuranceProvider} insuranceValidity:${vehicle.insuranceValidity} </p>
				<p>fitnessValidity: ${vehicle.fitnessValidity} <a href="updatevehicle?registrationNo=${vehicle.registrationNo}">Update</a> </p>
				<hr> 
			</c:forEach>
</body>
</html>