package com.test.service.impl;

import java.util.List;

import com.test.dao.IUserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.dao.impl.UserDaoImpl;
import com.test.entity.User;
import com.test.service.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userDao =  new UserDaoImpl();
	@Override
	public boolean registService(User user) {
		//创建数据访问层的对象 IUserDao    UserDaoimpl
		boolean flag =userDao.regist(user);//调用数据访问层
		return userDao.regist(user);
	}
	/**
	 * 查询所有用户
	 */
	@Override
	public List<User> queryAllUsersService() {
		//调用dao层查询所有用户的方法
		//创建dao层对象
		//List<User> userList = userDao.querAllUsers();
		return userDao.querAllUsers();
	}
	@Override
	public int getTotalCountService() {
			
		return userDao.getTotalCount();
	}
	@Override
	public List<User> queryUserByPageService(int currentPage, int pageSize) {
		
		return userDao.queryAllUserByPage(currentPage, pageSize);
	}

}
