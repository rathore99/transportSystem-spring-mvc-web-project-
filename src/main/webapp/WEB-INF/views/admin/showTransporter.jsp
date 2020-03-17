<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<p>Name: ${transporter.firstName} ${transporter.lastName}</p>
<p>E-mail: ${transporter.email}</p>
<p>Mobile No: ${transporter.mobileNo}</p>
<p>Gst No: ${transporter.gstNo}</p>
<p>Pan card No: ${transporter.panCardNo}</p>
<img alt="" src="">	
<a href="acceptRequest?transporterId=${transporter.transporterId}">Accept</a>
<a href="declineRequest?transporterId=${transporter.transporterId}">decline</a>
</body>
</html>