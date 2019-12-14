package com.xxgc.test;


import java.util.ArrayList;

import com.xxgc.dao.UsersDAO;
import com.xxgc.model.Users;

public class FindALLTest {
	public  static void main(String[] args) {
		
		UsersDAO usersDAO = new UsersDAO();
		ArrayList<Users>  usersList = usersDAO.findALL();
		for(Users users :usersList){
			System.out.println(users);
		}
	}

}
