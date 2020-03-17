
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<hr>
	<h2>${heading}</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>email</th>
			<th>Mobile No</th>
			<th>Gst No</th>
			<th>Pan card No</th>
			<th>Gst doc</th>
			<th>Pan Card</th>
			<th>Action</th>
		</tr>
	
	<c:forEach var="transporter" items="${transporterList}">
		<tr>
			<td>${transporter.firstName}</td>
			<td>${transporter.email}</td>
			<td>${transporter.mobileNo}</td>
			<td>${transporter.gstNo}</td>
			<td>${transporter.panCardNo}</td>
			<td>docs</td>
			<td>docs</td>
			<td><a href="viewTransporterDetails?transporterId=${transporter.transporterId}">View</a>
			<a href="acceptRequest?transporterId=${transporter.transporterId}">Accept</a><a href="declineRequest?transporterId=${transporter.transporterId}"></a>Decline</td>
		</tr>
	</c:forEach>
	</table>
	<hr>
	
	<h2>${headingv}</h2>
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
	
	<c:forEach var="vehicle" items="${vehicleList}">
		<tr>
			<td>${vehicle.registrationNo}</td>
			<td>${vehicle.chasisNo}</td>
			<td>${vehicle.ownerName}</td>
			<td>${vehicle.model}</td>
			<td>${vehicle.vehicleType}</td>
			<td>${vehicle.insuranceProvider}</td>
			<td>${vehicle.insuranceValidity}</td>
			<td>${vehicle.fitnessValidity}</td>
			<td><a href="viewVehicleDetails?vid=${vehicle.registrationNo}">View</a>
			<a href="approveVehicle?vid=${vehicle.registrationNo}">Approved</a><a href="declineVehicleRequest?vid=${vehicle.registrationNo}">Decline</a></td>
		</tr>
	</c:forEach>
	</table>
	</body>
</html>


