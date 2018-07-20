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
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
  <meta name="keywords" content="Optometry Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" /> 
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script> 
  <link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css" /> 
  <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" /> 
  <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet" type="text/css"  />
  <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" />
  <link href="${pageContext.request.contextPath}/css/main/link.css" rel="stylesheet" type="text/css" /> 
  
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
 <body> 
 	<jsp:include page="/header.jsp" flush="true" />
		<div class="main container"> 
		  <div class ="row div1">
			<p style="font-size: 18px; padding-top: 10px;">
			<strong>Notes:</strong>
			There are some websites for you.
			</p>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="https://www.ctcms.nist.gov/potentials/" target="view_window">https://www.ctcms.nist.gov/potentials/ </a>
			  </h4>
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="http://www.libatoms.org/Home/DataRepository" target="view_window">http://www.libatoms.org/Home/DataRepository </a>
			  </h4>
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="https://www.materialsproject.org/" target="view_window">https://www.materialsproject.org/</a>
			  </h4>
			  
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="http://www.aflowlib.org/" target="view_window">http://www.aflowlib.org/ </a>
			  </h4>
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="http://lammps.sandia.gov/" target="view_window">http://lammps.sandia.gov/ </a>
			  </h4>
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="http://www.vasp.at/" target="view_window">http://www.vasp.at/ </a>
			  </h4>
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="http://gulp.curtin.edu.au/gulp/" target="view_window">http://gulp.curtin.edu.au/gulp/ </a>
			  </h4>
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="http://accelrys.com/products/collaborative-science/biovia-materials-studio/" target="view_window">http://accelrys.com/products/collaborative-science/biovia-materials-studio/ </a>
			  </h4>
			 
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="http://jp-minerals.org/vesta/en/" target="view_window">http://jp-minerals.org/vesta/en/ </a>
			  </h4>
			 
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="http://li.mit.edu/A/Graphics/A/" target="view_window">http://li.mit.edu/A/Graphics/A/</a>
			  </h4>
			  
			</div>
			<div class ="col-md-12">
			  <h4>
				<i class="fa fa-link fa-fw fontColor"></i>&nbsp;
				<a href="http://www.ovito.org/" target="view_window">http://www.ovito.org/</a>
			  </h4>
			  
			</div>
		  </div>
		</div>
  <script type="text/javascript">
  	$("#li-link").addClass("active");
	$("#li-link").parent("li").removeClass("active");
	$("#li-link").parent("li").siblings().removeClass("active");
	$("#li-link").parent("li").siblings().children("a").removeClass("active");
  </script>
 </body>
 </html>