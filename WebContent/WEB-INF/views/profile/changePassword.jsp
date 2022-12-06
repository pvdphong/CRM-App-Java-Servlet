<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi mật khẩu</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Thay đổi mật khẩu</h4>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material"
					action="<%=request.getContextPath()%>/profile/changepwd"
					method="POST">
					<input type="hidden" name="id" value="${USER.id}" />
					<div class="form-group">
						<label class="col-md-12">Nhập mật khẩu cũ</label>
						<div class="col-md-12">
							<input type="password" class="form-control form-control-line"
								name="oldPassword">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Nhập mật khẩu mới</label>
						<div class="col-md-12">
							<input type="password" class="form-control form-control-line"
								name="newPassword">
						</div>
					</div>
					<span class="text-danger">${ message }</span> <span
						class="text-success">${ success }</span> <br> <br>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Cập nhật</button>
							<a href="<c:url value="/profile" />" class="btn btn-primary">Quay
								lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>