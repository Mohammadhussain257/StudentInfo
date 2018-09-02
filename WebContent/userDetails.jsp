<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user</title>
<%@ include file="header.jsp"%>
</head>
<body class="teal lighten-5">
	<h1 class="text-center textdecorate">User Details</h1>
	<a class="btn btn-secondary" href="UserController?actions=add_new">Add
		User</a>
	<c:if test="${!empty users }">
		<table class="table table-hover">
			<thead class="black white-text">
				<tr>
					<th scope="col">#</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>DOB</th>
					<th>Email</th>
					<th>User Name</th>
					<th>password</th>
					<th>Image</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.userId}"></c:out></td>
						<td><c:out value="${user.firstName}"></c:out></td>
						<td><c:out value="${user.lastName}"></c:out></td>
						<td><c:out value="${user.gender}"></c:out></td>
						<td><c:out value="${user.dob}"></c:out></td>
						<td><c:out value="${user.email}"></c:out></td>
						<td><c:out value="${user.username}"></c:out></td>
						<td><c:out value="${user.password}"></c:out></td>
						<td><img src="ImageDisplayController?userId=${user.userId}"
							alt="Picture" height="50px" width="50px"></td>
						<td><a class="btn btn-primary btn-sm"
							href="UserController?actions=edit&userId=${user.userId}">Edit</a>
							<a class="btn btn-danger btn-sm"
							href="UserController?actions=delete&userId=${user.userId}">Delete</a>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<%@ include file="footer.jsp" %>
</body>
</html>