package com.xxgc.test;

import com.xxgc.dao.ManagerDAO;
import com.xxgc.dao.UsersDAO;

public class DeleteTest {
	public static void main(String[] args) {
		ManagerDAO mDAO = new ManagerDAO();
		mDAO.managerDeleteUseId(12);
	}
}
