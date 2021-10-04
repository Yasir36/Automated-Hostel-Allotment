<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Applications</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>FIRST NAME</th>
					<th>LAST NAME</th>
					<th>ROLL NO.</th>
					<th>CNIC</th>
					<th>CHALLAN NO.</th>
					<th>FEES STATUS</th>
					<th colspan="2">OPERATIONS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${applicants}" var="applicant">
					<tr>
						<td><c:out value="${applicant.id}" /></td>
						<td><c:out value="${applicant.firstName}" /></td>
						<td><c:out value="${applicant.lastName}" /></td>
						<td><c:out value="${applicant.rollNo}" /></td>
						<td><c:out value="${applicant.CNIC}" /></td>
						<td><c:out value="${applicant.challanNo}" /></td>
						<td><c:out value="${applicant.feesStatus}" /></td>
						<c:if test="${operation == 'approve'}">
							<td><a class="btn-link"
								href="ApplicationController?action=approve&id=${applicant.id}">APPROVE</a></td>
						</c:if>
						<c:if test="${operation == 'reject'}">
							<td><a class="btn-link"
								href="ApplicationController?action=reject&id=${applicant.id}">REJECT</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="adminForm.jsp">
			<button class="btn">Back</button>
		</form>
	</div>

</body>
</html>