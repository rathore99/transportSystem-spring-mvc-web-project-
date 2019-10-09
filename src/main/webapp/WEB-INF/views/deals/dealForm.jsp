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
<h4>${msg}</h4>
<form:form action="createDeal" method="POST" modelAttribute="deal">
        <label>Vehicle </label><br>
		<form:select name="registrationNo" path="">
			<c:forEach var="registrationNo1" items="${vehicleList}">
				<form:option value="${registrationNo1}" label="${registrationNo1}"></form:option>
			</c:forEach>
			</form:select><br><br>
		<form:label path="source">Source city</form:label>	<br>
		<form:input path="source"/><br/><br/>
		<form:errors path="source"></form:errors>
		<form:label path="destination">destination city</form:label><br>
		<form:input path="destination"/><br/><br/>
		<form:errors path="destination"></form:errors>	
		<form:label path="distance">distance</form:label><br>	
		<form:input path="distance"/><br/><br/>
		<form:errors path="distance"></form:errors>	
		<form:label path="price">price</form:label>	<br>
		<form:input path="price"/><br/><br/>
		<form:errors path="price"></form:errors>	
		<form:label path="availableDate">availableDate</form:label><br>	
		<form:input path="availableDate" type="date"/><br/><br/>
		<form:errors path="availableDate"></form:errors>
			<input type="submit" value="Post Deal">
		

	</form:form>
</body>
</html>