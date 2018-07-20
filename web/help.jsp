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
		<h2 class="tit_b">Help</h2>
		<div class="block">
			<h4 class="tit_m"> Introduction</h4>
			<p>
				MGED provides a database of interatomic potentials for atomistic simulations (e.g. molecular dynamics) and to reference experimental and first-principles data in order to promote the evaluation of these potentials for particular applications. Depending on the application environments, MGED classifies interatomic potentials into different categories. For example, some interatomic potentials which have been fit only to the properties of metals However, some interatomic potentials will probably better represent properties of the interface properties (e.g. metal-ceramics interfacial properties). Interatomic potentials are currently available for various metals, ionic crystals, semiconductors, metal/semiconductor interface, and solid solution alloys, etc. 
			</p>
			<h5 class="tit_e">About the Materials Genetic Engineering Data (MGED), you should note that: </h5>
			<p>
				We encouraged users to download and use interatomic potentials, with appropriate acknowledgement, and developers are welcome to contribute potentials for inclusion. The potentials provided have been submitted or reviewed by their developers and proper references have been provided. 
			</p>
			<p>
				You may use, copy and distribute copies of the data in any medium, provided that you keep intact this entire notice and reference the website of MGED. You may improve, modify and create derivative works of the database or any portion of the database, and you may copy and distribute such modifications or works. Modified works should carry a notice stating that you changed the data and should note the date and nature of any such change. Please explicitly acknowledge the MGED as the source of the database.
			</p>
			<p>
				If you find this website useful and want to use potentials you downloaded, in addition to the citation information for the proper interatomic potential reference on the web page, please include "Interatomic Potentials Database Part of the Materials Genetic Engineering Data: http://117.121.38.63:9090/InteratomicPotentials/index ". Links are provided to the proper pages to download relevant files.
			</p>
			<p>
				If you have developed a new interatomic potential and want it to be posted, please send the potential to yjsu@ustb.edu.cn with format and citation information. Your interatomic potential will be posted publicly in a newly created prototype page upon the approval of the submitter. 
			</p>
			<p>
				We are not limiting the database to a single interatomic potential format or software package. The provided discrete data tables can be fitted into various function forms. Currently Interatomic Potentials Database supports GULP and LAMMPS (Large-scale Atomic/Molecular Massively Parallel Simulator) software. More information about the "GULP" format is available at http://nanochemistry.curtin.edu.au/gulp/ and LAMMPS is at https://lammps.sandia.gov which is developed and maintained at Sandia National Laboratories. Additionally, we provide the interatomic potentials with appropriate citation information, and it depends on the user to determine what potential format and software to choose. Due to the wide range of interatomic potential functions and formats, it is the user's responsibility to check that the interatomic potentials produce expected results.
			</p>
			<p>
				You are solely responsible for determining the appropriateness of using and distributing the database and you assume all risks associated with its use, including but not limited to the risks and costs of program errors, compliance with applicable laws, damage to or loss of data, programs or equipment, and the unavailability or interruption of operation. This database is not intended to be used in any situation where a failure could cause risk of injury or damage to property.
			</p>
		</div>
		<div class="block">
			<h4 class="tit_m"> About Periodic Table Elements</h4>
			<p>
				Data are recorded from CRC Handbook of Chemistry and Physics, edition 76th (1995-1996).
			</p>
		</div>
		<div class="block">
			<h4 class="tit_m">Contact us</h4>
			<p>
				If you have any questions, please send feedback to <strong>yjsu@ustb.edu.cn</strong> and wait patiently, we will process requests and return results as soon as possible. 
			</p>
		</div>
  </div>
  <script type="text/javascript">
  	$("#li-help").addClass("active");
	$("#li-help").parent("li").removeClass("active");
	$("#li-help").parent("li").siblings().removeClass("active");
	$("#li-help").parent("li").siblings().children("a").removeClass("active");
  </script>
 </body>
 </html>