<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册信息</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		//获取请求数据
		//用户名
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		//获取信息来源数据
		String[] source = request.getParameterValues("source");
	%>
		<h3>注册信息</h3>
		用户名：<%=uname %>
		<br>
		密码：<%=upwd %>
</body>
</html>