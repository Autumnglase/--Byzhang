<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="favicon.ico" />
<title>管理员登录</title>
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">    
<img src="img/bg.jpg" height=100%  width="100%" style="left"; top:0;>   
</div>
<center>
<h1 style="margin-top:80px">新闻管理系统</h1>
	温馨提示：请先登录系统
	<form id="NewsdetailForm" action="NewsdetailServlet?method=login" name="newsdetail" method="post">
	<table align="center">
		<h2>管理员登录</h2>
		<tr>
			<td>管理员账号：</td>
			<td><input type="text" style="width: 200px;" name="adminname"></td>
		</tr>
		<tr>
			<td>管理员密码：</td>
			<td><input type="password" style="width: 200px;" name="adminpass"></td>
		</tr>
		<tr>
			<td></td>
			<td align="right"><input type="submit" value="登录"></td>
		</tr>
	</table>
	</form>
</center>
</body>
</html>