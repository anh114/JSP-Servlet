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
</head>
<body>

<%
//get user from cookie
		Cookie arr[] = request.getCookies();
		String uname ="";

		if(arr != null) {
			
			for(Cookie co: arr) {
				if(co.getName().equals("userCook")) {
					uname = co.getValue();
				}
				
			}
		}



%>

	<div class="container text-center">
		<div class="row">
			<!-- LEFT -->
			<div class="col" id="login-side">
				<h1>Sign in</h1>
				<form action="login" method="post">
					<div class="mb-3">
						<input class="form-control" name="username" value="<%=uname %>"
							 placeholder="Enter Username">
					</div>
					<div class="mb-3">
						<input type="password" class="form-control" name="password"
							placeholder="Enter Password">
					</div>
					<div class="form-check mb-4 d-flex justify-content-between">
						<div>
						<input type="checkbox" name="chkRemember" value="ON">
						<label>Remember me</label>
						</div>
						<a href="#">Forgot your password?</a>
					</div>

					
					<button type="submit" value=login class="btn" id="btn-login">Login</button>
				</form>
			</div>

			<!-- RIGHT -->
			<div class="col bg-dark text-white" id="welcome-side">
				<h3>Welcome Back!</h3>
				<p><% 
					if(session.getAttribute("error") != null){
						out.println((String) session.getAttribute("error"));
					}else {
						String str = "To keep connected with us please login with your personal info";
						out.println(str);
					}
				 %></p>
			
			</div>

		</div>
	</div>



</body>
</html>