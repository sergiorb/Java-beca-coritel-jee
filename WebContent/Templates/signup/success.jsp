<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loginapp - Signup</title>

<%@ include file="../partials/css_links.html"%>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 text-center">
				<h1>Signup Page</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-center">
				<h2>Signup succeed <span class="text-success"><strong>${reader.userName}</strong><span>!</h2>
			</div>
		</div>
	</div>

</body>
</html>