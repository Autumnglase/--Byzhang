<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" />
<title>添加新闻</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">    
<img src="img/bg.jpg" height=100%  width="100%" style="left"; top:0;>   
</div>
<center>
<h1 style="margin-top:80px">新闻管理系统</h1>
	<tr>
		<td>选择操作:&nbsp;&nbsp;</td>
	</tr>
		<tr>
			<td><a href='AllNews.jsp'>所有新闻</a></td>
			<td><a href='AddNews.jsp'>添加新闻</a></td>
			<td><a href='homepage.jsp'>新闻主页</a></td>
		</tr>
	<form id="NewsdetailForm" action="NewsdetailServlet?method=add" name="newsdetail" method="post">
	<table align="center">
		<h2>添加新闻</h2>
		<tr>
			<td>新闻标题：</td>
			<td><input type="text" style="width: 500px;" name="title"></td>
		</tr>
		<tr>
			<td>新闻内容：</td>
			<td><textarea name="content" cols="60" rows="20"></textarea></td>
		</tr>
		<tr>
			<td>新闻类型：</td>
			<td><input type="text" style="width: 200px;" name="type"></td>
		</tr>
		<tr>
			<td>新闻作者：</td>
			<td><input type="text" style="width: 200px;" name="author"></td>
		</tr>
		<tr>
			<td></td>
			<td align="right"><input type="submit" value="添加"> <input type="reset" value="清空" /></td>
		</tr>
	</table>
	</form>
</center>
</body>
</html>