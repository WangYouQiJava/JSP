<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面</title>
</head>
<body>
	<%
		//设置请求数据的编码
		request.setCharacterEncoding("utf-8");
		//获取请求数据
		String uname = request.getParameter("uname");
		String username = request.getParameter("uname");
		//读取所有cookie，返回cookie数组
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().equals("username")) {
				username = cookie.getValue();
			}
		}
	%>
	你好·欢迎<%=username%>
</body>
</html>