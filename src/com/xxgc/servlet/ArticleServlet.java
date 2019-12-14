package com.xxgc.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxgc.dao.ArticleDAO;
import com.xxgc.dao.CatalogDAO;
import com.xxgc.model.Article;
import com.xxgc.model.Catalog;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String type = request.getParameter("type");
		System.out.println(type);
		if(type.equals("findAll")) {
			findAll(request,response);
		}
		else if(type.equals("articleAdd")) {
			articleAdd(request,response);
		}
		else if(type.equals("add")) {
			add(request,response);
		}
		else if(type.equals("edit")) {
			edit(request,response);
		}
		else if(type.equals("update")) {
			update(request,response);
		}
		else if(type.equals("delete")) {
			delete(request,response);
		}
		else if(type.equals("upMove")) {
			upMove(request,response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		ArticleDAO aDAO = new ArticleDAO();
		ArrayList<Article> ArticleList = aDAO.findAll();
		request.setAttribute("ArticleList", ArticleList);
		String path = "background/articleList.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void articleAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		ArticleDAO aDAO = new ArticleDAO();
		String maxArnumber = aDAO.getMaxArnumber();
		request.setAttribute("arnumber", Integer.parseInt(maxArnumber)+1);
		CatalogDAO cDAO = new CatalogDAO();
		ArrayList<Catalog> catalogs = cDAO.findAbleAll();
		request.setAttribute("catalogs",catalogs);
		String path = "background/articleAdd.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		Article art = new Article();
		ArticleDAO aDAO = new ArticleDAO();
		Date date = new Date();
	    DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		
		
		art.setArid(simpleDateFormat.format(date)+new Random().nextInt(9999));
		art.setCaid(Integer.parseInt(request.getParameter("caid")));
		art.setArnumber(request.getParameter("arnumber"));
		art.setArtitle(request.getParameter("artitle"));
		art.setArcontent(request.getParameter("arcontent"));
		art.setAruser(request.getParameter("aruser"));
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String artime = simpleDateFormat.format(date);
		art.setArtime(artime);
		art.setArstate(request.getParameter("level"));
		art.setClicks(0);
		String path = "ArticleServlet?type=findAll";
		if(aDAO.add(art) == false) {
			System.out.println("添加失败！");
		}
		response.sendRedirect(path);
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String arid = request.getParameter("arid");
		ArticleDAO aDAO = new ArticleDAO();
		Article art = aDAO.getArticleUseId(arid);
		request.setAttribute("article",art);
		CatalogDAO cDAO = new CatalogDAO();
		ArrayList<Catalog> catalogs = cDAO.findAll();
		request.setAttribute("catalogs",catalogs);
		String path = "background/articleEdit.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		ArticleDAO aDAO = new ArticleDAO();
		Article art = new Article();
		
		art.setArid(request.getParameter("arid"));
		art.setCaid(Integer.parseInt(request.getParameter("caid")));
		art.setArnumber(request.getParameter("arnumber"));
		art.setArtitle(request.getParameter("artitle"));
		art.setArcontent(request.getParameter("arcontent"));
		art.setAruser(request.getParameter("aruser"));
		Date date = new Date();
	    DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");		//刷新修改日期
	    String artime = simpleDateFormat.format(date);
		art.setArtime(artime);
		art.setArstate(request.getParameter("level"));
		art.setClicks(Integer.parseInt(request.getParameter("clicks")));
		if(!aDAO.update(art))
			System.out.println("更新失败！");
		String path = "ArticleServlet?type=findAll";
		response.sendRedirect(path);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		ArticleDAO aDAO = new ArticleDAO();
		String arid = request.getParameter("arid");
		aDAO.deleteUseId(arid);
		String path = "ArticleServlet?type=findAll";
		response.sendRedirect(path);
	}
	private void upMove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String arnumber = request.getParameter("arnumber");
		String nextArnumber = request.getParameter("nextArnumber");
		ArticleDAO aDAO = new ArticleDAO();
		String path = "ArticleServlet?type=findAll";
		if(!aDAO.upMove(arnumber,nextArnumber)) 
			System.out.println("上移失败!");	//理论不可能失败
		response.sendRedirect(path);
	}
}
