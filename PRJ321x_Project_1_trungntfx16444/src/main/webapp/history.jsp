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
<!-- main css -->
<link rel="stylesheet" href="./css/main.css" />
<title>History Page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="history__content container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Order ID</th>
					<th scope="col">Order Status</th>
					<th scope="col">Create</th>
					<th scope="col">Detail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lo}" var="l">
					<tr>
						<th scope="row">${l.orderID}</th>
						<td><c:if test="${l.status == 0}">
								delivery
							</c:if> <c:if test="${l.status == 1}">
								Done
							</c:if></td>
						<td>${l.orderDate}</td>
						<td>
							<a class="btn btn-primary" href="OrderDetail?id=${l.orderID}">Show detail</a>
						</td>
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