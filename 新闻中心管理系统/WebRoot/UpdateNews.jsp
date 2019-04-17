<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DaoFactory.DaoFactory"%>
<%@page import="java.util.List" %>
<%@page import="Bean.Newsdetail" %>
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
<title>编辑新闻</title>
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
			<td><a href='Syslogin.jsp'>系统登录</a></td>
			<td><a href='homepage.jsp'>新闻主页</a></td>
		</tr>
	<form id="NewsdetailForm" action="NewsdetailServlet?method=update" name="newsdetail" method="post">
	<table align="center">
		<h2>编辑新闻</h2>

		<tr>
			<td>新闻标题：</td>
			<td><input type="text" style="width: 500px;" name="title" value="${newsdetail.title}"></td>
		</tr>
		<tr>
			<td>新闻内容：</td>
			<td><textarea name="content" cols="60" rows="20"  >${newsdetail.content}</textarea></td>
		</tr>
		<tr>
			<td>新闻类型：</td>
			<td><input type="text" style="width: 200px;" name="type" value="${newsdetail.type}"></td>
		</tr>
		<tr>
			<td>新闻作者：</td>
			<td><input type="text" style="width: 200px;" name="author" value="${newsdetail.author}"></td>
		</tr>
		<tr>
			<td></td>
			<td align="right"><input type="submit" value="提交"></td>
		</tr>
	</table>
			<input type="hidden" name=id value="${newsdetail.id}">
			<input type="hidden" name=time value="${news.time}">
	</form>
</center>
</body>
</html>