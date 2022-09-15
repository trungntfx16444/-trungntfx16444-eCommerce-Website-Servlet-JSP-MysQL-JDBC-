<%@page import="model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<!-- Main css -->
<link rel="stylesheet" href="./main.css" />
<title>Cart page</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="cart__content container w-80">
		<section class="h-100" style="background-color: #eee;">
			<div class="container h-100 py-5">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-10">
						<div
							class="d-flex justify-content-between align-items-center mb-4">
							<h3 class="fw-normal mb-0 text-black">Product in cart:
								${cart.countItems()}</h3>
						</div>
						<c:forEach items="${cart.items}" var="i">
							<div class="card rounded-3 mb-4">
								<div class="card-body p-4">
									<div
										class="row d-flex justify-content-between align-items-center">
										<div class="col-md-2 col-lg-2 col-xl-2">
											<img src="${i.src}" class="img-fluid rounded-3"
												alt="img ${i.name}">
										</div>
										<div class="col-md-3 col-lg-3 col-xl-3">
											<p class="lead fw-normal mb-2">${i.name}</p>
										</div>
										<div class="col-md-3 col-lg-3 col-xl-2 d-flex">
											<a href="Cart?id=${i.id}&action=reduce"
												class="btn btn-link px-2"> <i class="fas fa-minus"></i>
											</a> <input id="form1" min="0" name="quantity"
												value="${i.number}" type="number"
												class="form-control form-control-sm" /> <a
												href="Cart?id=${i.id}&action=increase"
												class="btn btn-link px-2"> <i class="fas fa-plus"></i>
											</a>
										</div>
										<div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
											<h5 class="mb-0">
												<fmt:formatNumber value="${i.price * i.number*300000}"
													type="currency" />
											</h5>
										</div>
										<div class="col-md-1 col-lg-1 col-xl-1 text-end">
											<a href="Cart?id=${i.id}&action=del" class="text-danger"><i
												class="fas fa-trash fa-lg"></i></a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="card mb-4">
							<div class="card-body p-3 d-flex flex-row">
								<div class="form-outline flex-fill fw-bold text-end">
									<p class="mb-0 text-danger display-6">
										Total:
										<fmt:formatNumber value="${cart.getAmount()* 300000}" type="currency" />
									</p>
								</div>
							</div>
						</div>
						<form action="Order" method="post">
							<div class="card mb-4">
								<div class="card-body p-4 d-flex flex-row">
									<div class="form-outline flex-fill">
										<input type="text" id="form1"
											class="form-control form-control-lg" name="name" value="${acc.name}" /> <label
											class="form-label" for="form1">Customer name</label>
									</div>
								</div>
								<div class="card-body p-4 d-flex flex-row">
									<div class="form-outline flex-fill">
										<input type="text" id="form1"
											class="form-control form-control-lg" name="address" value="${acc.address}"/> <label
											class="form-label" for="form1">Customer address</label>
									</div>
								</div>
								<div class="card-body p-4 d-flex flex-row">
									<div class="form-outline flex-fill">
										<input type="text" id="form1"
											class="form-control form-control-lg" name="discound" /> <label
											class="form-label" for="form1" >Discound code (if any)</label>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-body">
									<button type="submit"
										class="btn btn-warning btn-block btn-lg">Proceed to Pay</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

	<!-- bundle Bootstrap 5.1  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>