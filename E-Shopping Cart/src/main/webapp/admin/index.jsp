<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" />

<!-- Bootstrap Font Icon CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
<link rel="stylesheet" href="/PRJ321x-A3/css/index.css" />


</head>
<body>

	<div class="sidebar">
		<header>1849 Team</header>
		<ul>
			<li><a href="#"><i class="fa fa-desktop"></i>Dashboard</a></li>
			<li><a href="#"><i class="fa fa-user-o"></i>Staff Member</a></li>
		</ul>
	</div>

	<!-- BANNER -->
		<div class="hero">
			<div>
				<img alt="banner" src="${pageContext.request.contextPath}/media/banner.png" id="banner" />
				<a href="/PRJ321x-A3/LogoutController?logout=ok">Logout</a>
			</div>
		</div>
		
		
		<!-- MEMBERS Info -->
		<div class="member-info">
			<% String username = (String) session.getAttribute("user");
				String[] parts = username.split("@");	
				String result = parts[0];
			%>
			<p id="members">Welcome <b><%= result %></b> !</p>
			
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Student ID</th>
						<th scope="col">Class</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Member 1</td>
						<td>Member Code 1</td>
						<td>Class 1</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Member 2</td>
						<td>Member Code 2</td>
						<td>Class 2</td>
					</tr>

				</tbody>
			</table>
		</div>


</body>
</html>