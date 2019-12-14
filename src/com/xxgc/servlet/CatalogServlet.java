package com.xxgc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxgc.dao.CatalogDAO;
import com.xxgc.model.Catalog;

/**
 * Servlet implementation class CatalogServlet
 */
public class CatalogServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String type = request.getParameter("type");
		System.out.println(type);
		if(type.equals("findAll")) {
			findAll(request,response);
		}
		else if(type.equals("catalogAdd")) {
			catalogAdd(request,response);
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
		else if(type.equals("check")) {
			check(request,response);
		}
	}
	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * StringBuilder checkCaname = new StringBuilder("%%");
		 * checkCaname.insert(1,request.getParameter("checkText"));
		 */
		String checkCaname = request.getParameter("checkText");
		CatalogDAO cDAO = new CatalogDAO();
		ArrayList<Catalog> catalogList = cDAO.findAllUseName(checkCaname);
		request.setAttribute("catalogList", catalogList);
		String path = "background/catalogList.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void upMove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String canumber = request.getParameter("canumber");
		String nextCanumber = request.getParameter("nextCanumber");
		CatalogDAO cDAO = new CatalogDAO();
		String path = "CatalogServlet?type=findAll";
		if(!cDAO.upMove(canumber,nextCanumber)) 
			System.out.println("上移失败!");	//理论不可能失败
		response.sendRedirect(path);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		CatalogDAO cDAO = new CatalogDAO();
		int caid = Integer.parseInt(request.getParameter("caid"));
		cDAO.deleteUseId(caid);
		String path = "CatalogServlet?type=findAll";
		response.sendRedirect(path);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Catalog catalog = new Catalog();
		CatalogDAO cDAO = new CatalogDAO();
		catalog.setCaid(Integer.parseInt(request.getParameter("caid")));
		catalog.setCaname(request.getParameter("caname"));
		catalog.setCanumber(request.getParameter("canumber"));
		catalog.setCastate(request.getParameter("level"));
		cDAO.update(catalog);
		String path = "CatalogServlet?type=findAll";
		response.sendRedirect(path);
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int caid = Integer.parseInt(request.getParameter("caid"));
		Catalog catalog = new Catalog();
		CatalogDAO cDAO = new CatalogDAO();
		catalog = cDAO.getCatalogUseId(caid);
		request.setAttribute("catalog", catalog);
		String path = "background/catalogEdit.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CatalogDAO cDAO = new CatalogDAO();
		Catalog catalog = new Catalog();
		catalog.setCaname(request.getParameter("caname"));
		catalog.setCanumber(request.getParameter("canumber"));
		catalog.setCastate(request.getParameter("level"));
		String path = "CatalogServlet?type=findAll";
		cDAO.add(catalog);
		response.sendRedirect(path);
	}
	//先获取最大序号，再跳转添加页面
	private void catalogAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CatalogDAO cDAO = new CatalogDAO();
		String maxCanumber = cDAO.getMaxCanumber();
		request.setAttribute("canumber", Integer.parseInt(maxCanumber)+1);
		String path = "background/catalogAdd.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatalogDAO cDAO = new CatalogDAO();
		ArrayList<Catalog> catalogList = cDAO.findAll();
		request.setAttribute("catalogList", catalogList);
		String path = "background/catalogList.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
}
