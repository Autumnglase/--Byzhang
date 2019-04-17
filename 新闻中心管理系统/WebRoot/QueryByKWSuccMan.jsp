<%@page import="DaoFactory.DaoFactory"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="Bean.Newsdetail"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" />
<base href="<%=basePath%>">
<title>查询结果</title>
</head>
<body>
	<div id="Layer1"
		style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">
		<img src="img/bg.jpg" height=100% width="100%" style="left"; top:0;>
	</div>
	<center>
		<h1 style="magin-top:60px">新闻管理系统</h1>
		<table border="0" cellpadding="20" cellspacing="3">
			<tr>
				<td>选择操作:&nbsp;&nbsp;</td>
				<td><a href='AllNewsMan.jsp'>所有新闻</a></td>
				<td><a href='QueryNewsByMan.jsp'>搜索新闻</a></td>
				<td><a href='ContentMan.jsp'>后台管理</a></td>
			</tr>
		</table>
		<br>

		<table>
			<h2>搜索结果</h2>
			<td>新闻标题</td>
			<td>新闻作者</td>
			<td>新闻分类</td>
			<td>发布时间</td>
		</table>
		<table align="center">

			<tr>
				<td style="width: 150px;"><a
					href="NewsdetailServlet?method=showdetail&id=${newsdetail.id}">${newsdetail.title}</a></td>
				<td align="center" style="width: 150px;">${newsdetail.author}</td>
				<td align="center" style="width: 150px;">${newsdetail.type}</td>
				<td style="width: 150px;">${newsdetail.time}</td>
				<td align="center" style="width: 100px;"><a
					href="NewsdetailServlet?method=updatecontent&id=${newsdetail.id}">编辑</a>
				</td>
				<td align="center" style="width: 100px;"><a
					href="NewsdetailServlet?method=delete&id=${newsdetail.id}"
					onclick="return confirm('确认删除？')">删除</a></td>
			</tr>

		</table>
		<br> <a href='homepage.jsp'>退出登陆</a>
	</center>
</body>
</html>