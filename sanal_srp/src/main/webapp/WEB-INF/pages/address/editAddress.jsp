<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../bootstrap_files.jsp" %>
<title>Edit Address</title>

<!-- <style type="text/css">
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
 -->
 </head>

<body>
	<div class="container">
		<div class="form-group">
			<form:form action="${contextPath}/address/updateAddress"
				modelAttribute="address" method="POST">
				<fieldset>
					<legend>Edit Address</legend>
					<!-- <div class="row">
				<div class="col">Edit Address</div>
			</div>
			 -->
					<div class="row">
						<div class="col">
							<label for="doorOrHouseNo">Door/House No : </label>
						</div>
						<div class="col">
							<form:input path="doorOrHouseNo" class="form-control mb-2" />
						</div>
						<div class="col">
							<form:errors path="doorOrHouseNo" cssClass="error" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="streetOne">Street/Village<sup
								style="color: red;">*</sup>:
							</label>
						</div>
						<div class="col">
							<form:input path="streetOne" class="form-control mb-2" />
						</div>
						<div class="col">
							<form:errors path="streetOne" cssClass="error" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="streetTwo">Area/Panchayat : </label>
						</div>
						<div class="col">
							<form:input path="streetTwo" class="form-control mb-2" />
						</div>
						<div class="col">
							<form:errors path="streetTwo" cssClass="error" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="landmark">Landmark : </label>
						</div>
						<div class="col">
							<form:input path="landmark" class="form-control mb-2" />
						</div>
						<div class="col">
							<form:errors path="landmark" cssClass="error" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="Mandal">Mandal<sup
								style="color: red;">*</sup>: </label>
						</div>
						<div class="col">
							<form:input path="mandal" class="form-control mb-2" />
						</div>
						<div class="col">
							<form:errors path="mandal" cssClass="error" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="district">District<sup
								style="color: red;">*</sup>: </label>
						</div>
						<div class="col">
							<form:input path="district" class="form-control mb-2" />
						</div>
						<div class="col">
							<form:errors path="district" cssClass="error" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="pinCode">PIN Code<sup
								style="color: red;">*</sup>: </label>
						</div>
						<div class="col">
							<form:input path="pinCode" class="form-control mb-2" />
						</div>
						<div class="col">
							<form:errors path="pinCode" cssClass="error" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="additionalInfo"> Additional Info : </label>
						</div>
						<div class="col">
							<form:input path="additionalInfo" class="form-control mb-2" />
						</div>
						<div class="col">
							<form:errors path="additionalInfo" cssClass="error" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							<input type="submit" value="Update" class="btn" />
						</div>
					</div>
				</fieldset>
				<form:hidden path="addressId"/>
			</form:form>
		</div>
	</div>
</body>
</html>