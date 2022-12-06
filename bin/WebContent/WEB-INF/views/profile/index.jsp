<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thống kê công việc</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Thống kê công việc</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-4 col-xs-12">
			<div class="white-box">
				<div class="user-bg">
					<img width="100%" alt="user"
						src="/CrmApp/static/plugins/images/large/img1.jpg">
					<div class="overlay-box">
						<div class="user-content">
							<a href="javascript:void(0)"><img
								src="/CrmApp/static/plugins/images/users/genu.jpg"
								class="thumb-lg img-circle" alt="img"></a>
							<h4 class="text-white">${USER.fullname }</h4>
							<h5 class="text-white">${USER.email }</h5>
						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="col-md-8 col-xs-12">
			<!-- BEGIN THỐNG KÊ -->
			<div class="row">
				<!--col -->
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="white-box">
						<div class="col-in row">
							<div class="col-xs-12">
								<h3 class="counter text-right m-t-15 text-danger">${chuaThucHien}%</h3>
							</div>
							<div class="col-xs-12">
								<i data-icon="E" class="linea-icon linea-basic"></i>
								<h5 class="text-muted vb text-center">CHƯA THỰC HIỆN</h5>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="progress">
									<div class="progress-bar progress-bar-danger"
										role="progressbar" aria-valuenow="40" aria-valuemin="0"
										aria-valuemax="100" style="width: ${chuaThucHien}%"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
				<!--col -->
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="white-box">
						<div class="col-in row">
							<div class="col-xs-12">
								<h3 class="counter text-right m-t-15 text-megna">${ dangThucHien }%</h3>
							</div>
							<div class="col-xs-12">
								<i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
								<h5 class="text-muted vb text-center">ĐANG THỰC HIỆN</h5>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="progress">
									<div class="progress-bar progress-bar-megna" role="progressbar"
										aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
										style="width: ${ dangThucHien }%"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
				<!--col -->
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="white-box">
						<div class="col-in row">
							<div class="col-xs-12">
								<h3 class="counter text-right m-t-15 text-primary">${daHoanThanh}%</h3>
							</div>
							<div class="col-xs-12">
								<i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
								<h5 class="text-muted vb text-center">HOÀN THÀNH</h5>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="progress">
									<div class="progress-bar progress-bar-primary"
										role="progressbar" aria-valuenow="40" aria-valuemin="0"
										aria-valuemax="100" style="width: ${daHoanThanh}%"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- END THỐNG KÊ -->

		</div>
	</div>
	<br />
	<!-- /.row -->
	<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
	<h4>DANH SÁCH CÔNG VIỆC</h4>
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
									<td class="dateId">${item.start_date }</td>
									<td class="dateId">${item.end_date }</td>
									<td>${item.status_name}</td>
									<td><a href="<c:url value="/profile/edit?id=${item.id}"/>"
										class="btn btn-sm btn-primary">Cập nhật</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- END DANH SÁCH CÔNG VIỆC -->
</body>
</html>