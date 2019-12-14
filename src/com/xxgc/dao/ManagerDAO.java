package com.xxgc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xxgc.model.Manager;
import com.xxgc.utils.JDBCUtils;

public class ManagerDAO {
	private JDBCUtils bcutil;
	private ResultSet rs = null;

	public ManagerDAO() {
		bcutil = new JDBCUtils();
	}

	public Manager login(Manager manager) {
		Manager newMan = new Manager();
		String sql = "select * from manager where managerName=? and passwd=?";
		Object[] obj = {manager.getManagername(),manager.getPasswd()};
		try {
			rs = bcutil.query(sql, obj);
			if (rs.next()) {
				newMan.setManagerid(rs.getInt(1));
				newMan.setManagername(rs.getString(2));
				newMan.setPasswd(rs.getString(3));
				newMan.setMstate(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bcutil.close();
		}
		return newMan;
	}

	public ArrayList<Manager> findALL() {
		ArrayList<Manager> managers = new ArrayList<Manager>();
		String sql = "select * from manager";
		try {
			rs = bcutil.query(sql, null);
			while (rs.next()) {
				Manager manager = new Manager();
				manager.setManagerid(rs.getInt(1));
				manager.setManagername(rs.getString(2));
				manager.setPasswd(rs.getString(3));
				manager.setMstate(rs.getString(4));
				managers.add(manager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			bcutil.close();
		}
		return managers;
	}
	public boolean addManager(Manager manager) {
		String sql = " insert manager(managername,passwd,mstate) values(?,?,?)";
		Object[] obj = {manager.getManagername(),manager.getPasswd(),manager.getMstate()};
		return bcutil.update(sql, obj);
	}
	public Manager getManagerUseId(int id) {
		Manager manager = new Manager();
		String sql = "Select * from manager where id=?";
		Object[] obj = {id};
		try {
			rs = bcutil.query(sql, obj);
			if(rs.next()) {
				manager.setManagerid(rs.getInt(1));
				manager.setManagername(rs.getString(2));
				manager.setPasswd(rs.getString(3));
				manager.setMstate(rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			bcutil.close();
		}
		return manager;
	}
	public boolean managerUpdate(Manager changeManager) {
		String sql = "update manager set passwd=?,mstate=? where id=?";
		Object[] obj = {changeManager.getPasswd(),changeManager.getMstate(),changeManager.getManagerid()};
		return bcutil.update(sql, obj);
	}
	public boolean managerDeleteUseId(int id) {
		String sql = "delete from manager where id=?";
		Object[] obj = {id};
		return bcutil.update(sql, obj);
	}
	public int getManagerCount() {
		int count = 0;
		String sql = "select count(*) from manager";
		try {
			rs = bcutil.query(sql, null);
			if(rs.next())
				count = rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			bcutil.close();
		}
		return count;
	}
	public ArrayList<String> findManagerNames(String SearchName){
		ArrayList<String> managernameList = new ArrayList<String>();
		String sql = "select managername from manager where managername like '%"+SearchName+"%'";
		try {
			rs = bcutil.query(sql, null);
			if(rs.next()) {
				managernameList.add(rs.getString(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			bcutil.close();
		}
		return managernameList;
	}
}