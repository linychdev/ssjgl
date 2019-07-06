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
 <link href="${pageContext.request.contextPath}/css/background/tankuang.css" rel="stylesheet" />
 
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/js/default.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/background/function.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
<%-- <script src="${pageContext.request.contextPath}/jmeditor/JMEditor.js" type="text/javascript" ></script> --%>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
</script>
</head>	
<body>	
    <!-- 势函数管理开始 -->
<div class = "maincontent row">
	<ul class="breadcrumb">  
        <li ><i class="fa fa-facebook-official fa-fw"></i>&nbsp;势函数列表</a></li>
		<li style="float:right"><a id = "addFunButton" href = "javascript:void(0);"><i class="fa fa-plus fa-fw"></i></a>新增势函数</a></li>
	</ul>
	<div class ="col-md-12">
		<table class = "table table-striped table-responsive">
				<tr>
					<th>序号</th>
					<th>函数名</th>
					<th>说明</th>
					<th>公式</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${functionList}" var="fun" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<td>${fun.cName }</td>
						<td>
							<c:choose> 
							   	<c:when test="${fun.cDescription eq null }">无说明文字</c:when>      
							  	<c:otherwise>${fun.cDescription }</c:otherwise> 
							</c:choose>
						</td>
						<td>${fun.cFormulaHtml} </td>
						<td>
							<a href = "javascript:void(0);" class = "editFun" id = "${fun.cId }"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
							<a href = "javascript:void(0);" class = "deleteFun" id = "${fun.cId }"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
						</td>
					</tr>
				</c:forEach>
		</table>
		<!-- <!-- 势函数列表结束 -->	 
	</div>
</div>
<!-- 势函数管理页面结束 -->

	<div id = "addFunDiv" class = "main display_none">
		<div class ="title">
			函数基本信息
		</div>
		<div class = "info">
		<form class="form-horizontal">
				  <div class="form-group">
					<label for="" class="col-sm-2 control-label">函数名:</label>
					<div class="col-sm-8">
					  <input type="text" class="form-control" id="funName" placeholder="函数名">
					</div>
				  </div>
				  <div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">说明:</label>
					<div class="col-sm-8">
					  <input type="text" class="form-control" id="funDesc" placeholder="说明">
					</div>
				  </div>
		</form>
		</div>
		<div class ="title">
			公式信息 
		</div>
		<div class = "info">
			<form class="form-horizontal">
					  <div class="form-group">
						<label for="" class="col-sm-2 control-label">公式:</label>
						<div class="col-sm-8 editDivOut">
							<div id = "funEdit" contentEditable="true" class="form-control editDiv"></div>
						</div>
					  </div>
			</form>
		</div>
		<div class = "info">
			<form class="form-horizontal">
			  <div class="form-group">
				<div class="col-sm-2 col-sm-offset-3">
					<div id = "saveFun" class="btn btn-default">保存</div>
				</div>
				<div class="col-sm-2 col-sm-offset-2">
					<div id = "cancel" class="btn btn-default">取消</div>
				</div>
			  </div>
			</div>
		</form>
	</div>
</body>
</html>