package com.test.entity;

/**
 * mvc m 模型层 封装数据的模型-------实体类 对应数据库中一张数据表
 * 
 * @author Lenovo
 *
 */
public class User {
	// 私有属性
	// 提供get、set方法
	// 提供无参构造方法
	// 可以重写toString()
	private String uname;
	private String upwd;
	private int age;
	private String address;

	public User(String uname, String upwd, int age, String address) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.address = address;
	}

	public User() {
		super();
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

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", upwd=" + upwd + ", age=" + age + ", address=" + address + "]";
	}

}
