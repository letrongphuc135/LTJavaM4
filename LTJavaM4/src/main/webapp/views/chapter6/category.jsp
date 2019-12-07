<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/category/add.html"
		class="btn btn-primary">Add</a>
	<form method="post"
		action="${pageContext.request.contextPath}/category/dels.html">
		<table class="table">
			<tr>
				<td><button class="btn btn-info">Delete</button></td>
				<th>Id</th>
				<th>Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="o">
				<tr>
					<td><input type="checkbox" value="${o.id}" name="ids">
					</td>
					<td>${o.id}</td>
					<td>${o.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/category/edit/${o.id}">
							<img src="${pageContext.request.contextPath}/images/edit.png"
							alt="Edit">
					</a></td>
					<td><a
						href="${pageContext.request.contextPath}/category/del/${o.id}">
							<img src="${pageContext.request.contextPath}/images/trash.png"
							alt="Delete">
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>