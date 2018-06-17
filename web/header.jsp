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
	  <meta name="viewport" content="width=device-width, initial-scale=1  maximum-scale=1" /> 
	  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	  <meta name="keywords" content="Optometry Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> 
	  <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" /> 
      <link href="${pageContext.request.contextPath}/css/main/index.css" rel="stylesheet" type="text/css" /> 
	  <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet" type="text/css" />
  
      <script src="${pageContext.request.contextPath}/js/header.js"></script>
	  <script type="text/javascript">
	  	var contextPath = "<%=request.getContextPath()%>";
	  </script>
 </head> 
 <body> 
  <!-- 头部开始 --> 
  	<div class="header">
		<div class="container-fluid">
			<div class = "row">
				<div class = "col-md-4">
					<div class = "logo">
						<a href ="#">
							<img src="${pageContext.request.contextPath}/img/logo20.png" alt="" style="width:100px; height:40px;">
						</a>
					</div>
					<div class = "text1">
						Interatomic Potentials Database
						<br>
						<div class="site-sologn">Part of the Materials Genetic Engineering Data</div>
					</div>
				</div>
				<div class = "col-md-7">
					<nav class="navbar navbar-default"> 
					   <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1 " style="padding-right:0px;"> 
						<ul class="nav navbar-nav navbar-nav-right"> 
						 <li><a href="${pageContext.request.contextPath}/index" class="active">Home</a></li> 
						 <li id="menu-item-18" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-18 dropdown"><a href="#" data-toggle="dropdown" aria-haspopup="true" class="dropdown-toggle" target="_self">Resources <span class="caret"></span></a>
							<ul role="menu" class=" dropdown-menu">
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1116"><a href="javascript:void(0);" target="_self">Semiconductors</a></li>
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1127"><a href="javascript:void(0);" target="_self">Ionic Crystals</a></li>
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1128"><a href="javascript:void(0);" target="_self">Interface</a></li>
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1129"><a href="javascript:void(0);" target="_self">Metal Alloys </a></li>
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-5141"><a href="javascript:void(0);" target="_self">Others</a></li>
							</ul>
						 </li>
						 <li><a href="javascript:void(0);">Help</a></li> 
						 <li><a href="javascript:void(0);">AboutUs</a></li> 
						 <li><a href="javascript:void(0);">Link</a></li> 
						 <li><a href="javascript:void(0);">User</a></li> 
						 <li><a href="javascript:void(0);" class = "background">Login</a></li> 
						</ul> 
					   </div> 
					</nav> 
				</div>
				<div class = "col-md-1">
					<div class = "text2">
						<div style = "font-size:30px;">USTB</div>
						<div  style="font-weight: normal;">
						<div>
						University of 
						</div>
						<div style = "margin-top: -2px;">
						Science & Technology 
						</div>
						<div style = "margin-top: -2px;">
						Beijing,China
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    <!-- //header --> 
 </body>
</html>