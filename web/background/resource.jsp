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
<meta name="viewport" content="width=device-width, initial-scale=1  maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/dataurl.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/background/admin.css" rel="stylesheet" type="text/css" media="all" />
 <link href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" />
 <link href="${pageContext.request.contextPath}/css/log.css" rel="stylesheet" />
 
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/holder.js"></script>
<script src="${pageContext.request.contextPath}/js/default.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/js/background/resource.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/echarts.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
	var potenGroupListJson = ${potenGroupListJson};
</script>
</head>	
<body>	
                <div class="maincontent "> 
			<div class="row">
			<!-- 通过给class 加style="display:none;隐藏DIV -->
            <!--主面板 start-->
            <div class = "col-md-12">
				<blockquote class = "block" >
						网站数据资源统计
				</blockquote>	
			</div>
		    </div>
			</div class="row">
            <div class="col-md-4 " >
					<div class = "figure backimg" >
						<div class ="row">
							<div class = "col-xs-12 ">
								<div class="figure-top">
									函数
								</div>
							</div>
							<div class = "col-xs-12 ">
								<div class="figure-middle">
									${totalFunctioNum }
								</div>
							</div>
						</div>
					</div>
			</div>
			
				<!-- 独立访客数 -->
				<div class="col-md-4 " >
					<div class = "figure">
						<div class = "figure-left">
							<div class = "img1">
							  <div class="img2">
								<img src="${pageContext.request.contextPath}/img/u1391.png"/>
							  </div>
							  <img src="${pageContext.request.contextPath}/img/u1389.png"/>
							</div>
						</div>
						<div class = " figure-right">
							<div class = "row">
								<div class = "col-xs-12 ">
									<div class="figure-top1">
										势数据
									</div>
								</div>
								<div class = "col-xs-12 ">
									<div class="figure-middle1">
										${totalPotenNum }
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- IP -->
				<div class="col-md-4 ">
					<div class = "figure">
						<div class = "  figure-left">
							<div class = "img1">
							  <div class="img2">
								<img src="${pageContext.request.contextPath}/img/u1415.png"/>
							  </div>
							  <img src="${pageContext.request.contextPath}/img/u1413.png"/>
							</div>
						</div>
						<div class = " figure-right">
							<div class = "row">
								<div class = "col-xs-12 ">
									<div class="figure-top1">
										势文件
									</div>
								</div>
								<div class = "col-xs-12 ">
									<div class="figure-middle1">
										${totalFileNum }
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-12 up" >
					<div class="trend">
							<div class="trendFigure" id="resourceFigure">	
							</div>
					</div>
				</div>
				
			</div>		
        </div>
</body>
</html>