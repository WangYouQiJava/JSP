package com.test.dao;

import com.test.entity.User;

public interface IUserDao {
	//只能出现抽象方法
	//检查用户是否存在
	boolean checkUser(String name,String password);

	boolean checkUser(User user);
	
}
