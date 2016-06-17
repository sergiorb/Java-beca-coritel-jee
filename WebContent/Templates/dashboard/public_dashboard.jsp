<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loginapp - Dashboard</title>

<%@ include file="../partials/css_links.html"%>

<style type="text/css">
	.container-fluid {
		margin-top: 2em;
	}
</style>
</head>
<body>

<%@ include file="../partials/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row btns">
			<div class="col-md-8 col-md-offset-2">
				<div class="jumbotron">
					<h1>Login app exercice!</h1>
					<p>A login app exercice made with Java EE, JPA and JSP.</p>
					<p>
						<a class="btn btn-primary btn-lg" href="http://sergiorb.github.io/" role="button">by Sergio Romero Barra</a>
					</p>
				</div>
			</div>
		</div>

	</div>

	<%@ include file="../partials/js_links.html"%>
</body>
</html>