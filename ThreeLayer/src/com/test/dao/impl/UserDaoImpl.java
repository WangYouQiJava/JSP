package com.test.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.test.dao.IUserDao;
import com.test.entity.PageUtil;
import com.test.entity.User;

public class UserDaoImpl implements IUserDao{

	@Override
	public boolean regist(User user) {
		//声明jdbc对象
				Connection con = null;
				PreparedStatement ps = null;
				boolean flag= false;
				try{
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					//标记是否有该用户
					
					//获取连接
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb_7", "root", "200191");
					//获取预编译的数据库操作对象
					String sql = "INSERT INTO userdb_7(loginname,loginpwd) VALUE(?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, user.getUname());
					ps.setString(2, user.getUpwd());			
					//处理结果集
					if(user.getUname()==""||user.getUpwd()=="") {
						flag=false;
					}else {
						flag=true;
					}
					
					//执行sql
					int rs = ps.executeUpdate();
					System.out.println(rs);
					if(rs==0) {
						flag=false;
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					//关闭资源
					if(ps!=null){
						try{
							ps.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					if(con!=null){
						try{
							con.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
		
		
		return flag;
	}

	
	
	//查询
	@Override
	public boolean checkUser(User user) {
		//声明jdbc对象
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				boolean flag= false;
				try{
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					//标记是否有该用户
					//获取连接
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb_7", "root", "200191");
					//获取预编译的数据库操作对象
					String sql = "select * from userdb_7 where uname = ? AND upwd = ?";
					ps = con.prepareStatement(sql);
					ps.setString(1, user.getUname());
					ps.setString(2, user.getUpwd());			
					//执行sql
					rs = ps.executeQuery();
					//处理结果集
					if(rs.next()){
						flag = true;
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					//关闭资源
					if(rs!=null){
						try{
							rs.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					if(ps!=null){
						try{
							ps.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					if(con!=null){
						try{
							con.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
		
		
		return flag;
	}



	public List<User> queryAllUser() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag= false;
		List<User> it = new ArrayList<User>();
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//标记是否有该用户
			
			//获取连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb_7", "root", "200191");
			//获取预编译的数据库操作对象
			String sql = "select * from userdb_7";
			ps = con.prepareStatement(sql);	
			//执行sql
			rs = ps.executeQuery();
			//处理结果集
			while(rs.next()){
				User user = new User();
				user.setUname(rs.getString(1));
				user.setUpwd(rs.getString(2));
				it.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			if(rs!=null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try{
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return it;
	}



	@Override
	public User queryUserByName(String username) {
		
		return null;
	}



	@Override
	public List<User> querAllUsers() {
		
		return null;
	}



	@Override
	public int getTotalCount() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		//List<User> it = new ArrayList<User>();
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//标记是否有该用户
			//获取连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb_7", "root", "200191");
			//获取预编译的数据库操作对象
			String sql = "select count(*) from userdb_7";
			ps = con.prepareStatement(sql);	
			//执行sql
			rs = ps.executeQuery();
			//处理结果集
			if(rs.next()) {
				count = rs.getInt(1);//结果集中第一列
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			if(rs!=null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try{
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return count;
	}



	@Override
	public List<User> queryAllUserByPage(int currentPage, int pageSize) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		//List<User> it = new ArrayList<User>();
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//标记是否有该用户
			//获取连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb_7", "root", "200191");
			//获取预编译的数据库操作对
			String sql = "select * from userdb_7 LIMIT ?,?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, (currentPage-1)*pageSize);
			ps.setInt(2, 4);
			//执行sql
			rs = ps.executeQuery();
			//处理结果集
			while(rs.next()){
				User user = new User();
				user.setUname(rs.getString(1));
				user.setUpwd(rs.getString(2));
				userList.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			if(rs!=null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try{
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(con!=null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return userList;
	}



	
	
	
	
}
