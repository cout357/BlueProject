package com.xxgc.dao;

import java.sql.*;
import java.util.ArrayList;

import com.xxgc.model.Catalog;
import com.xxgc.utils.JDBCUtils;

public class CatalogDAO {
	private JDBCUtils bcutil;
	ResultSet rs;

	public CatalogDAO() {
		bcutil = new JDBCUtils();
	}

	public ArrayList<Catalog> findAll() {
		ArrayList<Catalog> catalogList = new ArrayList<Catalog>();
		String sql = "select * from catalog order by canumber DESC";
		rs = bcutil.query(sql, null);
		try {
			while (rs.next()) {
				Catalog catalog = new Catalog();
				catalog.setCaid(rs.getInt("caid"));
				catalog.setCaname(rs.getString("caname"));
				catalog.setCanumber(rs.getString("canumber"));
				catalog.setCastate(rs.getString("castate"));
				catalogList.add(catalog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bcutil.close();
		}
		return catalogList;
	}

	public String getMaxCanumber() {
		String maxCanumber = null;
		String sql = "select Max(canumber) from catalog";
		try {
			rs = bcutil.query(sql, null);
			if (rs.next()) {
				maxCanumber = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bcutil.close();
		}
		return maxCanumber == null ? "0" : maxCanumber;

	}

	public boolean add(Catalog catalog) {
		String sql = "insert into Catalog values(caid,?,?,?)";
		Object[] obj = { catalog.getCaname(), catalog.getCanumber(), catalog.getCastate() };
		return bcutil.update(sql, obj);
	}

	public Catalog getCatalogUseId(int caid) {
		Catalog catalog = new Catalog();
		// TODO Auto-generated method stub
		String sql = "select * from catalog where caid=?";
		Object[] obj = { caid };
		try {
			rs = bcutil.query(sql, obj);
			if (rs.next()) {
				catalog.setCaid(rs.getInt("caid"));
				catalog.setCaname(rs.getString("caname"));
				catalog.setCanumber(rs.getString("canumber"));
				catalog.setCastate(rs.getString("castate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bcutil.close();
		}
		return catalog;
	}

	public boolean update(Catalog catalog) {
		String sql = "update catalog set caname=?,canumber=?,castate=? where caid=?";
		Object[] obj = { catalog.getCaname(), catalog.getCanumber(), catalog.getCastate(), catalog.getCaid() };
		return bcutil.update(sql, obj);
	}

	public boolean deleteUseId(int caid) {
		String sql = "delete from catalog where caid=?";
		Object[] obj = { caid };
		return bcutil.update(sql, obj);
	}

	public boolean upMove(String canumber, String nextCanumber) {
		String sql = "update catalog c1 join catalog c2 on (c1.canumber=? and c2.canumber=?) or (c2.canumber=? and c1.canumber=?) set c2.canumber=c1.canumber";
		Object[] obj = { canumber, nextCanumber, canumber, nextCanumber };
		return bcutil.update(sql, obj);
	}

	public ArrayList<Catalog> findAllUseName(String checkCaname) {
		// TODO Auto-generated method stub
		ArrayList<Catalog> catalogList = new ArrayList<Catalog>();
		String sql = "select * from catalog where caname like '%"+checkCaname+"%'";
		rs = bcutil.query(sql, null);
		try {
			while (rs.next()) {
				Catalog catalog = new Catalog();
				catalog.setCaid(rs.getInt("caid"));
				catalog.setCaname(rs.getString("caname"));
				catalog.setCanumber(rs.getString("canumber"));
				catalog.setCastate(rs.getString("castate"));
				catalogList.add(catalog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bcutil.close();
		}
		return catalogList;
	}

	public ArrayList<Catalog> findAbleAll() {
		ArrayList<Catalog> catalogList = new ArrayList<Catalog>();
		String sql = "select * from catalog where castate=1 order by canumber DESC";
		rs = bcutil.query(sql, null);
		try {
			while (rs.next()) {
				Catalog catalog = new Catalog();
				catalog.setCaid(rs.getInt("caid"));
				catalog.setCaname(rs.getString("caname"));
				catalog.setCanumber(rs.getString("canumber"));
				catalog.setCastate(rs.getString("castate"));
				catalogList.add(catalog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bcutil.close();
		}
		return catalogList;
	}
}
