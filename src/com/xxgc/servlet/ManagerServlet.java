package com.xxgc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import com.xxgc.dao.ManagerDAO;
import com.xxgc.model.Manager;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		//System.out.println(type);
		if(type.equals("add")) {
			add(request,response);
		}
		else if(type.equals("delete")) {
			delete(request,response);
		}
		else if(type.equals("edit")) {
			edit(request,response);
		}
		else if(type.equals("findAll")) {
			findAll(request,response);
		}
		else if(type.equals("login")) {
			login(request,response);
		}
		else if(type.equals("update")) {
			update(request,response);
		}
		else if(type.equals("logout")) {
			logout(request,response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void add(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Manager manager = new Manager();
		try {
			String managername = request.getParameter("managername");
			String passwd = request.getParameter("passwd");
			String againPasswd = request.getParameter("againPasswd");
			String mstate = request.getParameter("level");
			
			manager.setManagername(managername);
			manager.setPasswd(passwd);
			manager.setMstate(mstate);
			if(passwd.equals(againPasswd)) {
				ManagerDAO mDao = new ManagerDAO();
				mDao.addManager(manager);
				response.sendRedirect("ManagerServlet?type=findAll");
			}
			else {
				String path = "background/addManager.jsp";
				String isError = "true";
				request.setAttribute("isError", isError);
				request.getRequestDispatcher(path).forward(request, response);
			}
		}catch(NullPointerException e) {
			String path = "background/addManager.jsp";
			try {
				request.getRequestDispatcher(path).forward(request, response);
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		ManagerDAO mDAO = new ManagerDAO();
		if(mDAO.managerDeleteUseId(id)) {
			String path = "ManagerServlet?type=findAll";
			request.getRequestDispatcher(path).forward(request, response);
		}
		else {
			System.out.println("异常，删除失败！");
		}
	}
	private void edit(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String uid = request.getParameter("id");
		ManagerDAO mDAO = new ManagerDAO();
		Manager manager = mDAO.getManagerUseId(Integer.parseInt(uid));
		request.setAttribute("manager",manager);
		String path = "background/managerEdit.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		ManagerDAO managerDAO = new ManagerDAO();
		ArrayList<Manager> managers = managerDAO.findALL();
		int managerCount = managerDAO.getManagerCount();
		request.setAttribute("managers", managers);
		request.setAttribute("managerCount", managerCount);
		String path = "background/managerlist.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	private void login(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String managername = request.getParameter("username");
		String passwd = request.getParameter("pwd");
		Manager manager = new Manager();
		manager.setManagername(managername);
		manager.setPasswd(passwd);
		//设置登录失败后页面
		String path = "background/login.jsp";
		//校验验证码
		String trueCheckCode = (String)request.getSession().getAttribute("checkCode");
		String checkCode = request.getParameter("checkCode");
		if(trueCheckCode.equals(checkCode)) {
			//登入测试
			ManagerDAO managerDAO = new ManagerDAO();
			if(managerDAO.login(manager).getManagername()!=null){
				System.out.println("登录成功！");
				request.setAttribute("managername",managername );
				//登入成功，跳转到后台index.jsp页面
				path="background/index.jsp";
				HttpSession sess = request.getSession();
				sess.setAttribute("managername", manager.getManagername());
			}
			else {
				System.out.println("登录失败！");
				request.setAttribute("checkOut","1");
			}
			
		}
		else {
			System.out.println("登录失败！");
			request.setAttribute("checkOut","2");
		}
		//请求转发
		request.getRequestDispatcher(path).forward(request,response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Manager manager = new Manager();
		try {
			int managerid = Integer.parseInt(request.getParameter("id")); 
			String managername = request.getParameter("managername");
			String passwd = request.getParameter("passwd");
			String againPasswd = request.getParameter("againPasswd");
			String mstate = request.getParameter("level");
			
			manager.setManagerid(managerid);
			manager.setManagername(managername);
			manager.setPasswd(passwd);
			manager.setMstate(mstate);
			if(passwd.equals(againPasswd)) {
				ManagerDAO mDao = new ManagerDAO();
				mDao.managerUpdate(manager);
				response.sendRedirect("ManagerServlet?type=findAll");
			}
			else {
				String path = "ManagerServlet?type=edit&id="+manager.getManagerid();
				String isError = "true";
				request.setAttribute("isError", isError);
				request.getRequestDispatcher(path).forward(request, response);
			}
		}catch(NullPointerException e) {
			String path = "background/addManager.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void logout(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		request.getSession().removeAttribute("managername");
		response.sendRedirect("background/login.jsp");
	}
}
