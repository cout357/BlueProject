package com.xxgc.test;

import com.xxgc.dao.ManagerDAO;
import com.xxgc.model.Manager;

public class loginTest {
	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.setManagername("zhangsan");
		manager.setPasswd("123");
		ManagerDAO managerDAO = new ManagerDAO();
		System.out.println(managerDAO.login(manager));
	}
	
	
	
}
