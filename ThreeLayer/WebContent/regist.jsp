<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="RegistServlet" method="post">
			用户名：<input type="text" name="username"><br>
			密码：<input type="password" name="userpwd"><br>
			年龄：<input type="text" name="age"><br>
			<!-- 地址：<input type="text" naem="uAddress"><br> -->
			<input type="submit" value=“注册”>
		</form>
</body>
</html>