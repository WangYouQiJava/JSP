package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.entity.User;

/**
 * MVC中M 模型层-封装逻辑功能的模型 连接数据库 ，与数据库交互 实现注册功能
 */
public class UserDao {
	/**
	 * 实现注册功能
	 */
	public boolean regist(User user) {
		// jdbc连接数据库
		// 加载驱动
		// 获取连接
		// 获取预编译的数据库操作对象
		// 执行SQL
		// 处理结果集
		// 关闭资源
		// 检查用户名
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 标记 是否有该用户
		boolean flag = false;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb_7", "root", "200191");
			// 获取预编译的数据课操作对象
			String sql = "insert userdb_7(uname,upwd,age,address) values(?,?,?,?) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getAddress());
			// 执行SQL
			int count = ps.executeUpdate();// 受影响行数
			if (count > 0) {
				// 插入成功
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

}
