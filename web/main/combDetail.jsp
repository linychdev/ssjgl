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
<title>Detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1  maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Optometry Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/main/combDetail.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript">
  var contextPath = "<%=request.getContextPath()%>";
</script>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/jmeditor/JMEditor.js"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/js/main/combDetail.js" ></script>

<style type="text/css">
.mathquill-rendered-math {
	font-size: 20px !important;
}
</style>
<!-- //js -->
</head>
	<body>
<!-- //header -->
	<jsp:include page="/header.jsp" flush="true" />
	<div class ="container vpad">
		<div class = "row">
		    <!-- 侧边框 -->
			<div class = "col-md-3">
				<nav class = "sidebar collapse">
					<!-- <a class="btn btn-default btn-lg btn-block sidebar-toggle"
						  data-toggle="collapse" href="#sidebar-nav" aria-expanded="false"
						  aria-controls="sidebar-nav">
						<i class="glyphicon glyphicon-menu-hamburger"></i> Navigation
					</a> -->
					<h3>total potentials</h3>
					<div class="second_left_down">
					<ul class = "sidebar-nav ">
						<c:forEach var="item" items="${allPoten}">
							<strong>${item.key }:</strong>
							<c:forEach items="${item.value}" var="it">   
								<li id = "${it.id }">${it.combName }</li>
							</c:forEach>
						</c:forEach>
					</ul>
					</div>
					
<!-- 第一版没有访问量统计，暂不显示热门搜索和热门下载 	
				<h3>Popular Searches</h3>
					<ul class = "sidebar-nav ">
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
					</ul>
					<h3>Download Rangking</h3>
					<ul class = "sidebar-nav ">
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
						<li><a href = "#">the potential of Ag</a></li>
					</ul> -->
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
				    
						<div class="panel panel-default jiange">
							  <div class="panel-body">
									<h2>
										${combDetail.holeCombName } (${combDetail.elementComb.cCombName})
									</h2>
									<p>
										<strong>Function:</strong>
										<c:forEach items="${combDetail.functions}" var="function" varStatus="fun">
											${function.cFormulaHtml }
											<p />
										</c:forEach>
									</p>
									<c:forEach items="${combDetail.referenceInfos}" var="referenceInfo" varStatus="ref">
										<p>
											<strong>From:</strong>
											<c:choose> 
										     	<c:when test="${referenceInfo.reference.nSource eq 1 }">MGED</c:when>      
										     	<c:otherwise>OTHERS</c:otherwise> 
											</c:choose>
										</p>
										<p>
											<strong>Reference:</strong>
											${referenceInfo.reference.cContent } 
										</p>
										<p>
											<strong>DOI:</strong>
											<a href="http://dx.doi.org/${referenceInfo.reference.cDoi }" target="view_window">${referenceInfo.reference.cDoi }</a>
										</p>
										<p>
											<strong>Notes:</strong>
											${referenceInfo.reference.cNote } 
										</p>
										<p>
											<strong>File(s):  </strong>
											<c:forEach items="${referenceInfo.potentialsFiles}" var="file" varStatus="status">
												<a class = "previewFile" id = "${file.cId }" style = "text-decoration:underline;">${file.cFileName }</a><c:if test="${status.last==false}">&nbsp;</c:if>
											</c:forEach>
										</p>
										<c:if test="${!ref.last}">
											<hr />
										</c:if>
									</c:forEach>
							  </div>
						</div>
				</div>
			</div>
		</div >
	</div>
</body>
</html>