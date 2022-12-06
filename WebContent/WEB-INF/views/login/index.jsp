<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-5 m-auto mt-5">
				<h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
				<div class="p-4 border mt-4">
					<p style="color: red;">${ message }</p>
					<form action="<c:url value="/login"/>" method="POST">
						<div class="form-group">
							<label>Email</label> <input type="email" class="form-control"
								name="email">
						</div>
						<div class="form-group">
							<label>Mật khẩu</label> <input type="password"
								class="form-control" name="password">
						</div>
						<button type="submit" class="btn btn-primary">Đăng nhập</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html> --%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
</head>
<body>
	<div class="login-box">
		<h2>Login</h2>
		<form action="<c:url value="/login"/>" method="POST">
			<div class="user-box">
				<label>Email</label> <input type="email" name="email" required="">
			</div>
			<div class="user-box">
				<label>Password</label> <input type="password" name="password"
					required="">
			</div>
			<span style="color: #03e9f4;">${ message }</span>
			<button type="submit" class="btn btn-primary">
				<span></span> <span></span> <span></span> <span></span> Submit
			</button>
		</form>
	</div>
</body>
</html>