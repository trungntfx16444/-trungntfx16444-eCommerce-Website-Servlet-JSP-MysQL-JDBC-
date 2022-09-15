<%@page import="model.Account"%>
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

<!-- font awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
	integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- main css -->
<link rel="stylesheet" href="./css/main.css" />

<title>Header page</title>
</head>
<body>
	<div class="header ">
		<div class="container">
			<div class="row align-items-center">
				<div class="header__left p-0 col-md-4">
					<div class="my__logo">
						<nav class="navbar p-0 ">
							<div class="container justify-content-start">
								<i class="fa fa-mobile-alt me-2"></i>
								<h1>CellphoneVN</h1>
							</div>
						</nav>
					</div>
				</div>
				<div class="header__right col-md-8">
					<form class="d-flex" action="Search" method="post">
						<div class="dropdown">
							<button class="btn btn-light dropdown-toggle" type="button"
								id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false">Categories</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="#">CELLPHONE</a></li>
							</ul>
						</div>
						<input name="searchValue" class="form-control" type="search"
							placeholder="Search" aria-label="Search" value="${search}">
						<button class="btn btn-danger" type="submit">Search</button>
					</form>
				</div>

			</div>
		</div>
		<div class="my__navbar ">
			<nav class="navbar navbar-expand-lg p-0">
				<div class="container">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="Home">Home</a></li>
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="#">Produce</a></li>
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="#">About us</a></li>
						</ul>
						<c:if test="${acc == null}">
						<a class="login" href="./login.jsp">Login</a>
						<a class="login" href="./register.jsp">Register</a>
						</c:if>
						<c:if test="${acc != null}">
							<a class="login" href="History">Welcome ${acc.usr}</a>
							<a class="login" href="cart.jsp">Cart</a>
							<a class="login" href="logout">Logout</a>
						</c:if>
					</div>
				</div>
			</nav>
		</div>
	</div>




	<!-- bundle Bootstrap 5.1  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>