<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取各个作用域属性的值</title>
</head>
<body>
	<%-- <%
		pageContext.getAttribute("pageContext");
		request.getAttribute("requestContext");
		session.getAttribute("sessionScope");
		application.getAttribute("application");
	%> --%>
		page作用域中pageContext的值：<%=pageContext.getAttribute("pageContext") %>
		<br>
		request作用域中requestContext的值：<%=request.getAttribute("requestContext") %>
		<br>
		session作用域中sessionContext的值：<%=session.getAttribute("sessionScope") %>
		<br>
		application作用域中applicationContext的值：<%=application.getAttribute("applicationScope") %>
</body>
</html>