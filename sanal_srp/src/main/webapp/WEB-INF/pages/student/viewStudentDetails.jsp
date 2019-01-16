<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../bootstrap_files.jsp"%>
<title>Student Details</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col">
				Student Details : <a
					href="${contextPath}/student/editStudentDetails?studentId=${student.studentId}">Edit details</a>
			</div>
		</div>
		<div class="row">
			<div class="col">First Name :</div>
			<div class="col">${student.firstName}</div>
		</div>
		<div class="row">
			<div class="col">Last Name :</div>
			<div class="col">${student.lastName}</div>
		</div>
		<div class="row">
			<div class="col">Gender :</div>
			<div class="row">
				<c:choose>
					<c:when test="${student.studentGender eq 'true'}"> Male</c:when>
					<c:otherwise>Female</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="row">
			<div class="col">Roll No :</div>
			<div class="col">${student.studentExtraUqNo}</div>
		</div>
		<div class="row">
			<div class="col">Date Of Birth :</div>
			<div class="col">${student.studentDob }</div>
		</div>
		<div class="row">
			<div class="col">Aadhar No :</div>
			<div class="col">${student.studentAadharNo }</div>
		</div>
		<div class="row">
			<div class="col">educational Aadhar No :</div>
			<div class="col">is it necessary</div>
		</div>
		<div class="row">
			<div class="col">Religion :</div>
			<div class="col">${student.religion }</div>
		</div>
		<div class="row">
			<div class="col">Caste :</div>
			<div class="col">${student.caste }</div>
		</div>
		<div class="row">
			<div class="col">Previous Class :</div>
			<div class="col">${student.previousClass}</div>
		</div>
		<div class="row">
			<div class="col">Past Educational History Additional Info :</div>
			<div class="col">${student.pastEduAdditionalInfo}</div>
		</div>
		<div class="row">
			<div class="col">TC No :</div>
			<div class="col">${student.tcNumber}</div>
		</div>
		<div class="row">
			<div class="col">Identification Mark One :</div>
			<div class="col">${student.identificationMarkOne }</div>
		</div>
		<div class="row">
			<div class="col">Identification Mark Two :</div>
			<div class="col">${student.identificationMarkTwo }</div>
		</div>
		<div class="row">
			<div class="col">Disability :</div>
			<div class="col">aaaa</div>
		</div>
		<div class="row">
			<div class="col">Disability Info :</div>
			<div class="col">bbbb</div>
		</div>
		<div class="row">
			<div class="col">Require Aid :</div>
			<div class="col">cccc</div>
		</div>
		<div class="row">
			<div class="col">Info about aid :</div>
			<div class="col">dddd</div>
		</div>
		<div class="row">
			<div class="col">Commuting By :</div>
			<div class="col">eeee</div>
		</div>

		<div class="row">
			<div class="col">Point Of Contact Details:</div>
		</div>
		<div class="row">
			<div class="col">Name :</div>
			<div class="col">${student.pocName }</div>
		</div>
		<div class="row">
			<div class="col">Mobile No :</div>
			<div class="col">${student.pocContactNo}</div>
		</div>
		<div class="row">
			<div class="col">Relation :</div>
			<div class="col">${student.pocRelation}</div>
		</div>

		<div class="row">
			<div class="col">Student Present Address :</div>
			<div class="col">${student.presentAddress}
				<a
					href="${contextPath}/address/editAddress?addressId=${student.presentAddress.addressId}">Edit</a>
			</div>
		</div>
		<div class="row">
			<div class="col">Permanent Address :</div>
			<div class="col">
				${student.permanentAddress } <a
					href="${contextPath}/address/editAddress?addressId=${student.permanentAddress.addressId}">Edit</a>
			</div>
		</div>

		<div class="row">
			<div class="col">Commuting From :</div>
			<div class="col">${student.commutingFrom }
				<a
					href="${contextPath}/address/editAddress?addressId=${student.commutingFrom.addressId}">Edit</a>
			</div>
		</div>
	</div>
</body>
</html>