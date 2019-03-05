<!DOCTYPE html>
<html lang="en">
<%@include file="../bootstrap_files.jsp"%>
<%-- <link rel="stylesheet" href="${contextPath}/css/srp_core.css" /> --%>
<head>
<title>Search student</title>

<script type="text/javascript">
	function validate() {
		debugger;
		var a = true;
		var firstName = $("#FirstName").val();
		var lastName = $("#LastName").val();

		if ((firstName.trim().length == 0) && (lastName.trim().length == 0)) {
			a = false;

			$("#javaScriptErrorMessage").addClass("alert alert-danger");
			$("#javaScriptErrorMessage")
					.html("Please enter at least one field");
			$("#javaScriptErrorMessage").show();
		}
		return a;
	}
	$(document).ready(function() {
		$("#javaScriptErrorMessage").hide();
	});

	// 	$("input[type=submit]").click(function(e){	}
</script>
</head>

<body>
	<!-- <div class="container mt-3"> -->
	<%@include file="../header.jsp"%>
	<div class="container">
		<fieldset>
			<legend>Search student</legend>

			<c:if test="${not empty error}">
				<div class="alert alert-danger alert-dismissible fade show">
					<button type="button" class="close" data-dismiss="alert">&times;</button>${error}</div>
			</c:if>

			<div id="javaScriptErrorMessage"></div>

			<form:form class="form-inline" method="post"
				action="${contextPath}/student/searchStudent"
				modelAttribute="student" onsubmit="return validate()">

				<label for="FirstName" class="mb-2 mr-sm-2">First Name : </label>
				<form:input path="FirstName" pattern="[A-Za-z]{0,20}" size="10"
					class="form-control mb-2 mr-sm-2 require" placeholder="First Name" />

				<label for="LastName" class="mb-2 mr-sm-2">Last Name : </label>
				<form:input path="LastName" pattern="[A-Za-z]{0,20}" size="10"
					class="form-control mb-2 mr-sm-2" placeholder="Last Name" />

				<button type="submit" class="btn btn-outline-success mb-2 mr-sm-2">Search</button>
			</form:form>
		</fieldset>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>