<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Search Student</title>
<!-- <style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}
</style>
 -->
</head>
<body>
	<div class="container mt-3">
		<div>Search by Student Name</div>
		<c:if test="${not empty error}">
			<div class="alert alert-danger alert-dismissible fade show">
				<button type="button" class="close" data-dismiss="alert">&times;</button>${error}</div>
		</c:if>
		<form:form class="form-inline" method="post"
			action="${contextPath}/student/searchStudent"
			modelAttribute="student">

			<div class="input-group mb-3">
				<label for="FirstName" class="mr-sm-2">First Name : </label>
				<form:input path="FirstName" class="form-control mr-sm-2"
					placeholder="First Name" />
				<label for="LastName" class="mr-sm-2">Last Name : </label>
				<form:input path="LastName" class="form-control mr-sm-2"
					placeholder="Last Name" />
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">Go</button>
				</div>
				<!-- <input type="submit" value="Search" /> -->
			</div>
		</form:form>
	</div>
</body>
</html>