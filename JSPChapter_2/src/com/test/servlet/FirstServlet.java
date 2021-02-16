package com.test.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * 2）注解
 * 		@WebServlet(urlPatterns="/ScondServlet")
 *	在从HttpServletRequest对象中获取用户请求数据后，需要对请求数据进行编码解决中文乱码问题
 *	在使用HttpServletResponse对象向页面输出内容之前也要设置响应编码格式，告诉浏览器内容类型和编码
 *	
 *	servlet 处理请求并响应
 *	jsp    显示内容
 *	servlet 逻辑控制  分发处理   角色  根据用户请求  选择对象jsp页面进行显示
 *
 *	web服务器  将jsp翻译  java代码（servlet），编译
 *	jsp  内置对象
 *	out  out.print()servlet中PrintWriter对象
 *
 *request	
 *		request.getRequestDispatcher("").forward(request,response);
 *		request.setAttribute()  保存数据到request作用域
 *		request.getAttribute()
 *		request.removeAttibute()
 *		request.getCookies() 获取cookie对象数组
 *		request.setCharacterEncoding()
 *	servlet中HttpServletRequest对象
 *
 *response 
 *		response.sendRedirect("")重定向
 *		response.addCookie()  向response写入cookie
 *		response.setContentType("text/html;charset=UTF-8");
 *		response.setCharacterEncoding()
 *		servlet中HttpServletResponse对象
 *
 * session 会话对象
 * 		session.setAttribute()保存数据到session作用域
 * 		session.getAttribute()
 * 		session.removeAttribute()
 * 		session.getId()
 * 		session.setMaxInactiveInterval() 设置非活动时间  秒
 * 		session.invalidate()     session失效
 * 
 * servlet中req.getSession() 获取session对象
 * 		HttpSession session = req.getSession();
 * 
 * application 全局对象
 * 		application.setAttribute()   保存数据到application作用域  被所有用户共享
 * 		application.getAttribute()
 * 		application.removeAttribute()
 * 		application.getRealPath(String path) 对象路径（真实路径）
 * 		application.getContextpath()   相对路径
 * servlet中this.getServletContext()获取
 * 		ServletContext sc = this.getServletContext()
 * 
 * pageContext作用域
 * 
 * 
 *serlvet生命周期：5个阶段 
 *	1、加载(实例化)
 *	2、初始化init()
 *		默认在第一次发送请求时，执行，执行一次
 *	3、处理请求（服务）service()发送请求时执行
 *		每次发送请求时执行
 *		<load-on-startup>1</load-on-startup>
 *		 配置servlet在服务器启动时进行初始化 
 *		启动时，值是大于等于零的，值越小先执行谁
		关闭时，值越小先执行谁
 *	4、销毁	destroy		释放资源
 *		关闭服务器时调用
 *	5、卸载
 *      
 */
public class FirstServlet extends HttpServlet{	
	@Override
	public void init() throws ServletException {
		System.out.println("FirstServlet.init()");
		//获取当前servlet中的初始化参数
		String initValue = this.getInitParameter("a");
		System.out.println("当前servlet中的初始化参数的值："+initValue);
		//获取当前项目中（服务器中）初始化参数
		ServletContext sc = this.getServletContext();//application对象
		String bValue = sc.getInitParameter("b");
		System.out.println("当前项目中初始化参数的值："+bValue);
	}
	
	protected void service(HttpServletRequest reg,HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		System.out.println("这是servlet方法");
	}
	public void destroy() {
		super.destroy();
		System.out.println("这是destroy()");
	}
  
} 
       
