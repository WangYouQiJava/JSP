package com.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.entity.PageUtil;
import com.test.entity.User;
import com.test.service.IUserService;
import com.test.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowUserByPageServlet
 */
@WebServlet("/ShowUsersPageServlet")
public class ShowUserByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理请求  需要获取5个变量
		//查询数据库
		//调用service提供的服务
		/*IUserService user = new UserServiceImpl();
		int count = user.getTotalPageCountService();
		//页面大小
		int pageSize = 4;
		//当前页面
		int currPageNo = 2;
		//总页数
		int totalPageCount = count%pageSize == 0?count/pageSize:count/pageSize+1;
		List<User> page = user.queryAllUsersByPageService(currPageNo, pageSize);
		Page pageall = new Page();
		pageall.setusers(page);
		//响应
		request.setAttribute("page", pageall);
		request.getRequestDispatcher("").forward(request, response);*/
		
		String currPageNo = request.getParameter("currPageNo");
		//获取当前页面
		if(currPageNo == null){
			currPageNo = "1";
		}
		int currPageNos = Integer.parseInt(currPageNo);
		IUserService user = new UserServiceImpl();
		int totalCounts = user.getTotalCountService();
		PageUtil pages = new PageUtil();
		//设置每页条数
		pages.setPageSize(4);
		//设置总记录数
		pages.setTotalPageCount(totalCounts);
		int totalpages = pages.getTotalPageCounts();
		//控制首页末页
		if(currPageNos<1){
			currPageNos = 1;
		}else if(currPageNos > pages.getTotalPageCounts()){
			currPageNos = totalpages;
		}
		pages.setCurrPageNo(currPageNos);
		List<User> list = user.queryUserByPageService(pages.getCurrPageNo(),pages.getPageSize());
		//设置每页显示页面
		pages.setusers(list);
		request.setAttribute("page", pages);
		request.getRequestDispatcher("ShowUser.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
