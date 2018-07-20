<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>login</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login/css/login.css" />
	<!--必要样式-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/login/css/component.css" />
	<!--[if IE]>
	<script src="${pageContext.request.contextPath}/login/js/html5.js"></script>
	<![endif]-->
	
	<script type="text/javascript">
	  var contextPath = "<%=request.getContextPath()%>";
	</script>
	<script type="text/javascript"> 
</script>
  </head>
  
  <body>
	<div class="container demo-1">
		<div class="content">

			<div id="large-header" class="large-header">
				<div class="foot"></div>
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<h3>Welcome</h3>
					<form id="loginform" name="indexForm" action="login" method="post" autocomplete="off">
					<div class="input_outer">
						<span class="u_user"></span> 
						<input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="Please enter user name">
					</div>
					<div class="input_outer">
						<span class="us_uer"></span>
						<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="" type="password" placeholder="Please enter user password">
					</div>
					<div class="mb2">
						<a class="act-but submit" href="javascript:void(0);" style="color: #FFFFFF" >Login</a>
					</div>
<!-- 					<div class="getpass">
						<a href="javascript:void(0);" style="color: #FFFFFF">找回密码</a>
					</div>
					<div class="register">
						<a href="javascript:void(0);" style="color: #FFFFFF">注册账号</a>
					</div> -->
				</form>
			</div>
		</div>
	</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
	<script src="${pageContext.request.contextPath}/login/js/TweenLite.min.js"></script>
	<script src="${pageContext.request.contextPath}/login/js/EasePack.min.js"></script>
	<script src="${pageContext.request.contextPath}/login/js/rAF.js"></script>
	<script src="${pageContext.request.contextPath}/login/js/login.js"></script>
	<script src="${pageContext.request.contextPath}/login/js/register.js"></script>
	<div style="text-align:center;"></div>
  </body>
</html>
