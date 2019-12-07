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


	

		<div class="container">
			<div class="brand">
				<a href="${pageContext.request.contextPath}/index">Mini
					Shop</a>
			</div>
			<div class="nav-right">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/cart/index.html">Cart</a></li>
					<li><a
						href="${pageContext.request.contextPath}/auth/logon.html">Log
							On</a></li>
					<li><a
						href="${pageContext.request.contextPath}/auth/register.html">Register</a></li>
					<li><a
						href="${pageContext.request.contextPath}/auth/logon.html">Log
							On</a></li>
					<li><a
						href="${pageContext.request.contextPath}/auth/register.html">Register</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="page">
		<div class="container">
			<div class="col-3">
				<ul>
					<c:forEach items="${categories}" var="o">
						<c:if test="${o.parent eq 0}">
							<li>${o.name}</li>
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
			<div class="col-9">
				<div class="page-header">
					<tiles:insertAttribute name="title" />
				</div>
				<tiles:insertAttribute name="content" />
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>