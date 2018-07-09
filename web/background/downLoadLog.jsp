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
<script src="${pageContext.request.contextPath}/js/background/downLoadLog.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/echarts.js"></script>
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath()%>";
	var tjqDownLoadListJson = ${tjqDownLoadListJson};
    var beginDate = ${beginDate};
	var endDate = ${endDate};
    var record = ${pageData.record};
    var pageIndex = ${pageData.pageIndex};
    var pageSize = ${pageData.pageSize};
</script>
</head>	
<body>	
 		<div class="maincontent "> 
			<div class="row">
			<!-- 通过给class 加style="display:none;隐藏DIV -->
            <!--主面板 start-->
				<div class = "col-md-2">
					<blockquote class = "block" >
						势数据下载量统计
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
			</div>	
		    <div class="row">
				<div class="col-md-12">
					<div class="downloadcount">
						<div class="downloadTotal">
							累计势数据下载量
						</div>
						<div class="downloadTotalNo">
							${totalDownLoadNum}
						</div>
						<div class="downloadTotal">
							统计期内势数据下载量
						</div>
						<div class="downloadTotalNo">
							${tjqDownLoadNum}
						</div>
					</div>
					<div class="downloadtrend" >
						<div class="trendFigure" id="downlodadFigure">
								
						</div>
					</div>
				</div>	
			</div>
			<div class="row">
				<div class="col-md-12 bartop">
				<table class="table table-bordered">
					<tr>
						<td class="tdbg">
							排名
						</td>
						<td class="tdbg">
							势数据名称
						</td>
						<td class="tdbg">
							文件大小(K)
						</td>
						<td class="tdbg">
							下载量
						</td>
					</tr>
					<c:forEach items="${pageData.dataList}" var="downloadLog" varStatus="status">
						<tr>
							<td >
								${downloadLog.rownum }
							</td>
							<td >
								${downloadLog.fileName }
							</td>
							<td >
								${downloadLog.size }
							</td>
							<td >
								${downloadLog.downLoadTimes }
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class = "col-md-8 col-md-offset-4 " id = "downLoadLog-paging-div" >
	
	        </div>
        </div>
	</div>
</body>
</html>