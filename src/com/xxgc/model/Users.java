package com.xxgc.model;

import java.sql.Date;

public class Users {
	private int id;
	private String username;
	private String password;
	private String email;
	private Date birthday;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Users [birthday=" + birthday + ", email=" + email + ", id="
				+ id + ", password=" + password + ", username=" + username
				+ "]";
	}
	
	
}
