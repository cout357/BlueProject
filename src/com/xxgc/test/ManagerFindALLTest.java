package com.xxgc.test;

import java.util.ArrayList;

import com.xxgc.dao.ManagerDAO;
import com.xxgc.model.Manager;

public class ManagerFindALLTest {
	public static void main(String[] args) {
		ManagerDAO managerDAO = new ManagerDAO();

		ArrayList<Manager> managerList = managerDAO.findALL();
		for (Manager managers : managerList)
			System.out.println(managers);
	}
}
