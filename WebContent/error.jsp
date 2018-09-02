<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Error Page</title>
<%@ include file="header.jsp"%>
</head>
<body class="teal lighten-5">
	<h1 class="text-center text-danger">404 NOT FOUND ? Opp's you have
		encounter an error!!!</h1>
	<ul>
		<li class="text-primary">Exception:
			<p class="text-primary">
				<c:out value="${requestScope['javax.servlet.error.exception']}"></c:out>
			</p>
		</li>
		<li class="text-secondary">Request URI:
			<p class="text-secondary">
				<c:out value="${requestScope['javax.servlet.error.request_uri']}"></c:out>
			</p>
		</li>
		<li class="text-info">Servlet name:
			<p class="text-info">
				<c:out value="${requestScope['javax.servlet.error.servlet_name']}"></c:out>
			</p>
		</li>
		<li class="text-warning">Status code:
			<p class="text-warning">
				<c:out value="${requestScope['javax.servlet.error.status_code']}"></c:out>
			</p>
		</li>
	</ul>
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