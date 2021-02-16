package com.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.entity.User;
import com.test.service.IUserService;
import com.test.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowAllUsersServlet
 */
@WebServlet("/ShowAllUsersServlet")
public class ShowAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/** 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		IUserService service = new UserServiceImpl();
		//根据返回结果，跳转页面，showUsers.jsp
		List<User> userList = service.queryAllUsersService();
		if(userList!=null) {
			for(int i = 0 ; i < userList.size() ; i++) {
				System.out.print(userList.get(i));
		}
		}else {
			System.out.print("null");
		}
		
		//将所有用户集合储存request作用域，在满足要求的情况下，范围越小越好
		request.setAttribute("userList", userList);
		//根据返回结果，跳转页面ShowUsers.jsp
		//因为将集合保存到request作用域中，在一次请求中有效
		request.getRequestDispatcher("ShowUsers.jsp").forward(request, response);
	}

}
