<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loginapp - Signup</title>

<%@ include file="../partials/css_links.html"%>

<style type="text/css">
0
.btn-loguot {
	padding-top: 10px;
	padding-bottom: 15px;
}
</style>

</head>
<body>

	<%@ include file="../partials/navbar.jsp"%>
	
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-6 col-md-offset-3">
			
				<form role="form" action="${pageContext.request.contextPath}/signup" method="post">
				
					<c:choose>
						<c:when test="${nameError == 'true'}">
							<div class="form-group has-error">
						</c:when>
						<c:otherwise>
							<div class="form-group">
						</c:otherwise>
					</c:choose>
						<label for="name">Name:</label> 
						<input type="text" class="form-control" id="name" name="name" 
						 placeholder="Name" required>
					</div>

					<c:choose>
						<c:when test="${emailError == 'true'}">
							<div class="form-group has-error">
							<span id="helpBlock2" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
						</c:when>
						<c:when test="${emailError == 'alreadyExist'}">
							<div class="form-group has-warning">
						</c:when>
						<c:otherwise>
							<div class="form-group">
						</c:otherwise>
					</c:choose>

						<label for="name">Email:</label> 
						<input type="email" class="form-control" id="email" name="email" 
						pattern="[a-zA-Z0-9!#$%&amp;'*+\/=?^_`{|}~.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*"
						 placeholder="Email" required>
					</div>

					<label for="password">Password:</label> 
					<c:choose>
						<c:when test="${passwordError == 'true'}">
							<div class="form-group has-error">
							<span id="helpBlock1" class="help-block">Invalid password.</span>
						</c:when>
						<c:otherwise>
							<div class="form-group">
						</c:otherwise>
					</c:choose>
						<input type="password" class="form-control" id="password" name="password" 
						 placeholder="Password" required>
					</div>
					
					<c:choose>
						<c:when test="${passwordError2 == 'true'}">
							<div class="form-group has-error">
							<span id="helpBlock2" class="help-block">Invalid password.</span>
						</c:when>
						<c:when test="${passwordError2 == 'notEqual'}">
							<div class="form-group has-error">
							<span id="helpBlock2" class="help-block">Passwords don't match. </span>
						</c:when>
						<c:otherwise>
							<div class="form-group">
						</c:otherwise>
					</c:choose>
						<input type="password" class="form-control" id="password2" name="password2" 
						 placeholder="Repeat password" required>
					</div>
					
					<button type="submit" class="btn btn-success">Signup</button>
				</form>
			</div>
		</div>
		
		<c:choose>
			<c:when test="${signupError == 'true'}">
				<br>
				<div class="col-md-6 col-md-offset-3 text-center">
					<div class="alert alert-warning">
						
						<h4>Signup error!</h4>
					</div>
				</div>
			</c:when>
			<c:when test="${signupError == 'alreadyExist'}">
				<br>
				<div class="col-md-6 col-md-offset-3 text-center">
					<div class="alert alert-warning">
						
						<h4>Email alredy exist!</h4>
					</div>
				</div>
			</c:when>
		</c:choose>

</body>
</html>