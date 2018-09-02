<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="resources/bootstrap-4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/mdb/css/mdb.min.css">
<link rel="stylesheet" href="resources/mdb/css/style.css">
<title>Login Form</title>
</head>
<body class="teal lighten-5">
	<div class="container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div
				class="col col-sm-6 col-md-6 color-block mx-auto mt-3 young-passion-gradient z-depth-2">
				<form action="LoginController" method="post" class="form-horizontal">
					<span class="text-center text-danger">${loginFailMsg}</span> <span
						class="text-center text-success">${logoutFailMsg}</span>
					<div class="form-group">
						<h1 class="text-white text-center">Login Form</h1>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label class="text-white">User Name</label>
						</div>

						<div class="col-md-10">
							<input type="text" name="uname"
								class="form-control border border-primary rounded"
								value="${username}" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label class="text-white">Password</label>
						</div>

						<div class="col-md-10">
							<input type="password"
								class="form-control border border-primary rounded" name="pass"
								required autofocus>
						</div>
					</div>
					<div class="form-group col-md-10">
						<input type="checkbox" name="remember-me" class="form-check-input"
							value="remember-me"> <label class="text-white">Remember
							Me</label>
					</div>
					<a href="forgotPassword.jsp" class="text-white">Forgot Password</a>
					<div class="form-group col-md-10 text-center">
						<input type="submit" class="btn btn-secondary" value="Login">
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="resources/jQuery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="resources/bootstrap-4.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="resources/bootstrap-4.1.3/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/mdb/js/mdb.min.js"></script>
</body>
</html>