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
 <link href="${pageContext.request.contextPath}/css/log.css" rel="stylesheet" />
 
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/js/default.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/js/background/searchLog.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/echarts.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
	var hotSearchListJson = ${hotSearchListJson};
	var invalidSearchListJson = ${invalidSearchListJson};
	var hotPotenListJson = ${hotPotenListJson};
</script>
</head>	
<body>	
        <div class="maincontent "> 
			<div class="row">
			<!-- 通过给class 加style="display:none;隐藏DIV -->
            <!--主面板 start-->
            <div class = "col-md-2">
				<blockquote class = "block" >
						检索统计
				</blockquote>	
			</div>
			</div>
			<div class="row">
				<div class="col-md-4" >
					<div class="bar">
						<div class="barup headingText">
							热门搜索
						</div>
						<div class="bardown" id="hotSearch">
							
						</div>
					</div>
				</div>
				<div class="col-md-4 " >
					<div class="bar">
						<div class="barup headingText">
							热门访问
						</div>
						<div class="bardown" id="hotVisit">
						
						</div>
					</div>
				</div>
				<div class="col-md-4 ">
					<div class="bar">
						<div class="barup headingText">
							无效检索
						</div>
						<div class="bardown" id="invalidSearch">
						 
						</div>
					</div>
				</div> 
				<!-- 统计图结束 -->
				<div class="col-md-12 bartop">
				<table class="table table-bordered">
					<tr>
						<td class="tdbg">
							排名
						</td>
						<td class="tdbg">
							检索词
						</td>
						<td class="tdbg">
							检索热度
						</td>
						<td class="tdbg">
							检索结果数
						</td>
						<td class="tdbg">
							检索到有效结果<i class="fa fa-filter fa-fw "></i>
						</td>
					</tr>
					<c:forEach items="${pageData.dataList}" var="searchLog" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<td>${searchLog.searchText }</td>
						<td>${searchLog.searchTimes }</td>
						<td>${searchLog.resultNumber }</td>
						<td>${searchLog.cValid }</td>
					</tr>
					</c:forEach>
				</table>
				</div>
			</div>			
        </div>
</body>
</html>