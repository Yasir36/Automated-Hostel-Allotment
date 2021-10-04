<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div align="center">
		<c:if test="${fPaid == false}">
			<h1>YOUR APPLICATION HAS BEEN SUCCESFULLY REGISTERED!</h1>
			<h2>Go TO feeee....fe..ef..f and fill out your information</h2>
			<h2>Print the challan and take it to your nearest HBL branch
				within the next 2 days</h2>
			<h2>An admin will confirm your payment and approve your
				application</h2>
			<h1>AN ADMIN WILL NOW APPROVE YOUR APPLICATION , COMEBACK AFTER
				24Hours FOR CONMFIRMATION</h1>
			<h3>note:it can take more than one office day(s) for the
				confirmation${rollNo}</h3>

			<form action="ApplicationController">
				<input type="hidden" name="rollNo" value="${rollNo}">
				<button>FEES PAID</button>
			</form>
			<form action="Login.jsp">
				<button>OK</button>
			</form>
		</c:if>
		<c:if test="${fPaid==true}">
			<h1>YOUR APPLICATION HAS BEEN APPROVED</h1>
			<h2>THE OFFICIAL HOSTEL LIST WILL BE ANNOUNCED SOON!</h2>
			<h2>SO KEEP CHECKING EVERY NOW AND THEN!</h2>
			<h2>THE LIST CAN BE CHECKED HERE DEIRECLTY</h2>
			<h3>OR ON THE OFFICIAL FB PAGE.</h3>
			<form action="Login.jsp">
				<button>OK</button>
			</form>
		</c:if>

		<c:if test="${listUploaded == true }">
			<h1>List has been uploaded! check to see if you have been
				alotted</h1>
			<form action="AllotmentController">
				<button>See List</button>
			</form>

		</c:if>

	</div>


</body>
</html>