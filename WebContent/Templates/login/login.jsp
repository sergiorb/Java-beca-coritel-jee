<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loginapp - login</title>

<%@ include file="../partials/css_links.html"%>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 text-center">
				<h1>Login Page</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6 col-md-offset-3">
			
				<form role="form" action="${pageContext.request.contextPath}/login" method="post">

					<c:choose>
						<c:when test="${validLogin == 'false'}">
							<div class="form-group has-error">
						</c:when>
						<c:otherwise>
							<div class="form-group">
						</c:otherwise>
					</c:choose>

						<label for="name">Email:</label> 
						<input type="text" class="form-control" id="email" name="email">
					</div>

					<c:choose>
						<c:when test="${validLogin == 'false'}">
							<div class="form-group has-error">
						</c:when>
						<c:otherwise>
							<div class="form-group">
						</c:otherwise>
					</c:choose>
						<label for="password">Password:</label> 
						<input type="password" class="form-control" id="password" name="password">
					</div>
					
					<button type="submit" class="btn btn-success">Login</button>
				</form>
			</div>
		</div>
		
		<c:choose>
			<c:when test="${validLogin == 'false'}">
				<br>
				<div class="col-md-6 col-md-offset-3 text-center">
					<div class="alert alert-warning">
						
						<h4>Login error!</h4>
					</div>
				</div>
			</c:when>
		</c:choose>

</body>
</html>