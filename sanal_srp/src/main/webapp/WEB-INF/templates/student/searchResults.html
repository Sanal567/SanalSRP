<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search results</title>
</head>
<body>
	Search Results
	<br />
	<c:choose>
		<c:when test="${studentList.size()>0}">
			<c:set var="results" value="true" />
			<c:forEach var="student" items="${studentList}">
				<a
					href="${contextPath}/student/viewStudentDetails?studentId=${student.studentId}">
					${student.firstName}</a> : ${student.lastName} <br/>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:set var="results" value="false" />
		No student found for
				<c:if test="${firstName != '' and firstName != null}">First Name : ${firstName}</c:if>
			<c:if test="${lastName ne '' and lastName ne null}">Last Name : ${lastName}</c:if>
		</c:otherwise>
	</c:choose>
	<br />
	<c:choose>
		<c:when test="${results eq 'false' }">
			<br />
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
		</c:when>
	</c:choose>
</body>
</html>