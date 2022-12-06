<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật công việc</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Cập nhật công việc</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material"
					action='<c:url value="/profile/edit"/>' method="POST">
					<input type="hidden" value="${ task.id }" name="id"
						class="form-control form-control-line"> <input
						type="hidden" value="${USER.id}" name="user"
						class="form-control form-control-line">
					<div class="form-group">
						<label class="col-md-12">Dự án</label>
						<div class="col-md-12">
							<select class="form-control form-control-line" name="job">
								<option value="${ task.job_id }" selected hidden>${ task.job_name }</option>
								<c:forEach var="item" items="${ jobs }">
									<option value="${ item.id }">${ item.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Tên công việc</label>
						<div class="col-md-12">
							<input type="text" value="${task.name}" name="name"
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Ngày bắt đầu</label>
						<div class="col-md-12">
							<input type="date" name="start_date" value="${task.start_date }"
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Ngày kết thúc</label>
						<div class="col-md-12">
							<input type="date" name="end_date" value="${ task.end_date }"
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Trạng thái</label>
						<div class="col-md-12">
							<select class="form-control form-control-line" name="status">
								<option value="${ task.status_id }" selected hidden>${ task.status_name }</option>
								<c:forEach var="item" items="${ status }">
									<option value="${ item.id }">${ item.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Lưu lại</button>
							<a href='<c:url value="/profile?id=${USER.id}"/>'
								class="btn btn-primary">Quay lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
</body>
</html>