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
	<style type="text/css">
	.mathquill-rendered-math {
		font-size: 40px !important;
	}
	</style>
  </head>
  
  <body>
	<p><span class="mathquill-rendered-math" style="font-size:20px;"><span class="textarea"><textarea data-cke-editable="1" contenteditable="false"></textarea></span><big mathquill-command-id="4">∑</big><sup class="non-leaf" mathquill-command-id="6" mathquill-block-id="7"><var mathquill-command-id="15">a</var></sup><sub class="non-leaf" mathquill-command-id="9" mathquill-block-id="11" style="left: -0.5em; margin-right: -0.4em;"><var mathquill-command-id="10">n</var><span class="binary-operator" mathquill-command-id="12">=</span><span mathquill-command-id="16">2</span></sub><span mathquill-command-id="17" class="binary-operator">+</span><span mathquill-command-id="18" class="non-italicized-function">ln</span><var mathquill-command-id="20">e</var><big mathquill-command-id="21">∫</big><sub class="non-leaf limit" mathquill-command-id="23" mathquill-block-id="24" style="left: -0.25em;"><span mathquill-command-id="29">1</span></sub><sup class="non-leaf limit" mathquill-command-id="26" mathquill-block-id="27" style="left: -0.5625em; margin-right: -0.4em;"><span mathquill-command-id="30">3</span></sup></span><span>&nbsp;</span>​<br></p>
  </body>
</html>
