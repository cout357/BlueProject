package com.xxgc.model;

public class Catalog {
	private int caid;
	private String caname;
	private String canumber;
	private String castate;
	
	public Catalog() {}
	public Catalog(int caid,String caname,String canumber,String castate) {
		this.caid = caid;
		this.caname = caname;
		this.canumber = canumber;
		this.castate = castate;
	}
	@Override
	public String toString() {
		return "Catalog [caId=" + caid + ", caname="
				+ caname + ", caNum=" + canumber + ", castate=" + castate
				+ "]";
	}
	public int getCaid() {
		return caid;
	}
	public void setCaid(int caid) {
		this.caid = caid;
	}
	public String getCaname() {
		return caname;
	}
	public void setCaname(String caname) {
		this.caname = caname;
	}
	public String getCanumber() {
		return canumber;
	}
	public void setCanumber(String canumber) {
		this.canumber = canumber;
	}
	public String getCastate() {
		return castate;
	}
	public void setCastate(String castate) {
		this.castate = castate;
	}
	
	
}
