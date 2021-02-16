package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TwoServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest reg,HttpServletResponse resp) throws ServletException, IOException {
		//向页面输出信息
		String uname=null;
		String upwd=null;
		resp.setContentType("text/html;charset=utf-8");
		reg.setCharacterEncoding("utf-8");
		uname=reg.getParameter("uname");
		upwd=reg.getParameter("upwd");
		if(uname!=null){
			if(uname.equals("wyq")&&upwd.equals("123")) {
				HttpSession session=reg.getSession();
				//写入session数据
				session.setAttribute("username", uname);
				reg.getRequestDispatcher("welcome.jsp").forward(reg,resp);
			}else {
				resp.sendRedirect("login.jsp");
			}
		}	
	}
       
  
    }