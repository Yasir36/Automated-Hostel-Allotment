<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="registration-form">
		<h1>REGISTER</h1>
		<form action="RegistrationFormController">
			<div class="registration-details">
				<label>First Name:</label><br> <input type="text"
					alt="firstName" name="firstName"><br> <label>Last
					Name:</label><br> <input type="text" alt="lastName" name="lastName"><br>
				<label>Father Name:</label><br> <input type="text"
					alt="fatherName" name="fatherName"><br> <label>Surname:</label><br>
				<input type="text" alt="surame" name="surname"><br> <label>Date
					Of Birth:</label><br> <input type="date" alt="dateOfBirth"
					name="dateOfBirth"><br> <label>CNIC:</label><br>
				<input type="text" alt="cnic" name="CNIC"><br> <label>District:</label><br>
				<input type="text" alt="district" name="district"><br>
				<label>Current Address:</label><br> <input type="text"
					alt="currentAddress" name="currentAddress"><br> <label>Permanent
					Address:</label><br> <input type="text" alt="permanentAddress"
					name="permanentAddress"><br> <label>Guardian
					Name:</label><br> <input type="text" alt="guardianName"
					name="guardianName"><br> <label>Guardian CNIC:</label><br>
				<input type="text" alt="guardianCNIC" name="guardianCNIC"><br>
				<label>Department:</label><br> <input type="text"
					alt="department" name="dept"><br> <label>Roll
					Number:</label><br> <input type="text" alt="rollNo" name="rollNo"><br>
				<label>Postal Code:</label><br> <input type="number"
					alt="postalCode" name="postalCode"><br> <label>Email:</label><br>
				<input type="text" alt="email" name="email"><br>
				<br>

				<button>Submit</button>
			</div>
		</form>
	</div>
</body>
</html>