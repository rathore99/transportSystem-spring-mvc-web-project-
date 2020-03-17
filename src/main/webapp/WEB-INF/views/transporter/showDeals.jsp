<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deals</title>
</head>
<body>
<a href="homeTransporter">Home</a>
<a href="login">Logout</a>
<h2>List of all deals</h2>

<hr>
<c:forEach var="deal" items="${dealList}">
				<p>RegistrationNo: ${deal.source} chasisNo: ${deal.destination} </p>
				<p>ownerName: ${deal.price}  model:${deal.distance} dealType:${deal.availableDate}</p>
				<p> ${deal.vehicle.registrationNo}</p>
				<p> <a href="updatedeal?registrationNo=">Update</a> </p>
				<hr> 
			</c:forEach>

</body>

</html>