<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

<title>Detail page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="detail__content">
		<div class="detail__title container">
			<h2>${p.name}</h2>
		</div>
		<div class="container">
			<div class="row">
				<div class="detail__left col-md-5">
					<img src="${p.src}" alt="img ${p.name}" class="w-100" />
				</div>
				<div class="detail__right col-md-7">
					<h2 class="detail__price text-danger">
						<fmt:formatNumber value="${p.price * 300000}" type="currency" />
					</h2>
					<p class="detail__description w-50">Product Description:
						${p.description}</p>
					<a type="button" class="btn btn-warning" href="Cart?id=${p.id}&action=add">Add to cart</a>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>


	<!-- bundle Bootstrap 5.1  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>