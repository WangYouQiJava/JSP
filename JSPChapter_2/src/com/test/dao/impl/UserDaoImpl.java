package com.test.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.dao.IUserDao;
import com.test.entity.User;

public class UserDaoImpl implements IUserDao {
	// 检查用户是否存在
	@Override
	public boolean checkUser(User user) {
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb_2", "root", "200191");
			// 获取预编译的数据课操作对象
			String sql = "SELECT * FROM user WHERE loginname = ? AND loginpwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getLoginName());
			ps.setString(2, user.getLoginpwd());
			// 执行SQL
			rs = ps.executeQuery();
			// 处理结果集
			if (rs.next()) {// 存在用户名和密码
				// 标记
				flag = true;
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

	@Override
	public boolean checkUser(String name, String password) {
		
		return false;
	}

}
