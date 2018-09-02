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
<title>mail check</title>
</head>
<body class="teal lighten-5">
	<div class="container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div
				class="col col-sm-6 col-md-6 color-block mx-auto mt-3 deep-blue-gradient z-depth-2">
				<form action="ForgotPassword" method="post"
					enctype="multipart/form-data">
					<span style="color: red">${EmailNotFound}</span>
					<div class="form-group">
						<div class="col-md-10">
							<h6 class="text-center text-white">Enter Your Email Address</h6>
						</div>
						<div class="col-md-10">
							<input type="email" name="email"
								class="form-control border border-primary rounded"
								placeholder="example@gmail.com" required autofocus>
						</div>
					</div>
					<div>
						<div class="col-md-10 text-center">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
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