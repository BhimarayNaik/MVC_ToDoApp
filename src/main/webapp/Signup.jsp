<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<style>
div {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
	<div>
	
		<h1>Enter Details</h1>
			
		<form action="signup" method="post">
		
			<fieldset>
				<legend>SignUp Here</legend>
				<table>
					<tr>
						<th>Name :</th>
						<th><input type="text" name="name" required></th>
					</tr>
					<tr>
						<th>Email :</th>
						<th><input type="email" name="email" required></th>
						<th><h3 style="color: red">${email}</h3></th>
					</tr>
					<tr>
						<th>Password :</th>
						<th><input type="text" name="password" required></th>
					</tr>
					<tr>
						<th>MobileNumber :</th>
						<th><input type="tel" pattern="[0-9]{10}" name="mNumber" required></th>
					</tr>
					<tr>
						<th>Date Of Birth :</th>
						<th><input type="date" name="date" required></th>
						<th><h5 style="color:red">${msg}</h5></th>
					</tr>
					<tr>
						<th>Gender :</th>
						<th><input type="radio" name="gender" value="male" required>Male <input
							type="radio" name="gender" value="female">Female</th>
					</tr>
					<tr>
						<th><a href=""><button>SignUp</button></a></th>
						<th><a href=""><button type="reset">Cancel</button></a></th>
					</tr>
					<tr>
						<th colspan="2"><a href="login">Click Here If
								Already Have Account</a></th>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>
