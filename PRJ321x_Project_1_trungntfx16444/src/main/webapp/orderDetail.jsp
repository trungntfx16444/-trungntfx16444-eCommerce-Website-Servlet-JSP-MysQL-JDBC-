<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap 5.1	 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Order detail page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="orderDetail__content container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Product ID</th>
					<th scope="col">Product name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listP}" var="i">
					<tr>
						<td>${i.id}</td>
						<td>${i.name}</td>
						<td>${i.number}</td>
						<td>${i.price }</td>
						<td>${i.price * i.number}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- bundle Bootstrap 5.1  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>