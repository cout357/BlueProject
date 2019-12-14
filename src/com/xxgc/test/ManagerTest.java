package com.xxgc.test;

import com.xxgc.dao.ManagerDAO;
import com.xxgc.model.Manager;

public class ManagerTest {
	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.setManagername("zs");
		manager.setPasswd("1234");
		ManagerDAO managerDAO = new ManagerDAO();
		System.out.println(managerDAO.login(manager));
		
	}
}
