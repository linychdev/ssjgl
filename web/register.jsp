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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	  var contextPath = "<%=request.getContextPath()%>";
	</script>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/register.js"></script>
  </head>
  
  <body>
	<center>
        <h1 style="color:red">注册</h1>
            <form id="indexform" name="indexForm" action="register/regist" method="post">
                <table border="0">
                    <tr>
                        <td>账号：</td>
                        <td><input id = "register_login_name" type="text" name="username" onchange="checkname()"></td>
                        <td id = "check_name_reminder"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="name">
                        </td>
                    </tr>
                    <tr>
                        <td>邮箱：</td>
                        <td><input id = "emailAddress" type="text" name="email">
                        </td>
                    </tr>
                    <tr>
                        <td>电话：</td>
                        <td><input type="text" name="phone">
                        </td>
                    </tr>
                    <tr>
                        <td>验证码：</td>
                        <td><input type="text" name="vercode">
                        </td>
                    </tr>
                </table>
            <br>
                <div id = "sendVerCode"><a href="javascript:void(0)">发送验证码</a></div>
                <input type="submit" value="注册" style="color:#BC8F8F">
            </form>
    </center>
  </body>
</html>
