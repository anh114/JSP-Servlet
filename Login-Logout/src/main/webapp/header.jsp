<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</head>
<body>

	<div class="header">
		<!-- Upper -->
		<div class="row text-bg-dark p-3">
			<div class="col-3">
				<h2>PRJ321x</h2>
				<h5 id="welcome">Welcome to my Website</h5>
			</div>
			<div class="col-9">
				<div class="input-group mb-3 ">
					<button class="btn btn-light dropdown-toggle" type="button"
						data-bs-toggle="dropdown">Categories</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Separated link</a></li>
					</ul>

					<input class="form-control" type="search"
						placeholder="What are you looking for?">
					<button type="submit" id="btn-search"><i class="fa fa-search"></i></button>


				</div>
			</div>
		</div>
		<!-- BOTTEM -->
		<div class="topnav">
			<a href="#" id="home">Home</a> <a href="#">Products</a> <a href="#">About
				us</a> <a href="login.jsp" style="float: right">Login</a>
		</div>
	</div>



</body>
</html>