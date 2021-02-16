<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
</head>
<body>
	<h2>注册成功</h2><br>
	用户名：<%= session.getAttribute("username")%><br>
	密码：<%= session.getAttribute("userupwd")%><br>
	年龄：<%= session.getAttribute("userage")%><br>
	地址：<%= session.getAttribute("useraddress")%>
	
</body>
</html>