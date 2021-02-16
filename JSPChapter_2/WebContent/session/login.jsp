<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 获取cookie，判断username -->
	<%
	 String username = "";
	//读取所有cookie，返回cookie数组
	Cookie[] cookies = request.getCookies();
	//遍历cookies数组
	if(cookies != null){
		for(int i =0;i<cookies.length;i++){
			Cookie cookie = cookies[i];
			//根据cookie名词进行判断
			if(cookie.getName().equals("username")){//cookie中有用户名，表示登陆过
				//如果能够读取到名称为username的cookie就意味着已经登陆过
				//就不能在进行登陆验证，之后转到欢迎页面
				response.sendRedirect("welcome.jsp");
				return;
			}
		}
	}
	%>
	<h3>登录</h3>
	<form action="control.jsp" method="get">
		用户名:<input type="text" name="uname"><br> 密码:<input
			type="password" name="upwd"><br> <input type="checkbox"
			name="saveMessage">30秒内自动登录<br> <input type="submit"
			value="登录"><br>
	</form>
</body>
</html>