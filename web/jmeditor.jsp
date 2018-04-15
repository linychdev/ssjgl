<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="jmeditor/JMEditor.js"></script>
	<script type="text/javascript" src="js/functionEditor.js"></script>
	<style type="text/css">
	.editDemo{
		border:solid #AAA 1px;
		min-height:100px;
		width:90%;
		padding:10px;
	}
	.editDemo p span{
		font-size: 40px !important;
	}
	</style>
	
	
  </head>
  
  <body>
  	<div class="container">
		<div class="body">
			<div class="content">
					<div id="content" contentEditable="true" class="editDemo">
					</div>
					<p>
						<input type="button" onclick="addfunconfirm(this)" value="确认">
					</p>
			</div>
			<div class="floatdown">
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;免责声明<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;您下载本软件，即表示您完全接受本声明。<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;如您认为本软件某部分功能有侵权嫌疑，请立即通知我们，JMEditor将在第一时间更改或删除。<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;本软件为非盈利性质，您可以免费下载、学习、交流。在任何发布的版本中，本声明不能删除或更改。本软件严禁用于任何形式的商业用途。<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;对于使用本软件的结果，您需要自行承担风险。如果造成任何的不利后果，本站概不负责，也不承担任何法律责任。请慎重选择！<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;此声明最终解释权归本软件作者所有。<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;Copyright &copy; 2012-2015 JMEditor 版权所有 jmeditor@163.com
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
