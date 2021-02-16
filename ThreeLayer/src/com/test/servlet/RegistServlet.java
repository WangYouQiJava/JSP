package com.test.servlet;

import java.io.IOException;
/**
 * 
 * 三成架构  表示层中前台代码
 */
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.test.dao.impl.UserDaoImpl;
import com.test.entity.User;
import com.test.service.impl.UserServiceImpl;
@WebServlet(urlPatterns="/RegistServlet")
public class RegistServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		String uname=req.getParameter("username");
		String upwd=req.getParameter("userpwd");
		int uage=Integer.parseInt(req.getParameter("UAge"));//将字符串转成int
		
		if(req.getParameter("age")!="") {
			uage =Integer.parseInt(req.getParameter("age"));
		}else {
			uage=0;
		}
		if(uname==""||upwd==""||uage==0) {
			out.print("<h1>注册失败！</h1>");
		}else {
		//封装数据
			User user = new User(uname, upwd,uage);
			UserServiceImpl service =new UserServiceImpl();
			boolean flag =service.registService(user);
		// 创建user对象
			/*
			 * UserServiceImpl dao =new UserServiceImpl(); boolean flag = dao.regist(user);
			 */
		//处理数据
		if (flag == true) {
			out.print("<h1>注册成功！</h1>");
		} else {
			out.print("<h1>注册失败！</h1>");
		}
		
		}
	}
}
