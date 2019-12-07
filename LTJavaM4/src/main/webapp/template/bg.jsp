<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/style.css'/>">
</head>
<body>
	<div class="title">
		<div class="container">
			<div class="brand">
				<a href="${pageContext.request.contextPath}/index">Minishop</a>
			</div>
		</div>
	</div>
	<div class="sidebar">

		<ul>
			<c:forEach items="${categories}" var="o">
				<c:if test="${o.parent eq null}">
					<li style="color:black">${o.name}</li>
					<ul>
						<c:forEach items="${categories}" var="child">
							<c:if test="${child.parent eq o.id}">
								<li><a
									href="${pageContext.request.contextPath}/home/browse.html?id=${child.id}">${child.name}</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</c:if>
			</c:forEach>
		</ul>
	</div>
	<div class="main">
		<tiles:insertAttribute name="content" />
	</div>
</body>
</html>