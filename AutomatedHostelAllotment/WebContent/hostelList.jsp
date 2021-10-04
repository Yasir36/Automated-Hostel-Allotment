<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hostel Allotment List</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div align="center">
		<table>
			<thead>
				<tr>
					<th>Room No.</th>
					<th>NAME</th>
					<th>ROLL NO.</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rooms}" var="room" varStatus="i">
					<tr>
						<td><c:out value="${room.roomNo}" /></td>
						<c:forEach items="${room.residents}" var="resident">

							<td><c:out value="${resident.fullName}" /></td>

							<td><c:out value="${resident.rollNo}" /></td>

						</c:forEach>
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