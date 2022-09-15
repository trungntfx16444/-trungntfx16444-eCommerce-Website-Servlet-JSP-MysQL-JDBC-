<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="../css/main.css" />

<title>Admin page</title>
</head>
<body>
	<div class="admin__content">
		<div class="container">
			<div class="row">
				<div class="left__content col-3">
					<h4 class="title__welcome">Welcome ${user}</h4>
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link" href="#"> <i
								class="fa fa-th-large"></i><span>Dashboard</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">
							<i class="fa fa-user"></i><span>Staff Manager</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="/PRJ321x_Project_1_trungntfx16444/logout">
							<i class="fa fa-sign-out-alt"></i><span>Logout</span>
						</a></li>
					</ul>
				</div>
				<div class="right__content col-9">
					<img src="../media/bg-dashboard.png" alt="dashboard" class="img-fluid" />
					<h5 class="table__title">Member of team</h5>
					<table class="table table-dark table-striped">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Name</th>
								<th scope="col">Student ID</th>
								<th scope="col">Class</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>member 1</td>
								<td>member code 1</td>
								<td>class 1</td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>member 2</td>
								<td>member code 2</td>
								<td>class 2</td>
							</tr>
						</tbody>
					</table>
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