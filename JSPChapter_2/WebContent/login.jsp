<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		用户名:<input type="text" name="uname"><br> 
		密码:<input type="password" name="upwd"><br> 
			<input type="submit" value="登录"><br>
	</form>
	<%
		//读取cookie
		Cookie[] allcookie = request.getCookies();
		//如果为空   创建cookie 进行赋值=时间转化字符串
		if (allcookie == null) {
			//获取当前时间
			Date date = new Date();
			//自定义时间格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
			//Date格式转化为String
			String formatDate = sdf.format(date);
			//创建cookie对象   键值对
			Cookie c = new Cookie("lastLoginTime", formatDate);
			//写入cookie   服务器准备cookie
			response.addCookie(c);
			//输出
			out.write("您是首次登录，欢迎您的访问！<br>登陆时间：" + formatDate);
		} else {
			//获取每个cookie
			for (Cookie c : allcookie) {
				//获取cookie名称
				String name = c.getName();
				//判断是否是符合要求
				if ("lastLoginTime".equals(name)) {
					//获取cookie的值  上次登陆时间
					String lastDate = c.getValue();
					//输出 上次登陆时间
					out.println("上次登录时间：" + lastDate);
					
					//获取当前的日期，保存到cookie中
					Date date = new Date();
					//自定义时间格式
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
					//Date格式转化为String对象
					String formatDate = sdf.format(date);
					//保存到cookie中
					c.setValue(formatDate);
					//写入cookie   服务器准备cookie
					response.addCookie(c);
					//输出 本次登录时间
					out.println("<br>本次登录时间：" + formatDate);
					break;
				}
			}
		}
	%>
</body>
</html>