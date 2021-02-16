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
		//String uname = request.getParameter("uname");
		String uname = (String)session.getAttribute("username");
		//判断是否登陆过，在session对象中是否有username
		if(uname == null){
			//跳转登陆页面
			response.sendRedirect("login.jsp");
		}
		
		
		
	%>
	你好·欢迎<%=uname%>
	<br/>
	<a href="logout.jsp">注销</a>
</body>
</html>