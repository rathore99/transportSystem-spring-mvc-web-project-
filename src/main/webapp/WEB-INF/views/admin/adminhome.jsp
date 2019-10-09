<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1;}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>

<ul>
  <li><a href="viewalltransporteradmin">view All Transporteradmin</a></li>
  <li><a href="showVehicles">All Vehical</a></li>
 <li><a href="viewallDealadmin">All Deal</a></li>
<!--  <li><a href="removetransporter">remove Transporter</a></li> -->
 <li><a href="approvetransporterrequest">approvetransporterrequest</a></li>
 <li><a href="approveVehicleRequest">approveVehicleRequest</a></li>
 <li><a href="viewAllQueryAndResponse">QueryAndResponse</a></li>
 <li><a href="logout">logout</a></li>
 
</ul>

<hr>
<h2>New Transporter Account Request</h2>
<c:forEach var="vehicle" items="${vehicleList}">
		<p>RegistrationNo: ${vehicle.registrationNo} chasisNo:
			${vehicle.chasisNo}</p>
		<p>ownerName: ${vehicle.ownerName} model:${vehicle.model}
			vehicleType:${vehicle.vehicleType}</p>
		<p>insuranceProvider: ${vehicle.insuranceProvider}
			insuranceValidity:${vehicle.insuranceValidity}</p>
		<p>fitnessValidity: ${vehicle.fitnessValidity}</p>
		<a href="updatevehicle?registrationNo=${vehicle.registrationNo}">approve</a>
		<a href="updatevehicle?registrationNo=${vehicle.registrationNo}">unregister</a>
		<hr>
	</c:forEach>
<hr>
<h2>New vehicle Request</h2>
<c:forEach var="vehicle" items="${vehicleList}">
		<p>RegistrationNo: ${vehicle.registrationNo} chasisNo:
			${vehicle.chasisNo}</p>
		<p>ownerName: ${vehicle.ownerName} model:${vehicle.model}
			vehicleType:${vehicle.vehicleType}</p>
		<p>insuranceProvider: ${vehicle.insuranceProvider}
			insuranceValidity:${vehicle.insuranceValidity}</p>
		<p>fitnessValidity: ${vehicle.fitnessValidity}</p>
		<a href="updatevehicle?registrationNo=${vehicle.registrationNo}">approve</a>
		<a href="updatevehicle?registrationNo=${vehicle.registrationNo}">unregister</a>
		<hr>
	</c:forEach>
</body>
</html>





<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Transportation</h2>
All Transporter  : <a href="viewalltransporteradmin">All Transporter  </a><br>

All Vehicle  : <a href="viewallvehicaladmin">All Vehicle    </a><br>

All Deal  : <a href="viewallDealadmin">All Deal  </a><br>

<!-- Delete Transporter  : <a href="removetransporter">Update Vehicle</a><br> -->
Approve Transporter Request  : <a href="approvetransporterrequest">Approve_Transporter_Request  </a><br>

Approve Vehicle Request  : <a href="approveVehicleRequest">Approve_Vehicle_Request  </a><br>

Remove Deal  : <a href="removeDealByAdmin">Remove Deal  </a><br>


QueryDetails  : <a href="viewAllQueryAndResponse">QueryCustomerTransporterResponse</a><br>

</body>
</html --%>