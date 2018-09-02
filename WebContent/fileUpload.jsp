<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
<%@ include file="header.jsp"%>
</head>
<body class="teal lighten-5">
	<div class="container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div
				class="col col-sm-6 col-md-6 color-block mx-auto mt-3 deep-blue-gradient z-depth-2">
				<form action="FileUploadController" method="post"
					enctype="multipart/form-data">
					<div>
						<div>
							<h5 class="text-center text-success">${fileUploadMsg}</h5>
						</div>
						<div class="form-group">
							<div>
								<h2 class="text-center textdecorate">Upload File</h2>
								<h6 class="text-center text-white">Eg:- Photo,notice,text-data, etc</h6>
							</div>
							<div class="col-md-10">
								<input type="file"
									class="form-control border border-primary rounded"
									name="filename">
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-10">
								<span>File Description</span>
							</div>
							<div class="col-md-10">
								<input type="text"
									class="form-control border border-primary rounded"
									name="description" required autofocus>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-10 text-center">
								<input type="submit" class="btn btn-secondary" value="Upload">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<%@ include file="footer.jsp" %>
</body>
</html>