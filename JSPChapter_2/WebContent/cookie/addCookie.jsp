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
		//cookie由服务器端产生，保存在客户端的某个文件中
		//创建cookie对象   键值对
		Cookie cookie = new Cookie("a","123");
		//设置cookie有效期   超过有效期，删除cookie
		cookie.setMaxAge(60);//单位是秒
		//写入cookie    服务器准备cookie
		response.addCookie(cookie);
		//响应
		//response.sendRedirect("showCookie.jsp");//重定向
		request.getRequestDispatcher("showCookie.jsp").forward(request, response);
	%>
</body>
</html>