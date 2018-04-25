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
	<script type="text/javascript">
	  var contextPath = "<%=request.getContextPath()%>";
	</script>
  </head>
  
  <body>
   <h2>文件上传</h2>
    <form action="manage/uploadPotentialsFile" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td>文件描述:</td>
                <td><input type="text" name="potentialsId"></td>
            </tr>
            <tr>
                <td>请选择文件:</td>
                <td><input type="file" name="potenFile"></td>
            </tr>
            <tr>
                <td><input type="submit" value="上传"></td>
            </tr>
        </table>
    </form>
    
    <a class = "downLoad" href = "<%=basePath%>manage/downloadPotentialsFile?potentialsId=sdfasdasdf">下载</a>

    <a class = "downLoad" href = "<%=basePath%>search/list/tag888">列表</a>
  </body>
</html>
