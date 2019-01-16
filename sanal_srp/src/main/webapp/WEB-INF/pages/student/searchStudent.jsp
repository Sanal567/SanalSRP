<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../bootstrap_files.jsp"%>

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
		<form:form class="form-inline" method="post"
			action="${contextPath}/student/searchStudent"
			modelAttribute="student">
			<fieldset>
				<legend>Search by Student Name</legend>
				<c:if test="${not empty error}">
					<div class="alert alert-danger alert-dismissible fade show">
						<button type="button" class="close" data-dismiss="alert">&times;</button>${error}</div>
				</c:if>

				<div class="input-group mb-3">
					<label for="FirstName" class="mr-sm-2">First Name : </label>
					<form:input path="FirstName" class="form-control mr-sm-2"
						placeholder="First Name" />
					<label for="LastName" class="mr-sm-2">Last Name : </label>
					<form:input path="LastName" class="form-control mr-sm-2"
						placeholder="Last Name" />
					<div class="input-group-append">
						<button class="btn btn-success" type="submit">Search</button>
					</div>
					<!-- <input type="submit" value="Search" /> -->
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>