<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<br /> First Name : Last Name
	<br />
	<c:choose>
		<c:when test="${studentList.size()>0}">
			<c:forEach var="student" items="${studentList}">
				<a
					href="${contextPath}/student/viewStudentDetails?studentId=${student.studentId}">
					${student.firstName}</a> : ${student.lastName}
			</c:forEach>
		</c:when>
		<c:otherwise>No student found for
				<c:if test="${firstName != '' and firstName != null}">First Name : ${firstName}</c:if>
			<c:if test="${lastName ne '' and lastName ne null}">Last Name : ${lastName}</c:if>
		</c:otherwise>
	</c:choose>

</body>
</html>