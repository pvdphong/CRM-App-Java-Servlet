<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<br />
	<c:forEach var='job' items="${jobs }">
		<div class="row">
			<div class="col-xs-12">
				<a href='<c:url value="/job/detail?id=${job.getId()}"/>'
					class="group-title text-muted"
					style="font-weight: bold; font-size: 18px"> ${job.getName()} </a>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
				<div class="white-box">
					<div class="col-in row">
						<div class="col-md-6 col-sm-6 col-xs-6">
							<i data-icon="E" class="linea-icon linea-basic"></i>
							<h5 class="vb text-danger">CHƯA THỰC HIỆN</h5>
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6">
							<h3 class="counter text-right m-t-15 text-danger">${ job.getChuaThucHien() }%</h3>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
									style="width: ${job.getChuaThucHien() }%"></div>
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
							<h3 class="counter text-right m-t-15 text-megna">${job.getDangThucHien()  }%</h3>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="progress">
								<div class="progress-bar progress-bar-megna" role="progressbar"
									aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
									style="width: ${job.getDangThucHien()  }%"></div>
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
							<h3 class="counter text-right m-t-15 text-primary">${job.getDaHoanThanh() }%</h3>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="progress">
								<div class="progress-bar progress-bar-primary"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: ${job.getDaHoanThanh()  }%"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.col -->
		</div>
	</c:forEach>
</body>
</html>