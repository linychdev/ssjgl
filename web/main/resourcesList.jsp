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
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/main/resources.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main/echarts.simple.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main/echarts-wordcloud.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main/combList.js"></script>

<script type="text/javascript">
  var contextPath = "<%=request.getContextPath()%>";
</script>
<!-- //js -->
</head>
	
<body>
  <jsp:include page="/header.jsp" flush="true" />
  	<div class  = "wrap ">
	  <div  class="resources_list">
		<blockquote>
				<p> Total Potentials</p>
		</blockquote>
	    <div class="panel-group" id="accordion">
	         <div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" 
							href="#collapseOne">
							<span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
							<strong>Ionic Crystals</strong>
						</a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in">
					<div class="panel-body reset_panel_body">
							<c:forEach var="item" items="${allPoten}">
								<c:if test="${item.key == 'Ionic Crystals' }">
									<c:forEach items="${item.value}" var="it" varStatus="status">   
										<span class="label-define"  id = "${it.id }">${it.combName }</span>
									</c:forEach>
								</c:if>
							</c:forEach>
				    </div>
				</div>
			</div>
	<div class="panel panel-success">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
					<span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
				    <strong>Semiconductors</strong>
				</a>
			</h4>
		</div>
		<div id="collapseTwo" class="panel-collapse collapse in">
			<div class="panel-body reset_panel_body">
					<c:forEach var="item" items="${allPoten}">
						<c:if test="${item.key == 'Semiconductors' }">
						   <c:forEach items="${item.value}" var="it" varStatus="status">   
										<span class="label-define"  id = "${it.id }">${it.combName }</span>
									</c:forEach>
						</c:if>
					</c:forEach>
			</div>
		</div>
	</div>
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
					<span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
					<strong>Interface</strong>
				</a>
			</h4>
		</div>
		<div id="collapseThree" class="panel-collapse collapse in">
			<div class="panel-body reset_panel_body">
					<c:forEach var="item" items="${allPoten}">
						<c:if test="${item.key == 'Interface' }">
						    <c:forEach items="${item.value}" var="it" varStatus="status">   
										<span class="label-define"  id = "${it.id }">${it.combName }</span>
									</c:forEach>
						</c:if>
					</c:forEach>
			</div>
		</div>
	</div>
	<div class="panel panel-warning">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
					<span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
					<strong>Metal Alloys </strong>
				</a>
			</h4>
		</div>
		<div id="collapseFour" class="panel-collapse collapse in">
			<div class="panel-body reset_panel_body">
					<c:forEach var="item" items="${allPoten}">
						<c:if test="${item.key == 'Metal Alloys' }">
						    <c:forEach items="${item.value}" var="it" varStatus="status">   
										<span class="label-define"  id = "${it.id }">${it.combName }</span>
									</c:forEach>
						</c:if>
					</c:forEach>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapseFive">
					<span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
					<strong>Others </strong>
				</a>
			</h4>
		</div>
		<div id="collapseFive" class="panel-collapse collapse in">
			<div class="panel-body reset_panel_body">
					<c:forEach var="item" items="${allPoten}">
						<c:if test="${item.key == 'Others' }">
						    <c:forEach items="${item.value}" var="it" varStatus="status">   
										<span class="label-define"  id = "${it.id }">${it.combName }</span>
									</c:forEach>
						</c:if>
					</c:forEach>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
 	$(function () { $('#collapseOne').collapse({
		toggle: false
	})});
	$(function () { $('#collapseTwo').collapse({
		toggle: false
	})});
	$(function () { $('#collapseThree').collapse({
		toggle: false
	})});
	$(function () { $('#collapseFour').collapse({
		toggle: false
	})});
	$(function () { $('#collapseFive').collapse({
		toggle: false
	})});
</script>  
   </div>
  </div>
</body>
</html>
