<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session会话</title>
</head>
<body>
	<%
		//session 内置对象 服务器产生 储存在服务器端
		//session原理
		//session提供方法
		//session中储存的是Object类型
		session.setAttribute("a", "123");
		session.setAttribute("b", 456);
		//session失效   1、手动失效   2、超时失效
		//session.setMaxInactiveInterval(20);
		session.invalidate();//手动失效 应用在注销、登陆
		//跳转
		response.sendRedirect("getSession.jsp");
	%>
</body>
</html>