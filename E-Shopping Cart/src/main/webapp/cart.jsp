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

	
	
	<c:set var="checkLogin" value="${request.getCookies}"></c:set>

	<!-- HEADER -->
	<%@ include file="header.jsp"%>

	<!-- CART -->
	<div class="container">
		<c:set var="total" scope="session" value="${cart.getAmount()}" />

		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Total</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.cart.getItems()}" var="o">
					<tr>
						<td>${o.name}</td>
						<td>$${o.price}</td>
						<td>
							<form action="add-to-cart" method="post">
								<input type="hidden" name="cart" value="1" class="inpnut">
								<div class="form-group d-flex w-50">
									<a class="btn btn-sm btn-incre" href="quantity-inc-dec?action=dec&id=${o.id}"><i
										class="bi bi-dash-circle"></i></a> 
									<input type="text"
										name="quantity" class="form-control w-50" value="${o.number}"
										readonly> 
									<a class="btn btn-sm btn-incre" href="quantity-inc-dec?action=inc&id=${o.id}"><i
										class="bi bi-plus-circle"></i></a>
								</div>
							</form>
						</td>
						<td>${o.totalPrice()}</td>
						<td>
							<form action="add-to-cart" method="post">
								<input type="hidden" name="action" value="delete"> <a
									class="btn btn-sm btn-danger" href="add-to-cart?action=delete&id=<c:out value="${o.id}"/>">Delete</a>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
		<%	String username = (String) session.getAttribute("user");
		String name;
		if(username != null) {
			String[] parts = username.split("@");	
			name = parts[0];
		 %>
		 <h3>Welcome <%=name %>!</h3>
		 
		 <%} %>
		
		
		
		</div>

		<div class="d-grid gap-2 d-md-flex justify-content-md-end py-3">
			<h3 style="margin-right: 12px">Total Price: $<c:out value="${total}" /></h3>
			<a href="PayController?deleteCart=ok" class="btn btn-primary me-md-2" type="submit">Submit</a>
		</div>
		

	</div>


	<!-- FOOTER -->
	<%@ include file="footer.jsp"%>


</body>
</html>