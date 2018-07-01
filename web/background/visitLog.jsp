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
<script src="${pageContext.request.contextPath}/js/background/visitLog.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/echarts.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
	var ymlllListJson = ${ymlllListJson};
	var beginDate = ${beginDate};
	var endDate = ${endDate};
</script>
</head>	
<body>	
        <div class="maincontent "> 
			<div class="row">
			<!-- 通过给class 加style="display:none;隐藏DIV -->
            <!--主面板 start-->
            <div class = "col-md-2">
				<blockquote class = "block" >
						访问量指标
				</blockquote>	
			</div>
			<div class = "col-md-4 col-md-offset-6">
				<div class = "dateSelect">
				  <div class="layui-form-item" style = "width: 600px;">
				     <div class="layui-inline" style = "float:right; margin-right: 0px;">
				          <label class="layui-form-label">开始时间</label>
					      <div class="layui-input-inline">
					        <input type="text" class="layui-input" id="begin-date" >
					      </div>
				          <label class="layui-form-label">结束时间</label>
					      <div class="layui-input-inline" style = "margin-right: 0px;">
					        <input type="text" class="layui-input" id="end-date" style= "margin-right: 0px;">
					      </div>
					    </div>
				    </div>
				</div>
			</div>
            <div class="col-md-4 " >
					<div class = "figure" >
						<div class ="row">
							<div class = "col-xs-12 ">
								<div class="figure-top">
									页面浏览量
								</div>
							</div>
							<div class = "col-xs-12 ">
								<div class="figure-middle">
									${ymlll }
								</div>
							</div>
							<div class = "col-xs-12 figure-bottom">
								<img src="${pageContext.request.contextPath}/img/u1449.png" class="img"></img>
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
										独立访问者数量
									</div>
								</div>
								<div class = "col-xs-12 ">
									<div class="figure-middle1">
										${dlipfwl }
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
										重复访问者数量
									</div>
								</div>
								<div class = "col-xs-12 ">
									<div class="figure-middle1">
										${syfwl }
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 内容总浏览量 -->
				 <div class = "col-md-12 up">
					<blockquote class = "block" >
						页面访问量趋势曲线
					</blockquote>	
				</div>
			</div>	
					<div class = "row">
						<div class="trend">
							<div class="trendFigure" id="trendFigure">
								
							</div>
						</div>
					</div>
				
        </div>
</body>
</html>