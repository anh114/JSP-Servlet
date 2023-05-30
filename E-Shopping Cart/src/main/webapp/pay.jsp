<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Main CSS -->
<link rel="stylesheet" href="/PRJ321x-A3/css/cart.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
</head>
<body>

	<!-- HEADER -->
	<%@ include file="header.jsp"%>
	
	<!-- MAIN PAY PAGE -->
	
	
		<div class="container">
		<c:set var="total" scope="session" value="${cart.getAmount()}" />
		
		<!-- CUSTOMER INFO -->
		<c:set var="cusemail" scope="session" value="${user}" />
		<c:set var="cusname" scope="session" value="${cusName}" />
		<c:set var="cusaddress" scope="session" value="${cusAddress}" />
		<c:set var="cusphone" scope="session" value="${cusPhone}" />
		<h3 style="color:white; padding:10px 15px; background-color:#2f9e44; width:25%; border-radius:30px; text-align: center" class="mb-4">Order success!</h3>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Customer Name</th>
					<th scope="col">Customer Email</th>
					<th scope="col">Address</th>
					<th scope="col">Phone number</th>
					
				</tr>
			</thead>
				<tbody>
					<tr>
						<td><c:out value="${cusname}"></c:out></td>
						<td><c:out value="${cusemail}"></c:out></td>
						<td><c:out value="${cusaddress}"></c:out></td>
						<td><c:out value="${cusphone}"></c:out></td>
						
					</tr>
				
			</tbody>
		</table>
		

		<div class="d-grid gap-2 d-md-flex justify-content-md-end py-3">
			<h3 style="margin-right: 12px">Total Price: $<c:out value="${total}" /></h3>
			
		</div>
		

	</div>
	
	
		<!-- FOOTER -->
	<%@ include file="footer.jsp"%>

</body>
</html>