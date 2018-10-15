<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form>
	Admissions <label for="class">Admission to Class</label> 
	<select	id="class">
		<option selected>Choose...</option>
		<c:forEach var="eduClass" items="${allClasses}">
			<option value="${eduClass.classId}">${eduClass.className}</option>
		</c:forEach>
	</select> <font size='3'><b>9966691989</b></font> First Name :<input type="text"
		name="first_name" size="10" maxlength="20" placeholder="First Name"
		spellcheck="false"> Last Name: <input type="text"
		name="last_name" size="10" maxlength="20" spellcheck="false">

	Gender <input type="radio" name="gender" value="1" /> Male Date of
	birth : <select name="date">

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


	</select> <input type="date" />

</form>
<br />
which is better for gender selection...radio button, checkbox or select
option
<br />
Is admission no is automatically generates?
<br />
Option to enter already joined students
