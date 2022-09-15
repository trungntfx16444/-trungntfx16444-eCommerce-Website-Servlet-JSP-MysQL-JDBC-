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

<title>Body page</title>
</head>
<body>
	<div class="body__content">
		<div class="container">
			<div class="row">
				<div class="left__column ms-2 col-12 col-md-8 row">
						<h4 class="text-danger ${padding}">${mess}</h4>
					<c:forEach items="${listP}" var="p">
						<div class="left__item col-md-5 col-lg-4">
							<div class="card" style="width: 100%; padding-top: 20px;">
								<a href="Detail?id=${p.id}"> <img src="${p.src}"
									class="card-img-top bg-white" alt="iphone 13">
								</a>
								<div class="card-body">
									<h5 class="card-title bg-white text-uppercase">${p.type}</h5>
									<p class="card-text bg-white">${p.name}</p>
									<span class="fw-bold text-danger bg-white">${p.price} $</span>
								</div>
							</div>
						</div>
					</c:forEach>
					<div
						class="my__pagination mt-3 d-flex justify-content-center ${hidden}">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href=""
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach begin="1" end="${endPage}" var="i">
									<li class="page-item"><a class="page-link"
										href="Home?index=${i}">${i}</a></li>
								</c:forEach>
								<li class="page-item"><a class="page-link" href=""
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="right__column col-12 col-md-4">
				</div>
			</div>
		</div>
	</div>


	<!-- bundle Bootstrap 5.1  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>