package com.test.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//注解方式   配置servlet
@WebServlet(urlPatterns="/ScondServlet",loadOnStartup=0,initParams= {@WebInitParam(name="",value="")})
public class ScondServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("SecondServlet.service()");
	}
}