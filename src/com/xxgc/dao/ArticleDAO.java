package com.xxgc.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.xxgc.model.Article;
import com.xxgc.model.Catalog;
import com.xxgc.utils.JDBCUtils;

public class ArticleDAO {
	private JDBCUtils bcutil;
	private ResultSet rs;
	
	public ArticleDAO(){
		bcutil = new JDBCUtils();
	}
	public ArrayList<Article> findAll() {
		ArrayList<Article> ArticleList = new ArrayList<Article>();
		String sql = "select * from article a,catalog c where a.caid=c.caid order by a.arnumber DESC";
		rs = bcutil.query(sql, null);
		try {
			while (rs.next()) {
				Article art = new Article(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getInt(10),rs.getString("caname"));
				art.setArcontent(art.getArcontent().substring(0,art.getArcontent().length()>40?40:art.getArcontent().length()));
				ArticleList.add(art);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bcutil.close();
		}
		return ArticleList;
	}
	public boolean add(Article art) {
		String sql = "insert into article values(?,?,?,?,?,?,?,?,?,?)";
		Object[] obj = {art.getArid(),art.getCaid(),art.getArnumber(),art.getArtitle(),
				art.getArimage(),art.getArcontent(),art.getAruser(),art.getArtime(),
				art.getArstate(),art.getClicks()};
		return bcutil.update(sql, obj);
	}
	public String getMaxArnumber() {
		String maxArnumber = null;
		String sql = "select Max(arnumber) from article";
		try {
			rs = bcutil.query(sql, null);
			if (rs.next()) {
				maxArnumber = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bcutil.close();
		}
		return maxArnumber == null ? "0" : maxArnumber;
	}
	public String getMaxArid() {
		String maxArid = null;
		String sql = "select Max(arid) from article";
		try {
			rs = bcutil.query(sql, null);
			if (rs.next()) {
				maxArid = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bcutil.close();
		}
		return maxArid == null ? "10000000" : maxArid;
	}
	public boolean deleteUseId(String arid) {
		// TODO Auto-generated method stub
		String sql = "delete from article where arid=?";
		Object[] obj = { arid };
		return bcutil.update(sql, obj);
	}
	public boolean upMove(String arnumber, String nextArnumber) {
		String sql = "update article a1 join article a2 on (a1.arnumber=? and a2.arnumber=?) or (a2.arnumber=? and a1.arnumber=?) set a2.arnumber=a1.arnumber";
		Object[] obj = { arnumber, nextArnumber, arnumber, nextArnumber };
		return bcutil.update(sql, obj);
	}
	public Article getArticleUseId(String arid) {
		Article art = null;
		String sql = "select * from article a,catalog c where a.caid=c.caid and arid=?";
		Object[] obj = { arid };
		try {
			rs = bcutil.query(sql, obj);
			if (rs.next()) {
				art = new Article(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getInt(10),rs.getString("caname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bcutil.close();
		}
		return art;
	}
	public boolean update(Article art) {
		// TODO Auto-generated method stub
		String sql = "update article set caid=?,arnumber=?,artitle=?,arimage=?,arcontent=?,aruser=?,artime=?,arstate=?,clicks=? where arid=?";
		Object[] obj = {art.getCaid(),art.getArnumber(),art.getArtitle(),art.getArimage(),
				art.getArcontent(),art.getAruser(),art.getArtime(),art.getArstate(),art.getClicks(),art.getArid()};
		return bcutil.update(sql, obj);
	}
}
