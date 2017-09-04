<%@include file="include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Cool Twitter</title>
<link href="<c:url value="resources/style.css" />" rel="stylesheet">
</head>
<body>
	<h1>Welcome to SpriTTer</h1>

	<P>The time on the server is ${serverTime}.</P>


	<form:form id="loginForm" method="post" action="login"
		modelAttribute="loginBean">
		<center>
			<p>Status : ${status}</p>
			<table border="1" width="30%" cellpadding="3">
				<thead>
					<tr>
						<th colspan="2">Login Here</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>User Name</td>
						<td><input type="text" name="username" value="" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" value="" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Login" /></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form:form>

	<a href="home">Home</a>
	<a href="user">Profile</a>
	<a href="friends">View Friends List</a>
	<a href="logout">Logout</a>

</body>
</html>
