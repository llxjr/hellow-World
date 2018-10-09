<%@page import="com.liu.ciji.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<%
		User user = (User) request.getAttribute("user");
   %>
  <body>
    <form action="UserServlet?op=doupdate" method="post">
    	用户名:<input type="text" name="name" value="<%=user.getName() %>"></br>
    	密 码:<input type="password" name="password" value="<%=user.getPassword() %>"></br>
    	用户id:<input type="text" name="id" value="<%=user.getId() %>"></br>
    	<%
    		if("男".equals(user.getSex())){
    			%>
    	性别:<input type="radio" name="sex" value="男" checked="checked">男
    	<input type="radio" name="sex" value="女">女</br>
    			<%
    		}else{
    			%>
    	性别:<input type="radio" name="sex" value="男">男
    	<input type="radio" name="sex" value="女" checked="checked">女</br>
    			<%
    		}
    	%>
    	
    	杀敌数:<input type="text" name="kills" value="<%=user.getKills() %>"></br>
    	死亡数:<input type="text" name="daths" value="<%=user.getDaths() %>"></br>
    	等级:<input type="text" name="level" value="<%=user.getLevel() %>"></br>
    	<input type="submit" value="更新">
    </form>
  </body>
</html>
