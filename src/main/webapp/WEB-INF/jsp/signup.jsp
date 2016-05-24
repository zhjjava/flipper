<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/common/include.jsp"%>
<head>
<title>HRMS</title>
<%
		// the following code is used to control the cache
		response.addHeader("Cache-Control", "no-store"); // HTTP 1.1
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "private");
		// resp.addHeader("Cache-Control","must-revalidate");
		// resp.addHeader("Cache-Control","post-check=0");
		// resp.addHeader("Cache-Control","pre-check=0");
		response.addHeader("Pragma", "no-cache"); // HTTP 1.0
		response.addDateHeader("Expires", 0); // prevents caching at the proxy
%>
<meta name="author" content="SuggeElson" />
<meta name="description"
	content="Supr admin template - new premium responsive admin template. This template is designed to help you build the site administration without losing valuable time.Template contains all the important functions which must have one backend system.Build on great twitter boostrap framework" />
<meta name="keywords"
	content="admin, admin template, admin theme, responsive, responsive admin, responsive admin template, responsive theme, themeforest, 960 grid system, grid, grid theme, liquid, masonry, jquery, administration, administration template, administration theme, mobile, touch , responsive layout, boostrap, twitter boostrap" />
<meta name="application-name" content="Supr admin template" />
<!-- Mobile Specific Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Force IE9 to render in normla mode -->
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- HTTP 1.1 -->
<meta http-equiv="Cache-Control" content="no-store" />
<!-- HTTP 1.0 -->
<meta http-equiv="Pragma" content="no-cache" />
<!-- Prevents caching at the Proxy Server -->
<meta http-equiv="Expires" content="0" />

<!-- Le styles -->
<link href="${ctx}/css/bootstrap/bootstrap.css" rel="stylesheet" />
<!-- <link href="${ctx}/css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />-->
<link href="${ctx}/css/supr-theme/jquery.ui.supr.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/css/icons.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/plugins/forms/uniform/uniform.default.css"
	type="text/css" rel="stylesheet" />

<!-- Main stylesheets -->
<link href="${ctx}/css/main.css" rel="stylesheet" type="text/css" />

<!--[if IE 8]><link href="${ctx}/css/ie8.css" rel="stylesheet" type="text/css" /><![endif]-->

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script type="text/javascript" src="${ctx}/js/libs/excanvas.min.js"></script>
      <script type="text/javascript" src="${ctx}/js/html5.js"></script>
      <script type="text/javascript" src="${ctx}/js/libs/respond.min.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="${ctx}/images/favicon.ico" />
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${ctx}/images/apple-touch-icon-144-precomposed.png" />
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${ctx}/images/apple-touch-icon-114-precomposed.png" />
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${ctx}/images/apple-touch-icon-72-precomposed.png" />
<link rel="apple-touch-icon-precomposed"
	href="${ctx}/images/apple-touch-icon-57-precomposed.png" />

<script type="text/javascript" src="${ctx}/js/libs/modernizr.js"></script>

</head>

<body class="loginPage">

	<div class="container">
		<div id="header" style="height: 66px">
			<div class="row">
				<div class="navbar" style="height: 66px">
					<div class="container">
						<a class="navbar-brand" href="dashboard.html">Human Resource
							Management System<span class="slogan"></span>
						</a>
					</div>
				</div>
				<!-- /navbar -->
			</div>
			<!-- End .row -->
		</div>
		<!-- End #header -->
	</div>
	<!-- End .container -->

	<div class="container">

		<div class="loginContainer">
			<form:form id="loginForm" name="loginForm" method="post"
				action="signup.do" modelAttribute="sysUser"
				cssClass="form-horizontal" role="form">
				
				<br />
				<div class="form-group">
					<label class="col-md-12 control-label" for="username">Login
						Name:</label>
					<div class="col-md-12">
						<form:input id="loginName" type="text" path="loginName"
							cssClass="form-control" size="25" placeholder="Login Name" />
						<form:errors path="loginName" cssStyle="color:red"></form:errors>
						<!-- <span class="icon16 icomoon-icon-user right gray marginR10"></span> -->
					</div>
				</div>
				<!-- End .form-group  -->
				<div class="form-group">
					<label class="col-md-12 control-label" for="password">Password:</label>
					<div class="col-md-12">
						<form:input id="password" type="password" path="password" value=""
							class="form-control" placeholder="Password" />
						<%-- <form:errors path="password" cssStyle="color:red"></form:errors> --%>
						<!-- <span class="icon16 icomoon-icon-lock right gray marginR10"></span> -->
					</div>
				</div>
				<!-- End .form-group  -->
				
				<div class="form-group">
					<label class="col-md-12 control-label" for="verifyPassword">Confirm password:</label>
					<div class="col-md-12">
						<form:input id="verifyPassword" type="password" path="verifyPassword" value=""
							class="form-control" placeholder="Password" />
						<form:errors path="verifyPassword" cssStyle="color:red"></form:errors>
						<span class="icon16 icomoon-icon-lock right gray marginR10"></span>
						
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="col-md-12 control-label" for="firstName">First name:</label>
					<div class="col-md-12">
						<form:input cssclass="form-control" id="firstName" type="text"
						class="form-control" 	path="firstName" placeholder="first name" />
						<form:errors path="firstName" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<!-- End .form-group  -->
				
				<div class="form-group">
					<label class="col-md-12 control-label" for="lastName">Last name:</label>
					<div class="col-md-12">
						<form:input cssclass="form-control" id="lastName" type="text"
						class="form-control" 	path="lastName" placeholder="last name" />
						<form:errors path="lastName" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<!-- End .form-group  -->
				

				<div class="form-group">
					<label class="col-md-12 control-label" for="username">Email:</label>
					<div class="col-md-12">
						<form:input cssclass="form-control" id="personalEmail" type="text"
						class="form-control" 	path="personalEmail" placeholder="email" />
						<form:errors path="personalEmail" cssStyle="color:red"></form:errors>
					</div>
				</div>
				<!-- End .form-group  -->
				<div class="form-group">
					<label class="col-md-12 control-label" for="gender">Gender:</label>
					<div class="col-md-12">
						<div class="radio-inline">
							<label> <form:radiobutton path="gender" value="male" />male
							</label> <label> <form:radiobutton path="gender" value="female" />female
							</label>
						</div>
					</div>
				</div>


				<div class="form-group">
					<div class="col-md-12 clearfix form-actions">
						<button type="submit" class="btn btn-info right" id="loginBtn">
							<span class="icon16 icomoon-icon-enter white"></span>Save
						</button>
					</div>
				</div>
				<!-- End .form-group  -->
			</form:form>
          
		</div>

	</div>
	<!-- End .container -->

	<!-- Le javascript
    ================================================== -->
	<script src="${ctx}/js/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="${ctx}/js/bootstrap/bootstrap.js"></script>
	<script type="text/javascript"
		src="${ctx}/plugins/forms/validate/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="${ctx}/plugins/forms/uniform/jquery.uniform.min.js"></script>

	<script type="text/javascript" src="${ctx}/js/slancer-index.js"></script>
</body>
</html>
