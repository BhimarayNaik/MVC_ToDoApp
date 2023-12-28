<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
<style type="text/css">
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<form action="add-task" method="post">
		<h1 align="center">Add Task</h1>
		<fieldset>
			<legend>Enter Task Here,</legend>
			<table border="1">
				<tr>
					<th>Task Name :</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>Task Description :</th>
					<td><input type="text" name="description"></td>
				</tr>
				<th><button>Add</button></th>
				<th><button>Cancel</button></th>
			</table>
		</fieldset>
	</form>
	<br>
	<br>
	<a href="home"><button>Back</button></a>
</body>
</html>