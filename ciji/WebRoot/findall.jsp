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
    
    <title>My JSP 'findall.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script rel="stylesheet" type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("button").click(function(){
				//1.获取选中的复选框的值
				var ids = new Array();
				$("table input[type=checkbox]:checked").each(function(index){
					//2.将值存入数组
					ids[index]=$(this).val();
				});
				//3.将数据传到后台
				window.location.href="UserServlet?op=deletemore&ids="+ids;
			});
		});
	</script>
  </head>
   <%
  	//从域中获取数据
  	List<User> list =  (List<User>)request.getAttribute("list");
   %>
  <body>
  <center style="margin-top: 170px">
  	<form action="UserServlet?op=searchsuser" method="post">
  		<input name="name">
		<input type="submit" value="根据名字模糊查询">  	
  	</form>
  	</br>
	  <button>删除所选</button>
    </br>
	<table border="1">
    	<tr>
    		<th>选择</th>
    		<th>名字</th>
    		<th>密码</th>
    		<th>id</th>
    		<th>性别</th>
    		<th>杀敌数</th>
    		<th>死亡数</th>
    		<th>等级</th>
    		<th>操作</th>
    	</tr>
    	<!-- 接下来的行应该是域中的集合中遍历得到的 -->
    	<%
    		for(User user:list){
    			%>
    		<tr>
    			<td><input type="checkbox" name="ids" id="ids" value="<%=user.getId() %>"></td>
    			<td><%=user.getName() %></td>
    			<td><%=user.getPassword() %></td>
    			<td><%=user.getId() %></td>
    			<td><%=user.getSex() %></td>
    			<td><%=user.getKills() %></td>
    			<td><%=user.getDaths() %></td>
    			<td><%=user.getLevel()%></td>
    			<td>
    				<a href="UserServlet?op=deleteuser&id=<%=user.getId() %>" onclick = 'return confirm("确认要删除吗？");'>删除</a>
    				<a href="UserServlet?op=findbyid&id=<%=user.getId() %>">修改</a>
    			</td>
    		</tr>
    				
    			<%
    		}
    	 %>
    </table>
    </center>
  </body>
</html>
