package com.xxgc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxgc.dao.ManagerDAO;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String searchText = request.getParameter("searchText");
		ManagerDAO mDAO = new ManagerDAO();
		ArrayList<String> managernameList = mDAO.findManagerNames(searchText);
		PrintWriter out = response.getWriter();
		out.print("ÄãºÃ");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
