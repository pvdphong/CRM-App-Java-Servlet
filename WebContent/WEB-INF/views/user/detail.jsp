<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Chi tiết thành viên</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-4 col-xs-12">
			<div class="white-box">
				<div class="user-bg">
					<img width="100%" alt="user" src="${user.getAvatar()}">
					<div class="overlay-box">
						<div class="user-content">
							<a href="javascript:void(0)"><img src="${user.getAvatar()}"
								class="thumb-lg img-circle" alt="img"></a>
							<h4 class="text-white">${user.fullname}</h4>
							<h5 class="text-white">${user.email}</h5>
						</div>
					</div>
				</div>
				<div class="user-btm-box">
					<div class="col-md-4 col-sm-4 text-center ">
						<p class="text-purple">
							<i class="ti-facebook"></i>
						</p>
						<h4 class="text-danger">${chuaThucHien}%</h4>
						<h6 class="text-danger font-weight-bold">Chưa thực hiện</h6>
					</div>
					<div class="col-md-4 col-sm-4 text-center">
						<p class="text-blue">
							<i class="ti-twitter"></i>
						</p>
						<h4 class="text-megna">${dangThucHien }%</h4>
						<h6 class="text-megna font-weight-bold">Đang thực hiện</h6>
					</div>
					<div class="col-md-4 col-sm-4 text-center">
						<p class="text-danger">
							<i class="ti-dribbble"></i>
						</p>
						<h4 class="text-primary">${daHoanThanh }%</h4>
						<h6 class="text-primary font-weight-bold">Hoàn thành</h6>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material">
					<div class="form-group">
						<label class="col-md-12">Full Name</label> <span>${user.fullname}</span>
					</div>
					<div class="form-group">
						<label for="example-email" class="col-md-12">Email</label> <span>${user.email}</span>
					</div>
					<div class="form-group">
						<label class="col-md-12">Phone No</label> <span>${user.phone}</span>
					</div>
					<div class="form-group">
						<label class="col-sm-12">Address</label> <span>${user.address}</span>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br />
	<!-- /.row -->
	<!-- BEGIN DANH SÁCH CÔNG VIỆC -->

	<h4 style="color: #7F7F7F; font-weight: bold;">Danh sách công việc</h4>
	<div class="row">
		<div class="col-md-4">
			<div class="white-box">
				<h3 class="box-title text-danger">Chưa thực hiện</h3>
				<div class="message-center">
					<c:forEach var="task" items="${taskChuaThucHien }">
						<a href="<c:url value="/task/detail?id=${task.id}" />">
							<div class="mail-contnet">
								<h5>${task.job_name }</h5>
								<span class="mail-desc">${task.name}</span> <span class="time">End
									date: <span class="dateId">${task.end_date }</span>
								</span>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="white-box">
				<h3 class="box-title text-megna">Đang thực hiện</h3>
				<div class="message-center">
					<c:forEach var="task" items="${taskDangThucHien }">
						<a href="<c:url value="/task/detail?id=${task.id}" />">
							<div class="mail-contnet">
								<h5>${task.job_name }</h5>
								<span class="mail-desc">${task.name}</span> <span class="time">End
									date: <span class="dateId">${task.end_date }</span>
								</span>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="white-box">
				<h3 class="box-title  text-primary">Đã hoàn thành</h3>
				<div class="message-center">
					<c:forEach var="task" items="${taskDaHoanThanh }">
						<a href="<c:url value="/task/detail?id=${task.id}" />">
							<div class="mail-contnet">
								<h5>${task.job_name }</h5>
								<span class="mail-desc">${task.name}</span> <span class="time">End
									date: <span class="dateId">${task.end_date }</span>
								</span>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!-- END DANH SÁCH CÔNG VIỆC -->
</body>
</html>