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
<meta name="viewport" content="width=device-width, initial-scale=1  maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Optometry Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/list.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript">
  var contextPath = "<%=request.getContextPath()%>";
</script>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/jmeditor/JMEditor.js"></script>

<style type="text/css">
.mathquill-rendered-math {
	font-size: 20px !important;
}
</style>
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
					
	<div class ="container vpad">
		<div class = "row">
		    <!-- 侧边框 -->
			<div class = "col-md-3">
				<nav class = "sidebar collapse">
					<a class="btn btn-default btn-lg btn-block sidebar-toggle"
						  data-toggle="collapse" href="#sidebar-nav" aria-expanded="false"
						  aria-controls="sidebar-nav">
						<i class="glyphicon glyphicon-menu-hamburger"></i> Navigation
					</a>
					<h3>resources</h3>
					<ul class = "sidebar-nav ">
						<li><a href = "#">Semiconductors</a></li>
						<li><a href = "#">Ionic Crystals</a></li>
						<li><a href = "#">Interface</a></li>
						<li><a href = "#">Metal Alloys</a></li>
						<li><a href = "#">Others </a></li>
					</ul>
					<h3>Popular Searches</h3>
					<ul class = "sidebar-nav ">
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
					</ul>
					<h3> Rangking List For Download</h3>
					<ul class = "sidebar-nav ">
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
					</ul>
				</nav>
			</div>
			<!-- 主体右侧内容 -->
			<div class = "col-md-9">
				<div class = "content">
					<p>
					Note that elemental potentials taken from alloy descriptions may not work well for the pure species. This is particularly true if the elements were fit for compounds instead of being optimized separately. As with all interatomic potentials, please check to make sure that the performance is adequate for your problem.
					</p>
					<c:forEach items="${combList}" var="comb" varStatus="id">  
						<span class="label "><a href = "#">${comb.elementComb.cCombName}</a></span>
				    </c:forEach> 
				    
					<c:forEach items="${combDetailList}" var="combDetail" varStatus="id">  
						<div class="panel panel-default jiange">
							  <div class="panel-body">
									<h2>
										${combDetail.holeCombName } (${combDetail.elementComb.cCombName})
									</h2>
									<p>
										<strong>Function:</strong>
										<c:forEach items="${combDetail.functions}" var="function" varStatus="id">
											${function.cFormulaHtml }
										</c:forEach>
									</p>
									<c:forEach items="${combDetail.referenceInfos}" var="referenceInfo" varStatus="id">
										<p>
											${referenceInfo.reference.cContent } DOI: ${referenceInfo.reference.cContent.cDoi } 
										</p>
										<p>
											<strong>Notes:</strong>
											${referenceInfo.reference.cNote } 
										</p>
										<strong>File(s):  </strong>
										<c:forEach items="${referenceInfo.potentialsFiles}" var="file" varStatus="id">
											<a href = "#">${file.cFileName }</a>
										</c:forEach>
										<p>
											<strong>Format:</strong>
											<a href = "#">Moldy FS</a>
										</p>
									</c:forEach>
									<c:forEach items="${combDetail.referenceInfos}" var="referenceInfo" varStatus="id">
										<!-- 分割线 -->
										 <hr>
										<c:if test="${referenceInfo.reference.nSource eq 2}">
											<p>
												${referenceInfo.reference.cContent } DOI: ${referenceInfo.reference.cContent.cDoi } 
											</p>
											<p>
												<strong>Notes:</strong>
												${referenceInfo.reference.cNote } 
											</p>
											<strong>File(s):  </strong>
											<c:forEach items="${referenceInfo.potentialsFiles}" var="file" varStatus="id">
												<a href = "#">${file.cFileName }</a>
											</c:forEach>
										</c:if>
										<p>
											<strong>Format:</strong>
											<a href = "#">Moldy FS</a>
										</p>
									</c:forEach>
									 
							  </div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div >
	</div>

</body>
	

</html>