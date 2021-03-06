<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<%@include file="bootstrap_files.jsp"%>
<title>Home</title>
</head>

<body>
	<%@include file="header.jsp"%>


	${pageContext.request.userPrincipal} Welcome :
	${pageContext.request.userPrincipal.name}
	<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
		<!-- For login user -->
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>
	</sec:authorize>


	<a href="${contextPath}/admission/admit">Admissions</a>

</body>

<!-- <script type="text/javascript">
	debugger;
	// Set timeout variables.
	var timoutWarning = 10000;
	//var timoutWarning = 840000; // Display warning in 14 Mins.
	var timoutNow = 5000;
	//var timoutNow = 100000; // Timeout in 15 mins would be 900000.
	var logoutUrl = "${logoutUrl}"; // URL to logout page.

	var warningTimer;
	var timeoutTimer;

	/// Start warning timer.
	function StartWarningTimer() {
		warningTimer = setTimeout("IdleWarning()", timoutWarning);

	}

	// Reset timers.
	function ResetTimeOutTimer() {

		clearTimeout(timeoutTimer);
		StartWarningTimer();
		$("#timeout").dialog('close');
	}

	// Show idle timeout warning dialog.
	function IdleWarning() {
		clearTimeout(warningTimer);
		timeoutTimer = setTimeout("IdleTimeout()", timoutNow);
		$("#timeout").dialog({
			modal : true
		});
		// Add code in the #timeout element to call ResetTimeOutTimer() if
		// the "Stay Logged In" button is clicked
	}

	// Logout the user.
	function IdleTimeout() {
		window.location = logoutUrl;
	}
</script> -->
</html>