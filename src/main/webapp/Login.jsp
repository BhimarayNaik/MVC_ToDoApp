<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
div {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
<body>
	<div>
		<h1 style="color: green">${pass}</h1>
		<h1>${cred}</h1>
		<h1>ToDo Login</h1>
	
		<form action="login" method="post">
			<fieldset>
				<legend>Login Here</legend>
				<table>
					<tr>
						<th>Email :</th>
						<th><input type="email" name="email"></th>
					</tr>
					<tr>
						<th>Password :</th>
						<th><input type="text" name="pass"></th>
					</tr>
					<tr>
						<th><a href="home"><button>Login</button></a></th>
						<th><a href=""><button type="reset">Cancel</button></a></th>
					</tr>
					<tr>
						<th colspan="2"><a href="signup">Click Here To SignUp</a></th>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>