<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
	    <title>用户登录</title>
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
  	</head>
  	<body>
  		<form action="${pageContext.request.contextPath}/userServlet?action=login" method="post">
  			<table>
  				<tr>
  					<td>用户名：</td>
  					<td><input type="text" name="username" value="" /></td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>密&nbsp;&nbsp;码：</td>
  					<td><input type="password" name="password" value="" /></td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>验证码：</td>
  					<td><input type="text" name="captcha" value="" /></td>
  					<td><img src="" title="" onclick="" /></td>
  				</tr>
  				<tr>
  					<td></td>
  					<td><input type="submit" value="登录" /></td>
  					<td></td>
  				</tr>
  			</table>
  		</form>
  	</body>
</html>