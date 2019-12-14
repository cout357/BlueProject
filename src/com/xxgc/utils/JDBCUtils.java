package com.xxgc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xxgc.dao.UsersDAO;

public class JDBCUtils {
	String Driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test";
	String user = "root";
	String password = "31415926535";
	UsersDAO usersDAO = null;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public ResultSet query(String sql, Object obj[]) {
		try {
			createPS(sql, obj);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ��ΪҪ����rs�����Բ�������ر�
		return rs;
	}

	public boolean update(String sql, Object obj[]) {
		int count = 0;
		try {
			createPS(sql, obj);
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return count > 0 ? true : false;
	}

	private Connection getConn() {
		try {
			Class.forName(Driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			// System.out.println("-----���������سɹ�-----");
		} catch (Exception e) {
			System.out.println("-----����������ʧ��-----");
			e.printStackTrace();
		}
		return conn;
	}

	private void createPS(String sql, Object[] obj) throws SQLException {
		ps = getConn().prepareStatement(sql);
		// �������
		if (obj != null) {
			for (int i = 0; i < obj.length; i++)
				ps.setObject(i + 1, obj[i]);
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
