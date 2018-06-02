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
 <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/js/default.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/js/background/userList.js" type="text/javascript"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
	var record = ${pageData.record};
	var pageIndex = ${pageData.pageIndex};
	var pageSize = ${pageData.pageSize};
</script>
</head>	
<body>	
     <div class="maincontent row"> 
         <!--主面板 start-->
         <ul class="breadcrumb">
             <li> <a href="javascript:void(0);" class="active"><i class="fa fa-user fa-fw"></i>&nbsp;管理员列表</a></li>
             <c:if test="${isAdmin }">
	             <li style="float:right"><a href = "javascript:void(0);" class="addUser" ><i class="fa fa-plus fa-fw"></i></a>新增管理员</a></li>
             </c:if>
         </ul>
         <div class="col-md-12">
		<!-- 用户表 -->
		<table class = "table table-striped table-responsive">
			<tr>
				<th>序号</th>
				<th>用户名</th>
				<th>姓名</th>
				<th>邮箱</th>
				<th>注册时间</th>
				<!-- <th>最近访问时间</th> -->
				<c:if test="${isAdmin }">
				<th>操作</th>
				</c:if>
			</tr>
			
			<c:forEach items="${pageData.dataList}" var="user" varStatus="status">
			<tr>
				<td>${status.index + 1 }</td>
				<td>${user.cLoginName }</td>
				<td>${user.cName }</td>
				<td>${user.cEmail }</td>
				<td>${user.dCreateTime }</td>
				<!-- <td>2018-04-01 11:39:21</td> -->
				<c:if test="${isAdmin }">
				<td>
				<a href = "javascript:void(0);" class = "deleteUser" id = "${user.cId }"><i class="fa fa-user-times fa-fw"></i></a>
				</td>
				</c:if>
			</tr>
			</c:forEach>
		</table>
	</div>
		<!-- 用户表 -->
		<!-- 页码 -->
		
		<div class = "col-md-8 col-md-offset-4 " id = "paging-div" >

		</div>
  </div>
</body>
</html>