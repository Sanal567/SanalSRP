<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
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

	<div class="container">
	
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<td>Edit Address</td>
					</tr>
				</thead>
				<form:form action="${contextPath}/address/updateAddress"
					modelAttribute="address" method="POST">
					<tbody>
						<tr>
							<td><label for="doorOrHouseNo">Door/House No : </label></td>
							<td><form:input path="doorOrHouseNo" /></td>
							<td><form:errors path="doorOrHouseNo" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label for="streetOne">Street/Village <sup
									style="color: red;">*</sup>:
							</label></td>
							<td><form:input path="streetOne" /></td>
							<td><form:errors path="streetOne" cssClass="error" /></td></tr>
						<tr>	<td><label for="streetTwo">Area/Panchayat : </label> </td><td><form:input
									path="streetTwo" /> </td><td><form:errors path="streetTwo"
									cssClass="error" /> </td></tr>
									<tr><td> <label for="landmark">Landmark
									: </label></td><td> <form:input path="landmark" /> </td><td><form:errors path="landmark"
									cssClass="error" /> </td></tr>
									<tr><td> <label for="Mandal">Mandal
									: </label></td><td> <form:input path="mandal" /></td>
									<td> <form:errors path="mandal"
									cssClass="error" /> </td></tr>
									<tr><td> <label for="district">District
									: </label></td><td> <form:input path="district" /></td><td> <form:errors path="district"
									cssClass="error" /> </td> </tr>
									<tr><td> <label for="pinCode">PIN
									Code : </label></td><td> <form:input path="pinCode" /></td><td> <form:errors
									path="pinCode" cssClass="error" /> </td></tr>
									<tr><td> <label
								for="additionalInfo"> Additional Info : </label></td>
								<td> <form:input
									path="additionalInfo" /></td><td> <form:errors path="additionalInfo"
									cssClass="error"/></td></tr>
								<tr><td>	 <input type="submit"
								value="Save" /></td></tr></tbody>
				</form:form></table>
		</div>
	</div>
</body>
</html>