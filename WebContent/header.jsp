<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="resources/bootstrap-4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/mdb/css/mdb.min.css">
<link rel="stylesheet" href="resources/mdb/css/style.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark primary-color">
		<a class="navbar-brand" href="#">SIS</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="StudentController?actions=list_student">Student List</a></li>
				<li class="nav-item"><a class="nav-link"
					href="UserController?actions=User_list">User List</a></li>
				<li class="nav-item"><a class="nav-link"
					href="FileUploadController?actions=download">Download</a></li>
				<li class="nav-item"><a class="nav-link"
					href="FileUploadController?actions=upload">Upload</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="#"><%=session.getAttribute("username")%></a></li>
				<li class="nav-item"><img class="rounded-circle img-fluid"
					src="ImageDisplayController?userId=${sessionScope.userId}"
					alt="Picture" height="40px" width="40px"></li>
				<li class="nav-item"><a class="nav-link" href="LoginController">Logout</a></li>
			</ul>
		</div>
	</nav>

	<script type="text/javascript"
		src="resources/jQuery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="resources/bootstrap-4.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="resources/bootstrap-4.1.3/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/mdb/js/mdb.min.js"></script>
</body>
</html>