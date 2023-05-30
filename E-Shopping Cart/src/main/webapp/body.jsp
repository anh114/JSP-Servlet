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
</head>
<body>

<!-- HEADER -->
<%@ include file ="./header.jsp" %>
<c:set var="page" scope="request" value="${page}"></c:set>
<c:set var="numberPage" scope="request" value="${numberPage}"></c:set>

	<!-- PRODUCT Display -->
	<div class="container text-center">
		<div class="row" >

		<!-- Product List-->
		
		<div class="col">
			<div class="row">
			<c:if test="${products !=null}">
				<c:forEach items="${products}" var="o">		
						<div class="card" style="width: 18rem; margin: 2rem">
							<img src="${o.src}" class="card-img-top"
								alt="ip14">
							<div class="card-body">
								<h5 class="card-title">${o.brand}</h5>
								<p class="card-text">${o.name}</p>
								<a href="InformationProductController?id=${o.id}" class="btn btn-primary">$${o.price}</a>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
			
		</div>
	</div>

</div>
	<!-- PAGINATION -->

	<nav style="padding: 2rem;">
		<ul class="pagination justify-content-center">
		
			<c:forEach begin="${1}" end="${requestScope.numberPage}" var="i"> 
				<li class="page-item"><a class="page-link" href="ListController?page=${i}">${i}</a></li>
			</c:forEach>

		</ul>
	</nav>
	
	
<!-- FOOTER -->
<%@ include file = "./footer.jsp" %>	


</body>
</html>