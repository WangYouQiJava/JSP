<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取session中数据</title>
</head>
<body>
	<% 
		Object aValue = (String)session.getAttribute("a");//通过名称取值
		int bValue = (Integer)session.getAttribute("b");
	%>
	session中a的值是：<%=aValue %>
	<br>
	session中b的值是：<%=bValue %>
	<br>
	session对象的sessionId的值<%=session.getId() %>
</body>
</html>