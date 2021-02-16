<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
<!--  mvc 视图层
三层架构  表示层 中前台代码
-->
	<h2>注册页面</h2>
	<form action="RegistServlet" method="post">
		用户名：<input type="text" name="username"><br>
		密码：<input type="password" name="userpwd"><br>
		年龄：<input type="text" name="userage"><br>
		地址：<input type="text" name="uAddress"><br>
		<input type="submit" value="注册"><br>
	</form>
</body>
</html>