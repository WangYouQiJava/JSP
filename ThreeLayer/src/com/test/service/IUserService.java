package com.test.service;

import java.util.List;

import com.test.entity.User;

/**
 * 业务逻辑层 ，又叫service层
 * @author dell
 *
 */
public interface IUserService {
	//实现注册方法
	boolean registService(User user);
	//查询所有用户
	List<User> queryAllUsersService();
	//查询数据总数
	int getTotalCountService();
	//查询当前页的数据集合
	List<User> queryUserByPageService(int currentPage,int pageSize);
}
