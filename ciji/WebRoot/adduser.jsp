<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="UserServlet?op=adduser" method="post">
    	用户名:<input type="text" name="name"></br>
    	用户id:<input type="text" name="id"></br>
    	性别:<input type="radio" name="sex" value="男">男
    	<input type="radio" name="sex" value="女">女</br>
    	杀敌:<input type="text" name="kills"></br>
    	死亡:<input type="text" name="daths"></br>
    	level:<input type="text" name="level"></br>
    	密 码:<input type="password" name="password"></br>
    	<input type="submit" value="添加">
    </form>
  </body>
</html>
