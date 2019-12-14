package com.xxgc.test;


import com.xxgc.dao.UsersDAO;
import com.xxgc.model.Users;
public class SelectTest {
	public static void main(String[] args) {
		UsersDAO usersDAO = new UsersDAO();
		Users users = usersDAO.find(3);
		System.out.println(users);
	}
}
