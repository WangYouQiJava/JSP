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
		//读取cookie
		Cookie[] allcookie = request.getCookies();
		//获取每个cookie
		if(allcookie != null){
			for(Cookie c : allcookie){
				out.print(c.getName()+":"+c.getValue()+"<br>");
			}
		}
	%>
</body>
</html>