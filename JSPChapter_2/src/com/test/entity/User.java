package com.test.entity;
/**
 * 实体类
 * @author Lenovo
 *对象数据库中的一张表
 *javabean
 */
public class User {
	private String id;
	private String loginName;
	private String loginpwd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	public User(String loginName, String loginpwd) {
		super();
		this.loginName = loginName;
		this.loginpwd = loginpwd;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", loginpwd=" + loginpwd + "]";
	}
	
	
}
