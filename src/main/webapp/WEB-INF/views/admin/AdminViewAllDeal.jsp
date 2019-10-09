<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>List-of-Deals</h3>
<hr>
	<table border="2">
	
	<tr>
	<th>TransporterName</th><th>Fare</th>	<th>FROMPLACE</th><th>TOPLACE</th><th>RETURNDATE</th><th>STARTDATE</th><th>VEHICLENUMBER</th>
	<tr>
	<c:forEach var="deallist" items="${deal}">
		<tr>
		<td>${deallist.transporter.name}</td>
		<td>${deallist.fare}</td>
			<td>${deallist.fromplace}</td>
			<td>${deallist.toplace}</td>
			<td>${deallist.startdate}</td>
			<td>${deallist.returndate}</td>
			<td>${deallist.vehicle.number}</td>
			<td><a href="removeDealByAdmin?id=${deallist.id}&&email=${deallist.transporter.email}">[Delete]</a></td>
			</tr>
	</c:forEach>
	</table>


<hr>

<a href="adminhome">[Dashboard]</a>
</body>
</html>