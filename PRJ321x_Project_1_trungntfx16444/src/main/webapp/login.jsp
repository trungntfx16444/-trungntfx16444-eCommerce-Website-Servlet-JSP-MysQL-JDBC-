<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- bootstrap 5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- font awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" />

<!-- main css -->
<link rel="stylesheet" href="./css/main.css" />

<title>Login</title>
</head>
<body>
	<div class="main">
		<div class="login__content  border border-5 row">
			<div class="left__content col-sm-6">
				<div class="text-center">
					<h2 class="fw-bold">Sign in</h2>
				</div>

				<!-- auto fill data when click remember me --> 
				<%
					String user = "", pass="", remember="";
					String error = (String)session.getAttribute("error");
					Cookie[] cookies = request.getCookies();
					if(cookies != null){
						for(Cookie c : cookies){
							if(c.getName().equals("userCookie")){
								user= c.getValue();	
							}else if(c.getName().equals("rememberCookie")){
								remember = c.getValue();
							}
						}
					}
				%>
				<form class="login__form bg-white" action="login" method="post"
					name="myForm">
					<!-- create variable mess => when login fail -> show mess -->
					<p class="text-danger text-center">${error}</p>

					<div class="mb-3">
						<input type="text" class="form-control" id="exampleInputUsername"
							placeholder="Email" name="username" value="<%= remember.equals("1")&& error == null ? user : ""%>">
					</div>
					<div class="mb-3">
						<input type="password" class="form-control"
							id="exampleInputPassword1" placeholder="Password" name="password">

					</div>
					<div class="mb-1 form-check bg-white">
						<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember" value="1">
						<label class="form-check-label bg-white" for="exampleCheck1">Remember me</label>
					</div>
					<a href="#" class="text-center bg-white nav-link">Forgot your password</a>
					<div class="d-grid gap-2">
						<button class="btn__login btn btn-danger" type="submit">Login</button>
					</div>
				</form>
			</div>
			<div class="right__content col-sm-6">
				<div>
					<h2 class="fw-bold text-center ">Welcome Back!</h2>
					<p class="text-center">
						To keep connect with us <br /> please login with your personal <br />
						info
					</p>
				</div>
			</div>
		</div>
	</div>



	<!-- bootstrap 5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
		
	</script>

	<!-- main js  -->
	<script src="./assets/main.js"></script>

</body>
</html>
