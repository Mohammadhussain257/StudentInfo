<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>Student Form</title>
<%@ include file="header.jsp"%>
</head>
<body class="teal lighten-5">
	<div class="container h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div
				class="col col-sm-6 col-md-6 color-block mx-auto mt-3 deep-blue-gradient z-depth-2">
				<form action="StudentController" method="post"
					enctype="multipart/form-data" class="form-horizontal">
					<span><input type="hidden" value="${student.id}" name="id"></span>
					<div class="form-group">
						<div class="col-md-10">
							<label>Student Name :</label>
						</div>

						<div class="col-md-10">
							<input type="text" name="sname"
								class="form-control border border-primary rounded"
								value="${student.studentName}" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label>Roll No :</label>
						</div>

						<div class="col-md-10">
							<input type="number" name="roll"
								class="form-control border border-primary rounded"
								value="${student.roll}" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label>Date of Birth :</label>
						</div>

						<div class="col-md-10">
							<input type="date" name="dob"
								class="form-control border border-primary rounded"
								value="${student.dob}" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label>College Name :</label>
						</div>

						<div class="col-md-10">
							<input type="text" name="cname"
								class="form-control border border-primary rounded"
								value="${student.collegeName}" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label>Subject Name :</label>
						</div>

						<div class="col-md-10">
							<input type="checkbox" name="subject" value="Java"
								<c:if test="${fn:contains(student.subject,'Java')}">checked</c:if>>Java
							<input type="checkbox" name="subject" value="PHP"
								<c:if test="${fn:contains(student.subject,'PHP')}">checked</c:if>>PHP
							<input type="checkbox" name="subject" value="Android"
								<c:if test="${fn:contains(student.subject,'Android')}">checked</c:if>>Android
							<input type="checkbox" name="subject" value=".Net"
								<c:if test="${fn:contains(student.subject,'.Net')}">checked</c:if>>.Net
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label>Email :</label>
						</div>

						<div class="col-md-10">
							<input type="email" name="email"
								class="form-control border border-primary rounded"
								value="${student.email}" required autofocus>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label>Gender :</label>
						</div>

						<div class="col-md-10">
							<input type="radio" name="gender" value="male"
								${student.gender=='male'?'checked':''}>Male <input
								type="radio" name="gender" value="female"
								${student.gender=='female'?'checked':''}>Female
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label>Department :</label>
						</div>

						<div class="col-md-10">
							<select name="departCombo"
								class="form-control border border-primary rounded">
								<option value="IT" ${student.department=='IT'?'selected':''}>IT</option>
								<option value="Computer"
									${student.department=='Computer'?'selected':''}>Computer</option>
								<option value="Electrical"
									${student.department=='Electrical'?'selected':''}>Electrical</option>
								<option value="Communication"
									${student.department=='Communication'?'selected':''}>Communication</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10">
							<label>Upload Image </label>
						</div>
						<div class="col-md-10">
							<input type="file"
								class="form-control border border-primary rounded" name="photo">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10 text-center">
							<input type="submit" value="Submit" class="btn btn-primary">
							<input type="reset" value="Reset" class="btn btn-primary">
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
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