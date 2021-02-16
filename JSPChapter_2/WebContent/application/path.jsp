<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//application对象 内置对象 不同用户可以共享application中的数据
		//一个应用中只有一个application对象
		//不同用户可以共享application中的数据
		//生命周期：服务器开始，直到服务器关闭，与浏览器无关
		out.print(application.getContextPath());//web应用的项目名称
	%>
	<br>
	<%	
		out.print(application.getRealPath("/"));//项目的绝对路径
	%>
	<br>
	<%	
		out.print(application.getRealPath("path.jsp"));
		application.setAttribute("count", "123");
		//获取名称count的值
		out.print(application.getAttribute("count"));
		
	%>
</body>
</html>