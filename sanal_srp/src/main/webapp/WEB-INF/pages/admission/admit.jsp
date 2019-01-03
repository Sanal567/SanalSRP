<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form:form method="POST" modelAttribute="student"
	action="${contextPath}/admission/admit">
	<%-- name="" id="" class="" onsubmit="" --%>
	Admissions <br />
	<label for="class">Admission to Class</label>
	<%-- <form:select id="class" path="">
		<form:option value="">Choose...</form:option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<c:forEach var="eduClass" items="${allClasses}">
			<form:option value="${eduClass.classId}">${eduClass.className}</form:option>
		</c:forEach>
	</form:select>
	 --%>
	<font size='3'><b>9966691989</b></font>
	<br />
	First Name :<form:input path="firstName" size="10" maxlength="20"
		placeholder="First Name" spellcheck="false" />
	<br />	Last Name: <form:input path="lastName" size="10" maxlength="20"
		spellcheck="false" placeholder="Last Name" />

	<br />	Gender Male: <form:radiobutton path="studentGender" value="M" />
        Female: <form:radiobutton path="studentGender" value="F" />
	<br /> Date of	birth : <%-- <form:select name="date">

		<option value="choose">Choose one</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
		<option value="10">10</option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>
		<option value=""></option>


	</form:select>
	<input type="date" />
 --%>
	<input type="submit" value="Save" />
</form:form>
<br />
which is better for gender selection...radio button, checkbox or select
option
<br />
Is admission no is automatically generates?
<br />
Option to enter already joined students
