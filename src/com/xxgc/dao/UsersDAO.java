package com.xxgc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xxgc.model.Users;
import com.xxgc.utils.JDBCUtils;

public class UsersDAO {
	private ResultSet rs = null;
	private JDBCUtils bcutil;
	//根据ID查询user对象
	public Users find(int id){
		Users users = new Users();
		String sql="select * from users where id=?";
		Object[] obj = {id};
		try{
			rs = bcutil.query(sql, obj);
			if(rs.next()){
				users.setId(rs.getInt(1));
				users.setUsername(rs.getString(2));
				users.setPassword(rs.getString(3));
				users.setEmail(rs.getString(4));
				users.setBirthday(rs.getDate(5));
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			bcutil.close();
		}
		return users;
	}
	
//	根据ID删除user对象
	public boolean delete(int id){
		String sql = "delete from users where id=?";	
		Object[] obj = {id};
		return bcutil.update(sql, obj);
	}
	
	// 查询users所有数据
	public ArrayList<Users> findALL(){
		ArrayList<Users> usersList = new ArrayList<Users>();
		String sql = "select * from users";
		try {
			rs = bcutil.query(sql, null);
			while(rs.next()){
				Users users =new Users();
				users.setId(rs.getInt(1));
				users.setUsername(rs.getString(2));
				users.setPassword(rs.getString(3));
				users.setEmail(rs.getString(4));
				users.setBirthday(rs.getDate(5));
				usersList.add(users);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bcutil.close();
		}
		return usersList;
	}
	public boolean insert(Users users){
		String sql = "insert into users(id,username,password,email,birthday) values("
				+users.getId()+",'"
				+users.getUsername()+"','"
				+users.getPassword()+"','"
				+users.getEmail()+"','";
		return bcutil.update(sql, null);
	}
}
