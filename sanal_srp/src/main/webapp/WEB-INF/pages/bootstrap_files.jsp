<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:url value="/logout" var="logoutUrl" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--  Bootstrap Local CSS and JS   -->
<link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css">
<script src="${contextPath}/js/jquery-3.3.1.slim.min.js"
	type="text/javascript"></script>
<script src="${contextPath}/js/popper.min.js" type="text/javascript"></script>
<script src="${contextPath}/js/bootstrap.min.js" type="text/javascript"></script>

<!-- Bootstrap  CDN CSS & JS-->
<!-- <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous" type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous" type="text/javascript"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous" type="text/javascript"></script> -->

<script type="text/javascript">
	//Using jQuery (but could use pure JS with cross-browser event handlers):
	var idleSeconds = 1800;

	$(function() {
		var idleTimer;
		function resetTimer() {
			clearTimeout(idleTimer);
			idleTimer = setTimeout(whenUserIdle, idleSeconds * 1000);
		}
		$(document.body).bind('mousemove keydown click', resetTimer); //space separated events list that we want to monitor
		resetTimer(); // Start the timer when the page loads
	});

	function whenUserIdle() {
		document.getElementById("logoutForm").submit();
	}
</script>

<form:form action="${logoutUrl}" method="post" id="logoutForm"></form:form>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>

