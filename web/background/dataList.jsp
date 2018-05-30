<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
 <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/js/default.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/background/dataList.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
	var record = ${pageData.record};
	var pageIndex = ${pageData.pageIndex};
	var pageSize = ${pageData.pageSize};
</script>
</head>	
<body>	
		<!-- 势数据管理页面开始 -->
		<div class = "maincontent row">
			<ul class="breadcrumb">  
                <li ><i class="fa fa-list-ul fa-fw"></i>&nbsp;势数据列表</a></li>
				<li style="float:right"><a href = "javascript:void(0);" id = "addPotenButton"><i class="fa fa-plus fa-fw"></i></a>新增势数据</a></li>
            </ul>
			<div class ="col-md-12">
				<table class = "table table-striped table-responsive">
					<tr>
						<th>序号</th>
						<th>名称</th>
						<th>类别</th>
						<th>相关元素</th>
						<th>其他属性</th>
						<th>说明</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageData.dataList}" var="combInfo" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${combInfo.elementComb.cCombName }</td>
							<td>${combInfo.scope.cName }</td>
							<td>
								<c:forEach items="${combInfo.elementList}" var="element" varStatus="status">
								${element.cSymbol }<c:if test="${status.last==false}">,</c:if>
								</c:forEach>
							</td>
							<td>无</td>
							<td>${combInfo.elementComb.cDescription }</td>
							<td>
							<a href = "#"><i class="fa fa-edit fa-fw"></i></a>&nbsp;编辑&nbsp; 
							<a href = "#"><i class="fa fa-trash fa-fw"></i></a>&nbsp;删除
							<a href = "#"><i class="fa fa-file-text fa-fw"></i></a>&nbsp;文件</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	
			<div class = "col-md-8 col-md-offset-4 " id = "paging-div" >

			</div>
			
		</div>
		<!-- 势数据管理页面结束 -->
</body>
</html>