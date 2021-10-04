<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminForm</title>
</head>
<body>
	<div align="center">
		<form action="ApplicationController">
			<input type="hidden" name="getApprovedApplicants" value="true">
			<button>SHOW UNAPPROVED APPLICATIONS</button>
		</form>
		<form action="ApplicationController">
			<input type="hidden" name="getApprovedApplicants" value="false">
			<button>SHOW APPROVED APPLICATIONS</button>
		</form>
		<form action="AllotmentController">
			<button>START ALLOTMENT</button>
		</form>

		<form action="Login.jsp">
			<button>Back</button>
		</form>
	</div>
</body>
</html>