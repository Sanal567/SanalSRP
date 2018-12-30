<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Student</title>
<style>
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
</head>
<body>
	Search by Student Name
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>

	<form:form method="post" action="/SanalSRP/student/searchStudent"
		modelAttribute="student">
		<label for="FirstName">First Name : </label>
		<form:input path="FirstName" placeholder="First Name" />
		<label for="LastName">Last Name : </label>
		<form:input path="LastName" placeholder="Last Name" />
		<input type="submit" value="Search" />
	</form:form>
</body>
</html>