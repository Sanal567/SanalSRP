<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" scope="page" value="${pageContext.request.contextPath}"/>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address details</title>
</head>
<body>
Address : 
<br/>
	Door/House No : ${address.doorOrHouseNo} <br />
	Street/Village : ${address.streetOne}	<br />
	Area/Panchayat : ${address.streetTwo} <br />
	Landmark : ${address.landmark}<br />
	Mandal : ${address.mandal}<br />
	District : ${address.district}<br />
	PIN Code : ${address.pinCode}<br />
	Additional Info : ${address.additionalInfo}
	
</body>
</html>