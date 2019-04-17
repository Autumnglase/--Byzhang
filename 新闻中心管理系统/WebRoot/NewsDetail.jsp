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
<title>新闻详细信息</title>
<style>
div {
	text-align: justify
}
</style>
</head>
<body>
	<div id="Layer1"
		style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">
		<img src="img/bg.jpg" height=100% width="100%" style="left"; top:0;>
	</div>
	<center>
		<h1 style="margin-top:80px">新闻管理系统</h1>
		<table border="0" cellpadding="20" cellspacing="3">
			<tr>
				<td><a href='AllNews.jsp'>所有新闻</a></td>
				<td><a href='QueryNews.jsp'>搜索新闻</a></td>
				<td><a href='Syslogin.jsp'>后台管理</a></td>
			</tr>
		</table>
	</center>

	<form id="NewsdetailForm" action="" name="newsdetail" method="post">
		<h2 align="center">新闻详细内容</h2>
		<div>
			新闻标题：${newsdetail.title}<br>
			<br>
			作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：${newsdetail.author}<br>
			<br> 新闻分类：${newsdetail.type}<br>
			<br> 分布时间：${newsdetail.time}<br>
			<br> 新闻内容：${newsdetail.content}<br>
			<br>
		</div>
		<a  href='AllNewsMan.jsp'>返回</a>
	</form>

</body>
</html>