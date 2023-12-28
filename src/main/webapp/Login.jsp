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
	    <h2 style="color:red">${fail}</h2>
		<h1 style="color: green">${account}</h1>
		<h1 style="color: green">${logout}</h1>
		<h1>${cred}</h1>
		<h1>ToDo Login</h1>
	
		<form action="login" method="post">
			<fieldset>
				<legend>Login Here</legend>
				<table>
					<tr>
						<th>Email :</th>
						<th><input type="email" name="email"></th>
						<th><h3 style="color:red">${email}</h3></th>
					</tr>
					<tr>
						<th>Password :</th>
						<th><input type="text" name="password"></th>
						<th><h3 style="color:red">${password}</h3></th>
					</tr>
					<tr>
						<th><a href=""><button>Login</button></a></th>
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