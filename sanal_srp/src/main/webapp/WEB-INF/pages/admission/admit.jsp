<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<title>Admit student - Joining form - Page 1</title>
<%@include file="../bootstrap_files.jsp" %>
</head>

<div class="container">

<form:form method="POST" modelAttribute="student"
	action="${contextPath}/admission/admit">
	<%-- name="" id="" class="" onsubmit="" --%>
<fieldset> <legend>Admissions</legend>
<div class="row">
<div class="col">
	<label for="class">Admission to Class</label>
	<%-- <form:select id="class" path="">
		<form:option value="">Choose...</form:option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<c:forEach var="eduClass" items="${allClasses}">
			<form:option value="${eduClass.classId}">${eduClass.className}</form:option>
			<form:options items="${countryList}" itemValue="code" itemLabel="name"/>
			

<form:hidden path="house"/>

			
		</c:forEach>
	</form:select>
	 --%>
</div>
</div>
	
	<br />
	First Name :<form:input path="firstName" pattern="[A-Za-z ]{3,25}" size="10" 
		placeholder="First Name" spellcheck="false" />
	<br />	Last Name: <form:input path="lastName" pattern="[A-Za-z ]{3,25}" size="10" 
		spellcheck="false" placeholder="Last Name" />

	<br />	Gender <form:select path="studentGender">
	<form:option value="--Select One---" selected="selected" />
	<form:option value="Male">Male</form:option>
	<form:option value="Female">Female</form:option>
        </form:select>
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
	</fieldset>
</form:form>
<br />
which is better for gender selection...radio button, checkbox or select
option
<br />
Is admission no is automatically generates?
<br />
Option to enter already joined students
</div>
</html>