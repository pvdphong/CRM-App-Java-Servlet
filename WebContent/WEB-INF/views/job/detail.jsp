<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết dự án</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">${job.name }</h4>
		</div>
	</div>
	<!-- BEGIN THỐNG KÊ -->
	<div class="row">
		<!--col -->
		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
			<div class="white-box">
				<div class="col-in row">
					<div class="col-md-6 col-sm-6 col-xs-6">
						<i data-icon="E" class="linea-icon linea-basic"></i>
						<h5 class="vb text-danger">CHƯA THỰC HIỆN</h5>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-6">
						<h3 class="counter text-right m-t-15 text-danger">${chuaTH }%</h3>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="progress">
							<div class="progress-bar progress-bar-danger" role="progressbar"
								aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
								style="width: ${chuaTH }%"></div>
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
					<div class="col-md-6 col-sm-6 col-xs-6">
						<i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
						<h5 class="vb text-megna">ĐANG THỰC HIỆN</h5>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-6">
						<h3 class="counter text-right m-t-15 text-megna">${dangTH }%</h3>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="progress">
							<div class="progress-bar progress-bar-megna" role="progressbar"
								aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
								style="width: ${dangTH }%"></div>
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
					<div class="col-md-6 col-sm-6 col-xs-6">
						<i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
						<h5 class="vb text-primary">ĐÃ HOÀN THÀNH</h5>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-6">
						<h3 class="counter text-right m-t-15 text-primary">${daHT }%</h3>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="progress">
							<div class="progress-bar progress-bar-primary" role="progressbar"
								aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
								style="width: ${ daHT }%"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.col -->
	</div>
	<!-- END THỐNG KÊ -->

	<!-- BEGIN DANH SÁCH CÔNG VIỆC -->
	<div class="row">
		<div class="col-xs-12">
			<a href="#" class="group-title">
				<h4 style="color: #7F7F7F; font-weight: bold;">Chi tiết dự án</h4>
			</a>
		</div>
		<div class="col-md-4">
			<div class="white-box">
				<h3 class="box-title text-danger">Chưa thực hiện</h3>
				<div class="message-center">
					<c:forEach var="task" items="${chuaThucHien }">
						<a href="<c:url value="/task/detail?id=${task.id}" />">
							<div class="mail-contnet">
								<h5>${task.user_name }</h5>
								<span class="mail-desc">${task.name }</span> <span class="time">End
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
					<c:forEach var="task" items="${dangThucHien }">
						<a href="<c:url value="/task/detail?id=${task.id}" />">
							<div class="mail-contnet">
								<h5>${task.user_name }</h5>
								<span class="mail-desc">${task.name }</span> <span class="time">End
									Date: <span class="dateId">${task.end_date }</span>
								</span>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="white-box">
				<h3 class="box-title text-primary">Đã hoàn thành</h3>
				<div class="message-center">
					<c:forEach var="task" items="${daHoanThanh }">
						<a href="<c:url value="/task/detail?id=${task.id}" />">
							<div class="mail-contnet">
								<h5>${task.user_name }</h5>
								<span class="mail-desc">${task.name }</span> <span class="time">End
									Date: <span class="dateId">${task.end_date }</span>
								</span>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>