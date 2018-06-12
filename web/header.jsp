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
	  <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet" type="text/css" />
  
      <script src="${pageContext.request.contextPath}/js/header.js"></script>
	  <script type="text/javascript">
	  	var contextPath = "<%=request.getContextPath()%>";
	  </script>
 </head> 
 <body> 
  <!-- 头部开始 --> 
  <div class="header"> 
   <div class="main container-fluid"> 
    <div class="row"> 
     <div class="col-md-4"> 
      <div class="logo"> 
       <img src="${pageContext.request.contextPath}/img/logo20.png" alt="" style="width:150px; height:50px;" /> 
      </div> 
      <div class = "description">
        Interatomic Potentials Database<br>
        Part of the Materials Genetic Engineering Data
      </div>
      </div>
     </div> 
     <div class="col-md-6" > 
      <nav class="navbar navbar-default"> 
       <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1 " style="padding-right:0px;"> 
        <ul class="nav navbar-nav navbar-nav-right"> 
         <li><a href="${pageContext.request.contextPath}/index" class="active">Home</a></li> 
         <li role="presentation" class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"> Resources<span class="caret"></span> </a> 
          <ul class="dropdown-menu"> 
           <li><a href="#">Semiconductors</a></li> 
           <li><a href="#">Ionic Crystals</a></li> 
           <li><a href="#">Interface</a></li> 
           <li><a href="#">Metal Alloys</a></li> 
           <li><a href="#">Others</a></li> 
          </ul> 
          </li> 
         <li><a href="javascript:void(0);">Help</a></li> 
         <li><a href="javascript:void(0);">About Us</a></li> 
         <li><a href="javascript:void(0);">User</a></li> 
         <li><a href="javascript:void(0);" class = "background">Background System</a></li> 
        </ul> 
       </div> 
      </nav> 
     </div> 
     <div class = "col-md-2 right">
        <div class = "row">
            <div class = "col-xs-12 ustb">
                USTB 
            </div>
            <div class = "col-xs-12">
                Department of Physics, 
            </div>
            <div class = "col-xs-12">
                University of Science and Technology Beijing, 
            </div>
            <div class = "col-xs-12">
                China
            </div>
        </div>
     </div>
    </div> 
   </div> 
  </div> 
  <!-- //header --> 
 </body>
</html>