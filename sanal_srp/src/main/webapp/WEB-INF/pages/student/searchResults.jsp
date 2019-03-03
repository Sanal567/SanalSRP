<!DOCTYPE html>
<html>
<head>
<%@include file="../bootstrap_files.jsp"%>
<title>Search results</title>
</head>

<body>
	<div id="container" align="center">
		<h2>Search Results</h2>

		<c:choose>

			<c:when test="${studentList.size()>0}">
				<c:set var="results" value="true" />

				<c:forEach var="student" items="${studentList}">
					<a
						href="${contextPath}/student/viewStudentDetails?studentId=${student.studentId}">
						${student.firstName}</a> : ${student.lastName} <br />
				</c:forEach>
			</c:when>

			<c:otherwise>
				<c:set var="results" value="false" />
				<div>
					No student found for
					<c:if test="${firstName != '' and firstName != null}">First Name : ${firstName}</c:if>
					<c:if test="${lastName ne '' and lastName ne null}">Last Name : ${lastName}</c:if>
				</div>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${results eq 'false' }">
				<%@include file="searchStudent.jsp"%>
			</c:when>
		</c:choose>
	</div>
</body>
</html>