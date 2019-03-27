<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String error = (String)request.getAttribute ("error");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>教务排课系统</title>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/sb-admin2/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="${pageContext.request.contextPath}/sb-admin2/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/sb-admin2/dist/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/sb-admin2/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body style="background-size: cover; ; background-position: center 0;background-repeat:no-repead; background-image: url('${pageContext.request.contextPath}/sb-admin2/test/timg.jpg');">

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">教务排课系统</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="${pageContext.request.contextPath}/login" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="请输入登录名" name="username"
										type="text" autofocus value="admin">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="请输入密码"
										name="password" type="password" value="123456">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="1">记住我
									</label>
								</div>
								<% if (error != null) {%>
								<div class="alert alert-danger"><%=error%></div>
								<% }%>
								<!-- Change this to a button or input when using this as a form -->
								<input type="submit" class="btn btn-lg btn-success btn-block" value="登录"></input>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	
	<script src="${pageContext.request.contextPath}/sb-admin2/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/sb-admin2/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="${pageContext.request.contextPath}/sb-admin2/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/sb-admin2/dist/js/sb-admin-2.min.js"></script>

</body>

</html>
