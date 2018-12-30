<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 --%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>

	Student Details
	<br /> First Name : ${student.firstName}
	<br /> Last Name : ${student.lastName}
	<br /> Gender :
	<c:choose>
		<c:when test="${student.studentGender eq 'M'}"> 
	Male</c:when>
		<c:otherwise>
	Female</c:otherwise>
	</c:choose>
	<br /> Roll No : ${student.studentExtraUqNo}
	<br /> Date Of Birth : ${student.studentDob }
	<br /> Aadhar No : ${student.studentAadharNo }
	<br /> educational Aadhar No : is it necessary
	<br /> Religion : ${student.religion }
	<br /> Caste : ${student.caste }
	<br /> Previous Class : ${student.previousClass}
	<br /> Past Educational History Additional Info :
	${student.pastEduAdditionalInfo}
	<br /> TC No : ${student.tcNumber}
	<br /> Identification Mark One : ${student.identificationMarkOne }
	<br /> Identification Mark Two : ${student.identificationMarkTwo }
	<br /> Disability :
	<br /> Disability Info :
	<br /> Require Aid :
	<br /> Info about aid :
	<br> Commuting By :

	<br />Point Of Contact Details:
	<br /> Name : ${student.pocName }
	<br /> Mobile No : ${student.pocContactNo}
	<br /> Relation : ${student.pocRelation}



	<br /> Student Present Address : ${student.presentAddress}
	<a
		href="/SanalSRP/address/editAddress?addressId=?${student.presentAddress.addressId}">Edit</a>
	<br /> Permanent Address : ${student.permanentAddress }
	<br /> Commuting From : ${student.commutingFrom }
	<br />
</body>
</html>