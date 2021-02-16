<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>对象作用域范围</title>
</head>
<body>
	
	<%
		//在各个作用域范围内保存对应属性
		pageContext.setAttribute("pageContext", "page");//当前jsp页面
		request.setAttribute("requestScope", "request");//在一次请求中有效
		session.setAttribute("sessionScope", "session");//在一次会话内有效
		application.setAttribute("applicationScope", "application");//服务器开启到关闭服务器
		//跳转页面
		//request.getRequestDispatcher("scope2.jsp").forward(request,response);
		response.sendRedirect("scope2.jsp");//重定向
	%>
	
		
</body>
</html>