<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="/CrmApp/static/plugins/images/favicon.png">

<title><dec:title></dec:title></title>

<!-- Bootstrap Core CSS -->
<link href="/CrmApp/static/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Menu CSS -->
<link
	href="/CrmApp/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">

<!-- Animation CSS -->
<link href="/CrmApp/static/css/animate.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/CrmApp/static/css/style.css" rel="stylesheet">

<!-- color CSS -->
<link href="/CrmApp/static/css/colors/blue.css" id="theme"
	rel="stylesheet">
<link rel="stylesheet" href="/CrmApp/static/css/custom.css">

<!-- color CSS you can use different color css from css/colors folder -->
<!-- We have chosen the skin-blue (blue.css) for this starter
          page. However, you can choose any other skin from folder css / colors .
-->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">

		<!-- Navigation -->
		<jsp:include page="/WEB-INF/views/layout/navbar.jsp"></jsp:include>

		<!-- Left navbar-header -->
		<jsp:include page="/WEB-INF/views/layout/leftSidebar.jsp"></jsp:include>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">

				<dec:body></dec:body>

			</div>
			<!-- /.container-fluid -->

			<!-- FOOTER -->
			<jsp:include page="/WEB-INF/views/layout/footer.jsp"></jsp:include>

		</div>
		<!-- /#page-wrapper -->
	</div>

	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="/CrmApp/static/plugins/bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/CrmApp/static/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Menu Plugin JavaScript -->
	<script
		src="/CrmApp/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>

	<!--slimscroll JavaScript -->
	<script src="/CrmApp/static/js/jquery.slimscroll.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

	<!--Wave Effects -->
	<script src="/CrmApp/static/js/waves.js"></script>

	<!--Counter js -->
	<script
		src="/CrmApp/static/plugins/bower_components/waypoints/lib/jquery.waypoints.js"></script>
	<script
		src="/CrmApp/static/plugins/bower_components/counterup/jquery.counterup.min.js"></script>

	<script
		src="/CrmApp/static/plugins/bower_components/raphael/raphael-min.js"></script>
	<script
		src="/CrmApp/static/plugins/bower_components/morrisjs/morris.js"></script>

	<script src="/CrmApp/static/js/dashboard1.js"></script>
	<script
		src="/CrmApp/static/plugins/bower_components/toast-master/js/jquery.toast.js"></script>
	<script src="/CrmApp/static/js/custom.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable({
				"pagingType" : "full_numbers"
			});
		});
	</script>

	<script src="/CrmApp/static/js/myscript.js"></script>
</body>

</html>