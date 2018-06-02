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
 <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/dataurl.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/background/admin.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/js/default.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/background/admin.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
</script>
</head>	
<body>	
     <div class="maincontent row"> 
         <!--主面板 start-->
         <ul class="breadcrumb">
             <li a href="#" class="active"><i class="fa fa-user fa-fw"></i>&nbsp;用户列表</a></li>
         </ul>
         <div class="col-md-12">
		<!-- 用户表 -->
		<table class = "table table-striped table-responsive">
			<tr>
				<th>序号</th>
				<th>邮箱</th>
				<th>注册时间</th>
				<th>最近访问时间</th>
				<th>操作</th>
			</tr>
			<tr>
				<td>1</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
			<tr>
				<td>2</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
			<tr>
				<td>3</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
			<tr>
				<td>4</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
			<tr>
				<td>5</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
			<tr>
				<td>6</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
			<tr>
				<td>7</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
			<tr>
				<td>8</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
			<tr>
				<td>9</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
			<tr>
				<td>10</td>
				<td>403215845@qq.com</td>
				<td>2018-04-01</td>
				<td>2018-04-01 11:39:21</td>
				<td><a href = "#"><i class="fa fa-user-times fa-fw"></i></a></td>
			</tr>
		</table>
	</div>
		<!-- 用户表 -->
		<!-- 页码 -->
	<div class = "col-md-6 ">
		<ul class="pagination pagination-md">
			<li class="disabled"><a href="#">&laquo;</a></li>
			<li class="active"><a href="#">1</a></li>
			<li ><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#">8</a></li>
			<li><a href="#">9</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
	<div class = "col-md-6 dataTables_paginate">
		<ul class="pagination pagination-md">
			<li class="disabled">当前您网站总注册用户数：1000人</li>  
	</div>
  </div>
</body>
</html>