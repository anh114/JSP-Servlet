<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
	
<style>
.card {
	background-color: white;
	padding: 20px;
	margin-top: 30px;
	padding: 1rem;
}

</style>
</head>
<body>
<!-- HEADER -->
<%@ include file ="header.jsp" %>

	<!-- PRODUCT Display -->
	<div class="container text-center pb-5">
		<div class="row" >

		<!-- Product List-->
		
		<div class="col">
			<div class="row">
			<c:forEach items="${products}" var="o">
		
				<div class="card" style="width: 18rem; margin: 30px;">
					<img src="${o.src}" class="card-img-top"
						alt="ip14">
					<div class="card-body">
						<h5 class="card-title">${o.brand}</h5>
						<p class="card-text">${o.name}</p>
						<a href="InformationProductController?id=${o.id}" class="btn btn-primary">$${o.price}</a>
					</div>
				</div>
				</c:forEach>
			</div>
			
		</div>
	</div>

</div>

<!-- FOOTER -->
<%@ include file = "footer.jsp" %>	

</body>
</html>