<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" />
<title>查询新闻</title>
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
				<td><a href='AllNewsMan.jsp'>所有新闻</a></td>
				<td><a href='ContentMan.jsp'>后台管理</a></td>
			</tr>
		</table>
		<br>
		<form id="NewsdetailForm"
			action="NewsdetailServlet?method=findByKeywordMan" name="newsdetail"
			method="post">
			请输入关键字: <input type="text" name="keyword"><br>
			<tr>
				<td align="right"><input type="submit" value="搜索"></td>
			</tr>
		</form>
	</center>
</body>
</html>