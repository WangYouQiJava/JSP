<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.test.dao.impl.UserDaoImpl,com.test.dao.IUserDao"%>
<%@ page import="com.test.entity.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//设置请求数据编码
			request.setCharacterEncoding("utf-8");
			//获取请求数据
			String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");
			
			//创建用户对象
			User user = new User(uname,upwd);
			// dao database access object
			//判断用户名和密码是否正确  连接数据库查询
			
			//创建对象
			IUserDao userDao = new UserDaoImpl();//多态
			//是否存在该用户
			boolean flag = userDao.checkUser(user);
			
			System.out.println(flag);
			//根据标记判断跳转页面
			if(flag == true){
		//请求案发  保留请求数据 1次 地址栏不变
		request.getRequestDispatcher("welcome.jsp").forward(request,response);
			}else{
		//密码错误    跳转   
		//重定向 不保留数据 2次
		response.sendRedirect("error.jsp");
			}
			
			//处理请求数据
			/*if("lucky".equals(uname)&&"123456".equals(upwd)){//判断用户名和密码是否正确
		//响应给客户端
		//跳转页面  欢迎页面  response对象
		//重定向
		//response.sendRedirect("welcome.jsp");
		//请求转发  一次请求
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}else{
		//用户名或密码错误
		response.sendRedirect("login.jsp");
			}*/
	%>

</body>
</html>