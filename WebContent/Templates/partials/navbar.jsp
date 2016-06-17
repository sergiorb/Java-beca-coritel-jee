<nav class="navbar navbar-dark bg-inverse">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/">Loginapp</a>
	<ul class="nav navbar-nav">
		<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/">Home
				<span class="sr-only">(current)</span>
		</a></li>
		<li class="nav-item">
		<c:choose>
			<c:when test="${logged != 'true'}">
				<a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
			</c:when>
			<c:when test="${logged == 'true'}">
				<form class="btn-loguot" action="${pageContext.request.contextPath}/logout" method="post">
					<button type="submit" class="btn btn-danger">Logout</button>
				</form>
			</c:when>
		</c:choose>
		
		</li>
		
		<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/signup">Signup</a></li>
	</ul>
</nav>
