package com.test.entity;
/**
 * 
 * 模型层
 * @author dell
 *
 */
public class User{
	private String uname;
	private String upwd;
	private int age;
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age = age;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public User(String uname, String upwd,int age) {
	//	super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
	}
	public User() {
		super();
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
}