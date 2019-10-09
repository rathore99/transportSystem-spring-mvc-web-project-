<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>List-of-Transporter</h3>
<hr>
	<table border="2">
	
	<tr>
		<th>name</th><th>email</th><th>mobile</th><th>photo</th><th>busy</th>
	<tr>
	<c:forEach var="transporterlist" items="${transporter}">
		<tr>
			<td>${transporterlist.name}</td>
			<td>${transporterlist.email}</td>
			<td>${transporterlist.mobile}</td>
			<td><a href="view?code=${transporterlist.photo}">photo</a></td>
			<td>${transporterlist.identity}</td>
			<td>${transporterlist.trating}</td>
			<td><a href="removetransporter?email=${transporterlist.email}">[delete]</a></td>
		
			</tr>
	</c:forEach>
	</table>


<hr>
<a href="adminhome">[Dashboard]</a>
</body>
</html>