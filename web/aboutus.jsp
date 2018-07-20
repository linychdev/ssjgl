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
  <link href="${pageContext.request.contextPath}/css/main/aboutUs.css" rel="stylesheet" type="text/css" /> 
  
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
 <body> 
 	<jsp:include page="/header.jsp" flush="true" />
  <div class="wrap">
		<h2 class="tit_b">About us</h2>
		<div class="block">
			<h4 class="tit_m"> Additional Acknowledgments</h4>
			<p>
				Thanks are due to Yanjing Su for suggesting this project and for providing valuable assistance. Various developers of interatomic potentials have also provided data and advice. These include Ping Qian, Jiang Shen, Jin Cai, Yao Long, Hanyue Zhao, Jinchun Li, Gang Wang and Hongquan Song. Many thanks go out to the group mumbers of the Institute for Applied Physics in the University of Science and Technology Beijing for maintaining the MGED.
			</p>
		</div>
		<div class="block">
			<h4 class="tit_m">Q: What is the purpose of the MGED?</h4>
			<p>
				A: The purpose of the MGED is to provide a database of interatomic potentials for atomistic simulations (e.g. molecular dynamics) and to reference experimental and first-principles data in order to promote the evaluation of these potentials for particular applications. Depending on the application environments, MGED classifies interatomic potentials into different categories. 
				For example, some interatomic potentials which have been fit only to the properties of metals However, some interatomic potentials will probably better represent properties of the interface properties (e.g. metal-ceramics interfacial properties). Additionally, we are not limiting the database to a single interatomic potential format or software package. The provided discrete data tables can be fitted into various function forms.
			</p>
		</div>
		<div class="block">
			<h4 class="tit_m"> MGED Disclaimer Statement</h4>
			<p>
				Any mention of commercial products within MGED web pages is for information only; it does not imply recommendation or endorsement by MGED.
			</p>
			<h5 class="tit_e">Use of MGED Information </h5>
			<p>
				These World Wide Web pages are provided as a public service by the Materials Genetic Engineering Data (MGED). You may use, copy and distribute copies of the data in any medium, provided that you keep intact this entire notice and reference the website of MGED. You may improve, modify and create derivative works of the database or any portion of the database, and you may copy and distribute such modifications or works. Modified works should carry a notice stating that you changed the data and should note the date and nature of any such change. Please explicitly acknowledge the MGED as the source of the database.
			</p>
			<p>
				MGED is expressly provided "AS IS." MGED MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED, IN FACT OR ARISING BY OPERATION OF LAW, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT AND DATA ACCURACY. MGED NEITHER REPRESENTS NOR WARRANTS THAT THE OPERATION OF THE SOFTWARE WILL BE UNINTERRUPTED OR ERROR-FREE, OR THAT ANY DEFECTS WILL BE CORRECTED. MGED DOES NOT WARRANT OR MAKE ANY REPRESENTATIONS REGARDING THE USE OF THE DATABASE OR THE RESULTS THEREOF, INCLUDING BUT NOT LIMITED TO THE CORRECTNESS, ACCURACY, RELIABILITY, OR USEFULNESS OF THE DATABASE.
			</p>
			<p>
				You are solely responsible for determining the appropriateness of using and distributing the database and you assume all risks associated with its use, including but not limited to the risks and costs of program errors, compliance with applicable laws, damage to or loss of data, programs or equipment, and the unavailability or interruption of operation. This database is not intended to be used in any situation where a failure could cause risk of injury or damage to property. 
			</p>
		</div>
  </div>
  <script type="text/javascript">
  	$("#li-aboutus").addClass("active");
	$("#li-aboutus").parent("li").removeClass("active");
	$("#li-aboutus").parent("li").siblings().removeClass("active");
	$("#li-aboutus").parent("li").siblings().children("a").removeClass("active");
  </script>
 </body>
 </html>