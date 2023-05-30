<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="./css/login.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
	
<style type="text/css">

*{
	box-sizing: border-box;
}

body{
	font-family: Monaco;
	padding: 12px;
	background: #f1f1f1;
}

.container {
	display: block;
	position: relative;
}


.row {
	height: 800px;
	width: 80%;
	position: absolute;
	box-shadow: 5px 10px 18px #888888;
	top: 60px;
}

h1 {
	margin-top: 100px;
	margin-bottom: 50px;
	
}

h3{
	margin-top : 200px;
	margin-bottom: 20px;
	font-size: 35px;
}
#btn-login {
 background-color: #d9480f;
 padding: 12px 50px;
 color: white;
 border-radius: 20px;
 font-size: 20px;
}

.form-check a {
	color: #495057;
	text-decoration: none;
}


/* Home  */
.symbol{
	text-decoration: none;
}

/* Responsive layout - when the screen is less than 800px wide, make the 2 columns stack on top
of each other instead of next to each other */
@media screen and (max-width: 800px) {
	.leftcolumn, .rightcolumn {
	width: 100px;
	padding: 0;
	}
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack
on top of each other instead of next to each other */
@media screen and (max-width: 400px){
	.topnav a {
		float: none;
		width: 100%;
	}
}
.symbol {
	text-decoration: none;
	font-size: 20px;
	color: black;
	padding: 10px 15px;
	
}

a:hover {
	background-color: #e8590c;
	border-radius: 20px;
	color: white;
	
}

.symbol i {
	margin-right: 5px;
}

#home {
	margin-right: 40px;

}
#register {
	margin-left: 20px;
}

button {
	margin-bottom: 25px;
}
</style>	
</head>
<body>


	
	
	<!-- Body -->

	<div class="container text-center">
		<div class="row">
			<!-- LEFT -->
			<div class="col" id="login-side">
				<h1>Admin Register</h1>
				<form action="RegisterServlet" method="post">
				<input type="hidden" name="action" value="register" />
					<div class="mb-3">
						<input class="form-control" name="username"
							 placeholder="Enter UserMail">
					</div>
					<div class="mb-3">
						<input type="password" class="form-control" name="password"
							placeholder="Enter Password">
					</div>
					<div class="mb-3">
						<input type="password" class="form-control" name="repeatpassword"
							placeholder="Enter Repeat Password">
					</div>
					
					<button type="submit" value=login class="btn" id="btn-login">Register</button><br/>
					
					<!-- HOME -->
					
					<a href="ListController" class="symbol" id="home"><i class="bi bi-house-fill"></i>Home</a>
 				    <a href="login.jsp" class="symbol" id="register"><i class="bi bi-ui-checks"></i>Login</a>
				</form>
			</div>

			<!-- RIGHT -->
			<div class="col bg-dark text-white" id="welcome-side">
				<h3>Create New Account Admin!</h3>
				<p><% 
					if(session.getAttribute("error") != null){
						out.println((String) session.getAttribute("error"));
					}else {
						String str = "If you haven't had an account, please new ones!";
						out.println(str);
					}
				 %></p>
			
			</div>

		</div>
	</div>
	
	
	
</body>
</html>