<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin cá nhân</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Thông tin cá nhân</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-4 col-xs-12">
			<div class="white-box">
				<div class="user-bg">
					<img width="100%" alt="user" src="${USER.getAvatar()}">
					<div class="overlay-box">
						<div class="user-content">
							<a href="javascript:void(0)"><img src="${USER.getAvatar()}"
								class="thumb-lg img-circle" alt="img" /></a>
							<h4 class="text-white">${USER.fullname}</h4>
							<h5 class="text-white">${USER.email}</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material">
					<div class="form-group">
						<label class="col-md-12">Full Name</label> <span>${USER.fullname}</span>
					</div>
					<div class="form-group">
						<label for="example-email" class="col-md-12">Email</label> <span>${USER.email}</span>
					</div>
					<div class="form-group">
						<label class="col-md-12">Phone No</label> <span>${USER.phone}</span>
					</div>
					<div class="form-group">
						<label class="col-sm-12">Address</label> <span>${USER.address}</span>
					</div>
				</form>
				<a class="btn btn-primary" href="<c:url value="/profile/edit" />"
					role="button">Sửa thông tin cá nhân</a> <a class="btn btn-primary"
					href="<c:url value="/profile/changepwd" />" role="button">Thay
					đổi mật khẩu</a>
			</div>
		</div>
	</div>
</body>
</html>