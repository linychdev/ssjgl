<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1  maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link href="${pageContext.request.contextPath}/css/background/admin.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/dataurl.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/js/default.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/background/admin.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/js/pace.min.js"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
</script>
</head>	
<body>	
	<!-- header -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle show pull-left" data-target="sidebar">
                    <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                </button>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/background/admin">势库网站后台管理系统</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="javascript:void(0);">您好，${user.cName}！</a></li>
                    <li><a href="javascript:void(0);" id= "modifyPassword">修改密码</a></li>
                    <li><a href="javascript:void(0);" id = "logOut">退出登录</a></li>
                </ul>
            </div>
        </div>
    </nav>
	<div class="container-fluid all">
        <div class="sidebar" >
            <ul class="nav">
                <li><a href="${pageContext.request.contextPath}/index">主页面</a></li>
                <li class="has-sub">
                    <a href="javascript:void(0);"><span>用户管理</span><i class="fa fa-caret-right fa-fw pull-right"></i></a>
                    <ul class="sub-menu">
                        <li><a href="javascript:void(0);" id = "userManager"><i class="fa fa-circle-o fa-fw"></i>&nbsp;管理员</a></li>
                        <!-- <li><a href="javascript:void(0);" id = "userManager"><i class="fa fa-circle-o fa-fw"></i>&nbsp;注册用户</a></li> -->
                    </ul>
                </li>
				 <li class="has-sub">
                    <a href="javascript:void(0);"><span>数据管理</span><i class="fa fa-caret-right fa-fw pull-right"></i></a>
                    <ul class="sub-menu">
          
						<li><a href="javascript:void(0);" id = "functionManager"><i class="fa fa-circle-o fa-fw"></i>&nbsp;势函数管理</a></li>
						<li><a href="javascript:void(0);" id = "dataManager"><i class="fa fa-circle-o fa-fw"></i>&nbsp;势数据管理</a></li>
                    </ul>
                </li>
			<!-- 	<li class="has-sub">
                    <a href="javascript:void(0);"><span>日志管理</span><i class="fa fa-caret-right fa-fw pull-right"></i></a>
                    <ul class="sub-menu">
                        <li><a href="element.html"><i class="fa fa-circle-o fa-fw"></i>&nbsp;活跃度</a></li>
						<li><a href="function.html"><i class="fa fa-circle-o fa-fw"></i>&nbsp;检索统计</a></li>
						<li><a href="add.html"><i class="fa fa-circle-o fa-fw"></i>&nbsp;下载统计</a></li>
                    </ul>
                </li> -->
            </ul>
        </div>
        <iframe id = "mainSpace" src="${pageContext.request.contextPath}/background/userList" width="100%" height="90%"></iframe>
</body>
</html>