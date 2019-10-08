<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Deal</title>
</head>
<body>
<form:form action="createDeal" method="POST" modelAttribute="deal">
		<form:select path="registrationNo" name="registrationNo">
			<c:forEach var="vehicle" items="${vehicleList}">
				<form:option value="${vehicle.vehicleId}" label="${vehicle.registrationNo}"></form:option>
			</c:forEach>
		<form:label path="source">Source city</form:label>	
		<form:input path="source"/>
		<form:errors path="source"></form:errors>
		<form:label path="destination">destination city</form:label>	
		<form:input path="destination"/>
		<form:errors path="destination"></form:errors>	
		<form:label path="distance">distance</form:label>	
		<form:input path="distance"/>
		<form:errors path="distance"></form:errors>	
		<form:label path="price">price</form:label>	
		<form:input path="price"/>
		<form:errors path="price"></form:errors>	
		<form:label path="availableDate">availableDate</form:label>	
		<form:input path="availableDate" type="date"/>
		<form:errors path="availableDate"></form:errors>
			<input type="submit" value="Post Deal">
		</form:select>

	</form:form>
</body>
</html>