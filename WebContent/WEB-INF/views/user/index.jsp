<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thành viên</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách thành viên</h4>
		</div>
		<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
			<a href="<%=request.getContextPath()%>/user/add"
				class="btn btn-sm btn-success">Thêm mới</a>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /row -->
	<div class="row">
		<div class="col-sm-12">
			<div class="white-box">
				<div class="table-responsive">
					<table class="table" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Fullname</th>
								<th>Email</th>
								<th>phone</th>
								<th>Role</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${users}">
								<tr>
									<td>${item.id }</td>
									<td>${item.fullname }</td>
									<td>${item.email }</td>
									<td>${item.phone }</td>
									<td>${item.roleName }</td>
									<td><c:if test="${USER.roleName == 'ROLE_ADMIN' }">
											<a href="<c:url value="/user/edit?id=${item.id}"/>"
												class="btn btn-sm btn-primary">Sửa</a>
											<a href="<c:url value="/user/delete?id=${item.id}"/>"
												class="btn btn-sm btn-danger">Xóa</a>
										</c:if> <a href="<c:url value="/user/detail?id=${item.id}"/>"
										class="btn btn-sm btn-info">Xem</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>