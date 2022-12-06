<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa thông tin</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Sửa thông tin</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material"
					action="<%=request.getContextPath()%>/user/edit" method="POST">
					<input type="hidden" name="id" value="${user.id}" /> <input
						type="hidden" name="avatar" value="${ user.avatar }">
					<div class="form-group">
						<label class="col-md-12">Full Name</label>
						<div class="col-md-12">
							<input type="text" value="${user.fullname }"
								class="form-control form-control-line" name="fullname">
						</div>
					</div>
					<div class="form-group">
						<label for="example-email" class="col-md-12">Email</label>
						<div class="col-md-12">
							<input type="email" value="${user.email}"
								class="form-control form-control-line" name="email"
								id="example-email">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Phone No</label>
						<div class="col-md-12">
							<input type="text" value="${ user.phone }"
								class="form-control form-control-line" name="phone">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-12">Address</label>
						<div class="col-md-12">
							<input type="text" value="${user.address }"
								class="form-control form-control-line" name="address">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-12">Select Role</label>
						<div class="col-sm-12">
							<select class="form-control form-control-line" name="role">
								<option value="${ user.role_id }" selected hidden>${ user.roleName }</option>
								<c:forEach var="item" items="${roles}">
									<option value="${item.id }">${item.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Update
								user</button>
							<a href="<c:url value="/user" />" class="btn btn-primary">Quay
								lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>