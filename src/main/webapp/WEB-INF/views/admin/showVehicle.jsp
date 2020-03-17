<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle</title>
</head>
<body>
<table>
		<tr>
			<th>RegistrationNo </th>
			<th>chasisNo</th>
			<th>ownerName</th>
			<th>model</th>
			<th>vehicleType</th>
			<th>insuranceProvider</th>
			<th>insuranceValidity</th>
			<th>fitnessValidity</th>
			<th>Action</th>
		</tr>
		<tr>
			<td>${vehicle.registrationNo}</td>
			<td>${vehicle.chasisNo}</td>
			<td>${vehicle.ownerName}</td>
			<td>${vehicle.model}</td>
			<td>${vehicle.vehicleType}</td>
			<td>${vehicle.insuranceProvider}</td>
			<td>${vehicle.insuranceValidity}</td>
			<td>${vehicle.fitnessValidity}</td>
			<td>
			<a href="approveVehicle?vid=${vehicle.registrationNo}">Approved</a><a href="declineVehicleRequest?vid=${vehicle.registrationNo}">Decline</a></td>
		</tr>
	</table>

</body>
</html>