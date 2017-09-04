<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<link href="<c:url value="resources/style.css" />" rel="stylesheet">
<title>My Friends</title>
</head>
<body>
	<h1>This is the list with my friends</h1>

	<div class="left_spacing">Friends:</div>
	<ul>
		<c:forEach var="friendsList" items="${friend}">
			<li><div class="editor-rez, title-width">
					<c:out value="${friendsList.name}" />
				</div></li>
		</c:forEach>
	</ul>

	<a href="home">Home</a>
	<a href="user">Profile</a>
	<a href="friends">View Friends List</a>
	<a href="logout">Logout</a>

</body>
</html>
