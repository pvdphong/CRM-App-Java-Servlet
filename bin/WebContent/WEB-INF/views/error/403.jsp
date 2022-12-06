<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" type="image/png" sizes="16x16"
	href='<c:url value="/CrmApp/static/plugins/images/favicon.png"></c:url>'>
<title>403 - Forbidden</title>
<!-- Bootstrap Core CSS -->
<link href='/CrmApp/static/bootstrap/dist/css/bootstrap.min.css' rel="stylesheet">
<!-- animation CSS -->
<link href='/CrmApp/static/css/animate.css' rel="stylesheet">
<!-- Custom CSS -->
<link href='/CrmApp/static/css/style.css' rel="stylesheet">
<!-- color CSS -->
<link href='/CrmApp/static/css/colors/blue.css' id="theme" rel="stylesheet">
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
	<section id="wrapper" class="error-page">
		<div class="error-box">
			<div class="error-body text-center">
				<h1>403</h1>
				<h3 class="text-uppercase">Bạn không có quyền truy cập !</h3>
				<p class="text-muted m-t-30 m-b-30">YOU SEEM TO BE TRYING TO
					FIND HIS WAY HOME</p>
				<a href='<c:url value="/home" />'
					class="btn btn-info btn-rounded waves-effect waves-light m-b-40">Về
					trang chủ</a>
			</div>
			<footer class="footer text-center">2020 © Design by Phong Pham</footer>
		</div>
	</section>
	<!-- jQuery -->
	<script src='/CrmApp/static/plugins/bower_components/jquery/dist/jquery.min.js'></script>
	<!-- Bootstrap Core JavaScript -->
	<script src='/CrmApp/static/bootstrap/dist/js/bootstrap.min.js'></script>
	<script type="text/javascript">
		$(function() {
			$(".preloader").fadeOut();
		});
	</script>
</body>

</html> --%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>403</title>
<link rel="stylesheet" href="/CrmApp/static/css/403.css" />

</head>
<body>
	<svg xmlns="http://www.w3.org/2000/svg" id="robot-error"
		viewBox="0 0 260 118.9">
      <defs>
          <clipPath id="white-clip">
		<circle id="white-eye" fill="#cacaca" cx="130" cy="65" r="20" /> </clipPath>
       <text id="text-s" class="error-text" y="106"> 403 </text>
      </defs>
        <path class="alarm" fill="#e62326"
			d="M120.9 19.6V9.1c0-5 4.1-9.1 9.1-9.1h0c5 0 9.1 4.1 9.1 9.1v10.6" />
       <use xlink:href="#text-s" x="-0.5px" y="-1px" fill="black"></use>
       <use xlink:href="#text-s" fill="#2b2b2b"></use>
      <g id="robot">
        <g id="eye-wrap">
          <use xlink:href="#white-eye"></use>
          <circle id="eyef" class="eye" clip-path="url(#white-clip)"
			fill="#000" stroke="#2aa7cc" stroke-width="2" stroke-miterlimit="10"
			cx="130" cy="65" r="11" />
<ellipse id="white-eye" fill="#2b2b2b" cx="130" cy="40" rx="18" ry="12" />
        </g>
        <circle class="lightblue" cx="105" cy="32" r="2.5" id="tornillo" />
        <use xlink:href="#tornillo" x="50"></use>
        <use xlink:href="#tornillo" x="50" y="60"></use>
        <use xlink:href="#tornillo" y="60"></use>
      </g>
    </svg>
	<h1>You are not allowed to enter here</h1>
	<h2>
		Go <a href="<c:url value="/home" />">Home page!</a>
	</h2>

	<script type="text/javascript" src="/CrmApp/static/js/403.js"></script>
</body>
</html>
