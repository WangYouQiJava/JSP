package com.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.UserDao;
import com.test.entity.User;

/**
 * mvc c controller 控制器层 使用servlet实现 controller ：
 * 接收用户请求，调用模型进行处理，根据处理结果选着对应的视图（jsp）或者模型进行跳转
 * 
 * 
 * 
 * @author Lenovo
 *
 */
@WebServlet(urlPatterns = "/RegistServlet")
public class RegistServlet extends HttpServlet {
	// 处理用户请求
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// servlet执行流程
		// 设置请求和响应编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		// 获取用户请求数据
		String uname = req.getParameter("username");
		// 密码
		String upwd = req.getParameter("userpwd");
		// 获取年龄
		int uage = Integer.parseInt(req.getParameter("userage"));// 将字符串转换成int
		String uaddress = req.getParameter("uAddress");
		// 封装数据
		//
		User user = new User(uname, upwd, uage, uaddress);
		// 处理请求
		// 调用模型层
		UserDao dao = new UserDao();//创建模型层对象
		boolean flag = dao.regist(user);//调用注册方法，返回结果
		//相应处理结果
			//根据数据库返回结果，跳转对应页面
		if (flag = true) {
			req.getSession().setAttribute("username", user.getUname());
			req.getSession().setAttribute("userupwd", user.getUpwd());
			req.getSession().setAttribute("userage", user.getAge());
			req.getSession().setAttribute("useraddress", user.getAddress());
			resp.sendRedirect("welcome.jsp");
		} else {
			resp.sendRedirect("error.jsp");
		}

	}
}
