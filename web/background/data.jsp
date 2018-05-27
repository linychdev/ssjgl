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
 <link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/dataurl.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/js/default.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/admin.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
</script>
</head>	
<body>	
		<!-- 势数据管理页面开始 -->
		<div class = "maincontent row">
			<ul class="breadcrumb">  
                <li ><i class="fa fa-list-ul fa-fw"></i>&nbsp;势数据列表</a></li>
				<li style="float:right"><a href = "#"><i class="fa fa-plus fa-fw"></i></a>新增势数据</a></li>
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
						<tr>
							<td>1</td>
							<td>AlN</td>
							<td>Semiconductors</td>
							<td>Al,N</td>
							<td>无</td>
							<td>无</td>
							<td>
							<a href = "#"><i class="fa fa-edit fa-fw"></i></a>&nbsp;编辑&nbsp; 
							<a href = "#"><i class="fa fa-trash fa-fw"></i></a>&nbsp;删除
							<a href = "#"><i class="fa fa-file-text fa-fw"></i></a>&nbsp;文件</td>
						</tr>
						<tr>
							<td>2</td>
							<td>CaO</td>
							<td>Ionic Crystals </td>
							<td>Ca,O</td>
							
							<td>无</td>
							<td>无</td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i></a>&nbsp;编辑&nbsp; 
								<a href = "#"><i class="fa fa-trash fa-fw"></i></a>&nbsp;删除
								<a href = "#"><i class="fa fa-file-text fa-fw"></i></a>&nbsp;文件</td>
							</td>
						</tr>
						<tr>
							<td>3</td>
							<td>CaO</td>
							<td>Ionic Crystals </td>
							<td>Ca,O</td>
							
							<td>无</td>
							<td>无</td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i></a>&nbsp;编辑&nbsp; 
								<a href = "#"><i class="fa fa-trash fa-fw"></i></a>&nbsp;删除
								<a href = "#"><i class="fa fa-file-text fa-fw"></i></a>&nbsp;文件</td>
							</td>
						</tr>
						<tr>
							<td>4</td>
							<td>Ag(111)/MgO(111)</td>
							<td>Interface </td>
							<td>Ag,Mg,O</td>
							
							<td>无</td>
							<td>无</td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i></a>&nbsp;编辑&nbsp; 
								<a href = "#"><i class="fa fa-trash fa-fw"></i></a>&nbsp;删除
								<a href = "#"><i class="fa fa-file-text fa-fw"></i></a>&nbsp;文件</td>
							</td>
						</tr>
						<tr>
							<td>5</td>
							<td>AlFe</td>
							<td>Metal Alloys </td>
							<td>Al,Fe</td>
							
							<td>无</td>
							<td>无</td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i></a>&nbsp;编辑&nbsp; 
								<a href = "#"><i class="fa fa-trash fa-fw"></i></a>&nbsp;删除
								<a href = "#"><i class="fa fa-file-text fa-fw"></i></a>&nbsp;文件</td>
							</td>
							</tr>
				</table>
			</div>
	
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
						<li class="disabled">当前您共有势数据：500个</li> 
					</ul>	
			</div>

		</div>
		<!-- 势数据管理页面结束 -->
</body>
</html>