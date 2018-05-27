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
  <jsp:include page="/header.jsp" flush="true" />
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
