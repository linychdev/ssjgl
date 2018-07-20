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
	  <link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css" /> 
	  <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" /> 
	  <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet" type="text/css" />
      <script src="${pageContext.request.contextPath}/js/header.js"></script>
	  <script type="text/javascript">
	  	var contextPath = "<%=request.getContextPath()%>";
	  </script>
 </head> 
 <body> 
  <!-- 头部开始 --> 
  	<div class="header">
		<div class="header-wrapper">
				<div class = "left">
					<div class = "logo">
						<a href ="#">
							<img src="${pageContext.request.contextPath}/img/logo20.png" alt="" style="width:100px; height:40px;">
						</a>
					</div>
					<div class="left_text">
						<div class="left_textup">
							Interatomic Potentials Database
						</div>
						<div class="left_textdown">
							Part of the Materials Genetic Engineering Data
						</div>
					</div>
				</div>
				<div class="right">
					<div class="right_text1">
						USTB
					</div>
					<div class="right_text2">
						University of 
					</div>
					<div class="right_text2">
						Science & Technology
					</div>
					<div class="right_text2">
						Beijing,China
					</div>
		</div>
				<div class = "headermain">
					<nav class="navbar navbar-default"> 
					   <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1 " style="padding-right:0px;"> 
						<ul class="nav navbar-nav navbar-nav-right"> 
						 <li><a id = "li-home" href="${pageContext.request.contextPath}/index" class="active">Home</a></li> 
	<!-- 					 <li id="menu-item-18" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-has-children menu-item-18 dropdown"><a id = "resources" href="javascript:void(0)" data-toggle="dropdown" aria-haspopup="true" class="dropdown-toggle">Resources <span class="caret"></span></a>
							<ul role="menu" class=" dropdown-menu">
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1116"><a href="javascript:void(0);" target="_self">Semiconductors</a></li>
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1127"><a href="javascript:void(0);" target="_self">Ionic Crystals</a></li>
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1128"><a href="javascript:void(0);" target="_self">Interface</a></li>
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-1129"><a href="javascript:void(0);" target="_self">Metal Alloys </a></li>
								<li id="" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-5141"><a href="javascript:void(0);" target="_self">Others</a></li>
							</ul>
						 </li> -->
						 <li><a id = "li-resources" href="javascript:void(0);">resources</a></li> 
						 <li><a id = "li-help" href="javascript:void(0);">help</a></li> 
						 <li><a id = "li-aboutus" href="javascript:void(0);">aboutus</a></li> 
						 <li><a id = "li-link" href="javascript:void(0);">link</a></li> 
						 <!-- <li><a id = "li-user" href="javascript:void(0);">user</a></li>  -->
						 <li><a id = "li-login" href="javascript:void(0);">Login</a></li> 
						</ul> 
					   </div> 
					</nav> 
				</div>
			</div>
	</div>
    <!-- //header --> 
 </body>
</html>