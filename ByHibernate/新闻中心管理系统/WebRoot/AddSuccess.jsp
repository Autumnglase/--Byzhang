<%@page import="DaoFactory.DaoFactory"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="java.sql.*"%>
<%@page import="java.util.List" %>
<%@page import="Bean.Newsdetail" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" />
<base href="<%=basePath%>">
<title>添加新闻成功</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">    
<img src="img/bg.jpg" height=100%  width="100%" style="left"; top:0;>   
</div>
<center>
	<h2>添加成功！</h2>
	<form id="NewsdetailForm" action="" name="newsdetail" method="post">
	<table align="center">
			<h2>所有新闻列表</h2>
			<td style="width: 150px;">新闻标题</td>
			<td align="center" style="width: 150px;">新闻作者</td>
			<td align="center" style="width: 150px;">新闻分类</td>
			<td align="center" style="width: 150px;">发布时间</td>
			<%
		//获取request中的数据
		List<Newsdetail> lists=DaoFactory.getNewsdetailDaoInstance().findAll();
		for(Newsdetail newsdetail:lists){
	%>
		<tr>
			<td style="width: 150px;"><%=newsdetail.getTitle() %></td>
			<td align="center" style="width: 150px;"><%=newsdetail.getAuthor() %></td>
			<td align="center" style="width: 150px;"><%=newsdetail.getType() %></td>
			<td align="center" style="width: 150px;"><%=newsdetail.getTime() %></td>
		</tr>
	
	<%		
		}
	 %>

	</table><br>
	<a href='AddNews.jsp'>继续添加</a>
	<a href='ContentMan.jsp'>返回操作页面</a>
	</form>
</center>
</body>
</html>