package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * servlet java类
 * @author Lenovo
 * 1、继承javax.servlet.http.HttpServlet抽象类
 * 2、重写service方法
 * 3、在webContent下web-inf/web.xml配置Servlet
 *编写servlet 部署运行
 *
 *生命周期：5个阶段 加载 、初始化、服务、销毁、卸载
 *
 */
public class ServletTest1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置项目数据编码
		resp.setContentType("text/html; charset=UTF-8"); 
		//向页面输出信息
		PrintWriter out = resp.getWriter();//获取输出对象
		out.print("<h1>你好wyq</h1>");
		//System.out.println("你好王有齐");
		Date now = new Date();
		out.print(now);
	}
	
	
}
