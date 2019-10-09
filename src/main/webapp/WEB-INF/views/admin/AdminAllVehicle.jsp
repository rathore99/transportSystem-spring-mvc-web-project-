<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>List-of-Vehicle-To -Admin</h3>
<hr>
	<table border="2">
	
	<tr>
		<th>number</th><th>fitnessCertificate</th><th>registrationCard</th><th>insurance</th><th>On Deal</th>
	<tr>
	<c:forEach var="vehiclelist" items="${vehicle}">
		<tr>
			<td>${vehiclelist.number}</td>
			<td><a href="view?code=${vehiclelist.fitnessCertificate}">fitnessCertificate</a></td>
			<td><a href="view?code=${vehiclelist.registrationCard}">registrationCard</a></td>
			<td>${vehiclelist.insurance}</td>
			<td>${vehiclelist.active}</td>
			<td><a href="removevehicle?number=${vehiclelist.number}">[delete]</a></td>
			 </tr>
	</c:forEach>
	</table>
<hr>

<a href="adminhome">[Dashboard]</a>
</body>
</html>