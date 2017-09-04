<%@include file="include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<html>
<head>
<link href="<c:url value="resources/style.css" />" rel="stylesheet">
<title>Profile</title>

</head>
<body>


	<P>Welcome</P>
	<h1>This is my profile ${userName}</h1>

	<form:form id="messageForm" method="post" action="user"
			modelAttribute="messageBean">
			<center>
				<table border="1" width="30%" cellpadding="3">
					<thead>
						<tr>
							<th colspan="2">Post Message</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Name</td>
							<td><input type="text" name="user" value="${userName}" /></td>
						</tr>
						<tr>
							<td>Message</td>
							<td><input type="text" name="text" value="" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Send" /></td>
						</tr>
					</tbody>
				</table>
			</center>
		</form:form>
		
							<div class="left_spacing">Messages:</div>
					<ul>
						<c:forEach var="messagesList" items="${messageText}">
							<li><div class="editor-rez, title-width">
									<c:out value="${messagesList.user} : " /> 
									<c:out value="${messagesList.text}" /> 
								</div></li>
						</c:forEach>
					</ul>

	<a href="home">Home</a>
	<a href="user">Profile</a>
	<a href="friends">View Friends List</a>
	<a href="logout">Logout</a>

</body>
</html>
