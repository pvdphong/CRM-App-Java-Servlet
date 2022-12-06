<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết công việc</title>
</head>
<body>
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Chi tiết công việc</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material" action='#' method="POST">
					<input type="hidden" value="${ task.id }" name="id" readonly
						class="form-control form-control-line">
					<div class="form-group">
						<label class="col-md-12">Tên công việc</label>
						<div class="col-md-12">
							<input type="text" value="${task.name}" name="name" readonly
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Thuộc dự án</label>
						<div class="col-md-12">
							<input type="text" name="job" value="${ task.job_name }" readonly
								class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Người thực hiện</label>
						<div class="col-md-12">
							<input type="text" name="user" value="${ task.user_name }"
								readonly class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Ngày bắt đầu</label>
						<div class="col-md-12">
							<input type="date" name="start_date" value="${task.start_date }"
								readonly class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Ngày kết thúc</label>
						<div class="col-md-12">
							<input type="date" name="end_date" value="${ task.end_date }"
								readonly class="form-control form-control-line">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Trạng thái</label>
						<div class="col-md-12">
							<div class="col-md-12">
								<input type="text" name="status" value="${ task.status_name }"
									readonly class="form-control form-control-line">
							</div>
						</div>
					</div>
					<%-- 					<div class="form-group">
						<div class="col-sm-12">
							<a href='<c:url value="/task"/>' class="btn btn-primary">Quay
								lại</a>
						</div>
					</div> --%>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
</body>
</html>
