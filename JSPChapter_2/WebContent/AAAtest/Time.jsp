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
<title>显示当前时间</title>
</head>
<body>
	<%
     //设置响应格式不用写，JSP已经设置了
     //response.setContentType("text/html;charset=utf-8");
     //从请求中获取cookits
     Cookie[] cs = request.getCookies();
     boolean firstFlag = true;
     for (Cookie c : cs) {
         String name = c.getName();
         if ("lastLoginTime".equals(name)){
             firstFlag = false;//不是第一次登录
             //获取上次登录时间
             String lastDate = c.getValue();
             //转换成能够识别码
             lastDate = URLDecoder.decode(lastDate, "utf-8");
             //获取当前时间
             Date date = new Date();
             SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd HH:mm:ss");
             String formatDate = sdf.format(date);
             //tomcat8.0以上可以识别中文字符，但是不能识别特殊字符，因此要进行URL转码
             String URL_Date = URLEncoder.encode(formatDate, "utf-8");
             //将用日期设定的cookit的返回去
             c.setValue(URL_Date);
             //设置存活时间
             c.setMaxAge(60*60*24*30);//缓冲30天
             //
             response.addCookie(c);
             //获取上次的登录时间  ---不用这个，防止打乱布局
             //response.getWriter().write("<h1>欢迎您回来，上次登录时间是：" + lastDate+"</h1>");
 %>
	<h1>
		欢迎您回来，上次登录时间是：<%=lastDate%></h1>

	<%
             break; //已经查到了，就跳出循环
         }
     }
     if (firstFlag){
         //获取当前时间
         Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd HH:mm:ss");
         String formatDate = sdf.format(date);
         //tomcat8.0以上可以识别中文字符，但是不能识别特殊字符，因此要进行URL转码
         String URL_Date = URLEncoder.encode(formatDate, "utf-8");
         Cookie c = new Cookie("lastLoginTime", URL_Date);
         response.addCookie(c);
         //获取上次的登录时间  ---不用这个，防止打乱布局
         //response.getWriter().write("<h1>您是首次登录，欢迎您的访问！</h1>");
 %>//使用JSP的隔断功能，可以穿插html的标签
	<h1>您是首次登录，欢迎您的访问！</h1>
	<%
         out.write("<h1>您是首次登录，欢迎您的访问！</h1>");
     }
 %>

</body>
</html>