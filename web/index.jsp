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
	<script type="text/javascript" src="js/jmeditor/JMEditor.js"></script>
  </head>
  
  <body>
	<p><span class="mathquill-rendered-math" style="font-size:20px;"><span class="textarea"><textarea data-cke-editable="1" contenteditable="false"></textarea></span><big mathquill-command-id="14">∑</big><sup class="non-leaf" mathquill-command-id="16" mathquill-block-id="17"><var mathquill-command-id="26">n</var></sup><sub class="non-leaf" mathquill-command-id="19" mathquill-block-id="21" style="left: -0.5em; margin-right: -0.4em;"><var mathquill-command-id="20">n</var><span class="binary-operator" mathquill-command-id="22">=</span><span mathquill-command-id="25">1</span></sub></span><span>&nbsp;</span>​<br></p>
  </body>
</html>
