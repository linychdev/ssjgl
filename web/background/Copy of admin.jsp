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
<script src="${pageContext.request.contextPath}/js/pace.min.js"></script>
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
                <a class="navbar-brand" href="index.html">势库网站后台管理系统</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="top1.html">您好，管理员！</a></li>
                    <li><a href="top2.html">修改密码</a></li>
                    <li><a href="top3.html">退出登录</a></li>
                </ul>
            </div>
        </div>
    </nav>
	<div class="container-fluid all">
        <div class="sidebar" >
            <ul class="nav">
                <li><a href="index.html">主页面</a></li>
                <li class="has-sub">
                    <a href="javascript:void(0);"><span>用户管理</span><i class="fa fa-caret-right fa-fw pull-right"></i></a>
                    <ul class="sub-menu">
                        <li><a href="admin.html"><i class="fa fa-circle-o fa-fw"></i>&nbsp;注册用户管理</a></li>
                    </ul>
                </li>
				 <li class="has-sub">
                    <a href="javascript:void(0);"><span>数据管理</span><i class="fa fa-caret-right fa-fw pull-right"></i></a>
                    <ul class="sub-menu">
          
						<li><a href="function.html"><i class="fa fa-circle-o fa-fw"></i>&nbsp;势函数管理</a></li>
						<li><a href="mgi.html"><i class="fa fa-circle-o fa-fw"></i>&nbsp;势数据管理</a></li>
                    </ul>
                </li>
				<li class="has-sub">
                    <a href="javascript:void(0);"><span>日志管理</span><i class="fa fa-caret-right fa-fw pull-right"></i></a>
                    <ul class="sub-menu">
                        <li><a href="element.html"><i class="fa fa-circle-o fa-fw"></i>&nbsp;活跃度</a></li>
						<li><a href="function.html"><i class="fa fa-circle-o fa-fw"></i>&nbsp;检索统计</a></li>
						<li><a href="add.html"><i class="fa fa-circle-o fa-fw"></i>&nbsp;下载统计</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <%-- <jsp:include page="user.jsp" flush="true" /> --%>
        <div class="maincontent row" style="display:none"> 
			<!-- 通过给class 加style="display:none;隐藏DIV -->
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
					
					<!-- 页码 -->
        </div>
            <!--这是用户管理主要内容 end-->
		    <!-- 势函数管理开始 -->
		<div class = "maincontent row">
			<ul class="breadcrumb">  
                <li ><i class="fa fa-facebook-official fa-fw"></i>&nbsp;势函数列表</a></li>
				<li style="float:right"><a href = "#"><i class="fa fa-plus fa-fw"></i></a>新增势函数</a></li>
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
						<tr>
							<td>1</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
							<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
							<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
								<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
						<tr>
							<td>3</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
								<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
						<tr>
							<td>4</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
								<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
						<tr>
							<td>5</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
								<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
						<tr>
							<td>6</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
								<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
						<tr>
							<td>7</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
								<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
						<tr>
							<td>8</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
								<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
						<tr>
							<td>9</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
								<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
						<tr>
							<td>10</td>
							<td>morse</td>
							<td>无说明文字</td>
							<td>N=1/x²+1/sin(x-π/121)-tan(x²-1) </td>
							<td>
								<a href = "#"><i class="fa fa-edit fa-fw"></i>&nbsp;编辑&nbsp; </a>
								<a href = "#"><i class="fa fa-trash fa-fw"></i>&nbsp;删除&nbsp; </a>
							</td>
						</tr>
				</table>
				<!-- <!-- 势函数列表结束 -->	 
			</div>
		</div>
		<!-- 势函数管理页面结束 -->
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
		<!-- 活跃度页面 -->
    </div>
</body>
</html>