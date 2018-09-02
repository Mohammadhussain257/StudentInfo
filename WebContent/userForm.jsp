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
<title>User Form</title>
<%@ include file="header.jsp"%>
</head>
<body class="teal lighten-5">
	<div class="container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div
				class="col col-sm-6 col-md-6 color-block mx-auto mt-3 deep-blue-gradient z-depth-2">
				<form action="UserController" method="post"
					enctype="multipart/form-data" class="form-horizontal">
					<span><input type="hidden" value="${user.userId}"
						name="userid"></span>
					<div class="form-group">
						<div class="col-md-10">
							<label>First Name :</label>
						</div>
						<div class="col-md-10 ">
							<input type="text" name="fname"
								class="form-control border border-primary rounded"
								value="${user.firstName}" required autofocus>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10">
							<label>Last Name :</label>
						</div>

						<div class="col-md-10">
							<input type="text" name="lname"
								class="form-control border border-primary rounded"
								value="${user.lastName}" required autofocus>
						</div>
					</div>

					<div class="col-md-10 form-check-inline">
						<div class="col-md-6">
							<label>Gender :</label>
						</div>
						<div>
							<input type="radio" name="gender" class="form-check-input"
								value="male" ${user.gender=='male'?'checked':''}>Male <input
								type="radio" name="gender" class="form-check-input"
								value="female" ${user.gender=='female'?'checked':''}>Female
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10">
							<label>Date of Birth :</label>
						</div>
						<div class="col-md-10">
							<input type="date" name="dob"
								class="form-control border border-primary rounded"
								value="${user.dob}" required autofocus>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10">
							<label>Email :</label>
						</div>

						<div class="col-md-10">
							<input type="email" name="email"
								class="form-control border border-primary rounded"
								value="${user.email}" required autofocus>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10">
							<label>User Name :</label>
						</div>

						<div class="col-md-10">
							<input type="text" name="uname"
								class="form-control border border-primary rounded"
								value="${user.username}" required autofocus>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10">
							<label>Password :</label>
						</div>

						<div class="col-md-10">
							<input type="password" name="pass"
								class="form-control border border-primary rounded"
								value="${user.password}" required autofocus>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10">
							<label>Upload Image</label>
						</div>

						<div class="col-md-10">
							<input type="file" name="image"
								class="form-control border border-primary rounded"
								value="${user.imageUrl}" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10 text-center">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-primary">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript"
		src="resources/jQuery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="resources/bootstrap-4.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="resources/bootstrap-4.1.3/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/mdb/js/mdb.min.js"></script>
</body>
</html>