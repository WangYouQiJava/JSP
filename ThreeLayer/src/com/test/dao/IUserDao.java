package com.test.dao;
/**
 * 数据访问层
 * 接口
 * 属性
 * 方法
 */

import java.util.List;

import com.test.entity.User;

public interface IUserDao {
	public boolean regist(User user);
	
	//根据用户名查询用户
	User queryUserByName(String username);

	boolean checkUser(User user);
	//查询用户名是否存在
	//boolean isExist(String name);
	//实现登陆

	//查询所有用户
	//方法名 返回值 参数 ;不需要
	List<User> querAllUsers();
	//查询数据总数
	/**
	 * 
	 * @param currentPage 当前页
	 * @param pageSize	页面大小
	 * @return
	 */
	int getTotalCount();
	//查询当前页的数据集合
	
	List<User> queryAllUserByPage(int currentPage,int pageSize);


}
