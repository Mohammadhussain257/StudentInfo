<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="resources/bootstrap-4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/mdb/css/mdb.min.css">
<link rel="stylesheet" href="resources/mdb/css/style.css">
<%@ include file="header.jsp"%>
</head>
<body class="teal lighten-5">
	<h1 class="text-center textdecorate">Student
		Details</h1>
	<a class="btn btn-secondary" href="StudentController?actions=add_new">Add
		New</a>
	<c:if test="${!empty students}">
		<table class="table table-hover">
			<thead class="black white-text">
				<tr>
					<th scope="col">#</th>
					<th>Student Name</th>
					<th>College Name</th>
					<th>Roll</th>
					<th>Email</th>
					<th>DOB</th>
					<th>Gender</th>
					<th>Department</th>
					<th>Subject</th>
					<th>Profile Picture</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td><c:out value="${student.id}"></c:out></td>
						<td><c:out value="${student.studentName}"></c:out></td>
						<td><c:out value="${student.collegeName}"></c:out></td>
						<td><c:out value="${student.roll}"></c:out></td>
						<td><c:out value="${student.email}"></c:out></td>
						<td><c:out value="${student.dob}"></c:out></td>
						<td><c:out value="${student.gender}"></c:out></td>
						<td><c:out value="${student.department}"></c:out></td>
						<td><c:out value="${student.subject}"></c:out></td>
						<td><img src="ImageDisplayController?id=${student.id}"
							alt="Picture" height="50px" width="50px"></td>
						<td><a class="btn btn-primary btn-sm"
							href="StudentController?actions=edit&id=${student.id}">Edit</a> <a
							class="btn btn-danger btn-sm"
							href="StudentController?actions=delete&id=${student.id}">Delete</a>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</c:if>
<%@ include file="footer.jsp" %>
	<script type="text/javascript"
		src="resources/jQuery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="resources/bootstrap-4.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="resources/bootstrap-4.1.3/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/mdb/js/mdb.min.js"></script>
</body>
</html>