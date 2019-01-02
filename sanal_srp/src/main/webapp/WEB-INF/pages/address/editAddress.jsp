<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Address</title>
</head>
<body>
	Edit Address
	<br />
	<form:form action="${contextPath}/address/saveAddress"
		modelAttribute="address" method="POST">
		<label for="doorOrHouseNo">Door/House No : </label>
		<form:input path="doorOrHouseNo" />
		<br />
		<label for="streetOne">Street/Village : </label>
		<form:input path="streetOne" required />
		<br />
		<label for="streetTwo">Area/Panchayat : </label>
		<form:input path="streetTwo" />
		<br />
		<label for="landmark">Landmark : </label>
		<form:input path="landmark" required />
		<br />
		<label for="Mandal">Mandal : </label>
		<form:input path="mandal" required/>
		<br />
		<label for="district">District : </label>
		<form:input path="district" required/>
		<br />
		<label for="pinCode">PIN Code : </label>
		<form:input path="pinCode" required/>
		<br />
		<label for="additionalInfo"> Additional Info : </label>
		<form:input path="additionalInfo" />
		<input type="submit" value="Save Address" />
	</form:form>

</body>
</html>