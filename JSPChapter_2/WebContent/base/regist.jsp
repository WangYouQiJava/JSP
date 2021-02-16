<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<h3>注册</h3>
	<form action="regInfo.jsp" method="post">
		用户名:<input type ="text" name = "uname"><br>
		密码:<input type ="text" name = "upwd"><br>
		
		信息来源：<input type="checkbox" name="source" value="TV">电视
				  	<input type="checkbox" name="source" value="netWork">网络
				 		<input type="checkbox" name="source" value="by friends.">朋友推荐
				 			<input type="checkbox" name="source" value="Newspaper">报刊
				 <input type="submit" value="注册">
	</form>
</body>
</html>