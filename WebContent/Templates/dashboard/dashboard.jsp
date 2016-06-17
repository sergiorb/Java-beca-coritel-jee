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
.user {
	margin-top: 2em;
}
.btn-loguot {
	padding-top: 10px;
	padding-bottom: 15px;
}
</style>
</head>
<body>
	<div class="container-fluid">
	
		<%@ include file="../partials/navbar.jsp"%>

		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-primary">
					<div class="panel-heading"><strong><i class="fa fa-user fa-lg fa-fw" aria-hidden="true"></i></strong> ${reader.userName}</div>
					<div class="panel-body">
						<p><i class="fa fa-envelope-o fa-lg fa-fw" aria-hidden="true"></i>
							${reader.email}
						</p>
						<p><i class="fa fa-globe fa-lg fa-fw" aria-hidden="true"></i> <a
							href="${reader.websiteUrl}">${reader.websiteUrl}</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<c:forEach items="${reader.books}" var="book">

					<div class="panel panel-info">
						<div class="panel-heading"><strong>Book:</strong> ${book.name}</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-6">
									<p>
										<strong>ISBN:</strong> ${book.isbn_10}
									</p>
								</div>
								<div class="col-md-6">
									<p>
										<strong>Pages count:</strong> ${book.pagesCount}
									</p>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<p><strong>Authors:</strong></p>
									<c:forEach items="${book.authors}" var="author">
										<p><strong> - Name:</strong> ${author.firstName} ${author.lastName}</p>
									</c:forEach>
								</div>
								<div class="col-md-6">
									<p><strong>Keywords:</strong></p>
									<c:forEach items="${book.keywords}" var="keywords">

										<p> - ${keywords.value}</p>

									</c:forEach>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
		</div>
	</div>
	
	<%@ include file="../partials/js_links.html"%>
	
</body>
</html>