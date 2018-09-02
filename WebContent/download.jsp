<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Download</title>
<%@ include file="header.jsp"%>
</head>
<body class="teal lighten-5">
	<c:if test="${!empty fileList}">
		<table class="table table-hover">
			<thead class="black white-text">
				<tr>
					<th scope="col">#</th>
					<th>File Name</th>
					<th>File Description</th>
					<th>Download File</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fileList}" var="file">
					<tr>
						<td><c:out value="${file.id }"></c:out></td>
						<td><c:out value="${file.filePath }"></c:out></td>
						<td><c:out value="${file.description}"></c:out></td>
						<td><a class="btn btn-success btn-sm"
							href="FileDownloadController?fileName=${file.id}">Download</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
<%@ include file="footer.jsp" %>
</body>
</html>