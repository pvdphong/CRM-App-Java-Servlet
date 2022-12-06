<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách công việc</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách công việc</h4>
		</div>
		<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
			<a href='<c:url value="/task/add" />' class="btn btn-sm btn-success">Thêm
				mới</a>
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
								<th>STT</th>
								<th>Tên Công Việc</th>
								<th>Dự Án</th>
								<th>Người Thực Hiện</th>
								<th>Ngày Bắt Đầu</th>
								<th>Ngày Kết Thúc</th>
								<th>Trạng Thái</th>
								<th>Hành Động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${ tasks }">
								<tr>
									<td>${item.id }</td>
									<td>${item.name }</td>
									<td>${item.job_name }</td>
									<td>${item.user_name }</td>
									<td class="dateId">${item.start_date }</td>
									<td class="dateId">${item.end_date }</td>
									<td>${item.status_name }</td>
									<td><a href="<c:url value="/task/edit?id=${item.id}"/>"
										class="btn btn-sm btn-primary">Sửa</a> <a
										href='<c:url value="/task/delete?id=${item.id}"/>'
										class="btn btn-sm btn-danger">Xóa</a> <a
										href="<c:url value="/task/detail?id=${item.id}"/>"
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