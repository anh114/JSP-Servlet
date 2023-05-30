<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Main CSS -->
<link rel="stylesheet" href="css/home.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.topnav {
	overflow: hidden;
	background-color: #343a40;
	margin-left: -0.7rem;
	margin-right: -0.7rem;
	height: 60px;
	
}

.topnav a {
	text-decoration: none;
	color: white;
	vertical-align: center;
	margin:15px 25px;
	
	
}

.topnav a:hover {
	color: #f08c00;
}


</style>	
	
</head>
<body>

	<div class="header">
		<!-- Upper -->
		<div class="row g-3 text-bg-dark p-3">
			<!-- PART 1 -->
			<div class="col-3">
				<h2>PRJ321x</h2>
				<h5 id="welcome">Welcome to my Website</h5>
			</div>
			<!-- PART 2: CATEGORIES -->
			<div class="col-2">
				<button class="btn btn-light dropdown-toggle" type="button"
					data-bs-toggle="dropdown">Categories</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">Action</a></li>
					<li><a class="dropdown-item" href="#">Another action</a></li>
					<li><a class="dropdown-item" href="#">Something else here</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="#">Separated link</a></li>
				</ul>
			</div>

			<!--PART 3: SEARCH -->
			<form action="SearchController2" method="post" class="col-7">
				<input type="search" name="s" class="form-control"
					placeholder="What are you looking for?">

			</form>

		</div>
		<!-- BOTTEM -->
		<c:set var="number" scope="session" value="${cart.size()}" />
		<c:set var="user" scope="session" value="${user}" />
		<div class="topnav">
			<a href="ListController" id="home" style="float: left">Home</a> 
			<a href="#" style="float: left">Products</a>
			<a href="#" style="float: left">About us</a>

			<c:if test="${user == null}">
				<a href="login.jsp" style="float: right">Login</a>
			</c:if>
			<c:if test="${user != null}">
				<a href="/PRJ321x-A3/LogoutController?logout=ok"
					style="float: right">Logout</a>
			</c:if>

			<a href="register.jsp" style="float: right" >Admin</a> <a
				href="cusreg.jsp" style="float: right" >Register</a> 
			<c:if test="${user != null}">	
				<a
				href="cart.jsp" style="float: right" class="position-relative">Cart
				<span
				class="badge rounded-pill bg-danger position-absolute top-10 start-80"><c:out
						value="${number}" /> </span>
				</a>
			</c:if>

		</div>
	</div>



</body>
</html>