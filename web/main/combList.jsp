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
<title>list</title>
<meta name="viewport" content="width=device-width, initial-scale=1  maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Optometry Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/combList.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.simple.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts-wordcloud.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/combList.js"></script>

<script type="text/javascript">
  var contextPath = "<%=request.getContextPath()%>";
  var combListJson = ${combListJson};
</script>
<!-- //js -->
</head>
	
<body>
<!-- header -->
	<div class="header" style ="background:url(${pageContext.request.contextPath}/img/banner5.jpg) repeat-x; background-size: cover;" >
		<div class="main">
			<div class="header-nav">
				<nav class="navbar navbar-default">
					<div class="navbar-header">
						<div class="logo">
							<img src="${pageContext.request.contextPath}/img/logo20.png" alt="" style="width:150px; height:50px;">
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					 <ul class="nav navbar-nav cl-effect-14">
						<li><a href="index.html" class="active">Home</a></li>
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown"  aria-haspopup="true" aria-expanded="false">
								Resources <span class="caret"></span>
						    </a>
							<ul class="dropdown-menu">
								<li><a href = "#">Semiconductors</a></li>
								<li><a href = "#">Ionic Crystals</a></li>
								<li><a href = "#">Interface</a></li>
								<li><a href = "#">Metal Alloys</a></li>
								<li><a href = "#">Others</a></li>
								
						    </ul>
						</li>

						<li><a href="services.html">Help</a></li>
						<li><a href="AboutUs.html">About Us</a></li>
						<li><a href="User.html">User</a></li>
						<li><a href="background system.html">Background System</a></li>
					  </ul>
					</div><!-- /.navbar-collapse -->
				</nav>
			</div>
		</div>
	</div>
<!-- //header -->
	<div class  = "wrap">
		<blockquote>
			<p> Potentials of ${searchText }</p>
		</blockquote>
		<!-- <hr> -->
		<div class = "element-label">
			<p>
			<c:forEach var="item" items="${groupMap}">   
			  <strong>${item.key }:</strong>
			  	<p>
				<c:forEach items="${item.value}" var="it">   
					<span class="label label-success" id = "${it.cId }">${it.cCombName }</span>
				</c:forEach>
				</p>   
			</c:forEach>  
			</p>
		</div>
		<div id="wordcloud" class="panel">
		</div>
   </div>
</body>
</html>
