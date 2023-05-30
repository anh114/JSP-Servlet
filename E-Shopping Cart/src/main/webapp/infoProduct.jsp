<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/css/home.css">

</head>
<body>

	<!-- HEADER -->
	<%@ include file="header.jsp"%>

	<!-- Info Product -->
	<div class="container">

		<!-- PRODUCT ? -->
		<div class="row">
			<c:set var="id" scope="session" value="${product.id}" />
			<c:set var="user" scope="session" value="${user}" />
				<div class="col-10 pb-2" style="font-size: 25px; color: #495057">${product.name}</div>
				<span style="border-top: 1px solid #adb5bd" class="pb-5"></span>
				<!-- LEFT: Image -->
				<div class="col-4">
					<img src="${product.src}" class="card-img-top mb-5" alt="ip14">
				</div>
				<!-- RIGHT: Product detail -->
				<div class="col-6">
					<h2 style="color: #f03e3e" class="pt-2">$${product.price}</h2>
					<span>${product.description}</span> <br/>
					
				<c:if test="${user != null}">
				<a href="add-to-cart?action=add&id=<c:out value="${id}"/>"><button type="button" class="btn btn-warning mt-4">Add to Cart</button></a>
				</c:if>
				<c:if test="${user == null}">
				<a href="login.jsp"><button type="button" class="btn btn-warning mt-4">Login</button></a>
				</c:if>
				
									
				</div>
	
		</div>

	</div>


	<!-- FOOTER -->
	<%@ include file="footer.jsp"%>

</body>
</html>