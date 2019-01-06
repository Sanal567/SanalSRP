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
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	Edit Address
	<br />
	<form:form action="${contextPath}/address/saveAddress"
		modelAttribute="address" method="POST">
		<label for="doorOrHouseNo">Door/House No : </label>
		<form:input path="doorOrHouseNo" />
		<form:errors path="doorOrHouseNo" cssClass="error"/>
		<br />
		<label for="streetOne">Street/Village : <sup>*</sup></label>
		<form:input path="streetOne" required />
		<form:errors path="streetOne" cssClass="error"/>
		<br />
		<label for="streetTwo">Area/Panchayat : </label>
		<form:input path="streetTwo" />
		<form:errors path="streetTwo" cssClass="error"/>
		<br />
		<label for="landmark">Landmark : </label>
		<form:input path="landmark" required />
		<form:errors path="landmark" cssClass="error"/>
		<br />
		<label for="Mandal">Mandal : </label>
		<form:input path="mandal" required/>
		<form:errors path="mandal" cssClass="error"/>
		<br />
		<label for="district">District : </label>
		<form:input path="district" required/>
		<form:errors path="district" cssClass="error"/>
		<br />
		<label for="pinCode">PIN Code : </label>
		<form:input path="pinCode" required/>
		<form:input path="pinCode" cssClass="error"/>
		<br />
		<label for="additionalInfo"> Additional Info : </label>
		<form:input path="additionalInfo" />
		<form:errors path="additionalInfo" cssClass="error"></form:errors>
		<input type="submit" value="Save" />
	</form:form>

</body>
</html>