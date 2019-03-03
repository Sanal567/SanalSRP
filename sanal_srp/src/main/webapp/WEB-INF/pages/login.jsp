<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--  Bootstrap Local CSS and JS   -->
<link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css">
<script src="${contextPath}/js/jquery-3.3.1.slim.min.js"
	type="text/javascript"></script>
<script src="${contextPath}/js/popper.min.js" type="text/javascript"></script>
<script src="${contextPath}/js/bootstrap.min.js" type="text/javascript"></script>

<title>Login Page</title>
</head>

<body onload='document.loginForm.username.focus();'>
	<div class="container">
		<div align="center">
			<h2>Sanal SRP</h2>

			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<form name='loginForm' method="post"
				action="<c:url value='/login' />">
				<fieldset>
					<legend>Login Form</legend>

					<div class="form-group input-group row">
						<div class="col" align="right">
							<label for="username"> User name : </label>
						</div>
						<div class="col" align="left">
							<input type="text" class="form-control" id="username"
								name="username" placeholder="Enter your Username">
						</div>

					</div>
					<div class="form-group row">
						<div class="col" align="right">
							<label for="password"> Password:</label>
						</div>
						<div class="col" align="left">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Enter password">
						</div>
					</div>

					<div class="form-group form-check row">
						<div class="col">
							<label class="form-check-label"> <input
								class="form-check-input" type="checkbox" name="remember">
								Remember me
							</label>
						</div>
					</div>

					<div class="row">
						<div class="col">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

				</fieldset>
			</form>
		</div>
	</div>

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

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>  -->
</body>
</html>