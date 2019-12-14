package com.xxgc.model;

public class Manager {
	private int managerid;
	private String managername;
	private String passwd;
	private String mstate;
	
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getMstate() {
		return mstate;
	}
	public void setMstate(String mstate) {
		this.mstate = mstate;
	}
	@Override
	public String toString() {
		return "Manager [managerid=" + managerid + ", managername="
				+ managername + ", mstate=" + mstate + ", passwd=" + passwd
				+ "]";
	}
}
