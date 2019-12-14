package com.xxgc.model;

public class Article {
	private String arid;
	private int caid;
	private String arnumber;
	private String artitle;
	private String arimage;
	private String arcontent;
	private String aruser;
	private String artime;
	private String arstate;
	private int clicks;

	private String caname;
	
	public Article() {
		
	}
	
	
	public Article(String arid, int caid, String arnumber, String artitle, String arimage, String arcontent,
			String aruser, String artime, String arstate, int clicks, String caname) {
		super();
		this.arid = arid;
		this.caid = caid;
		this.arnumber = arnumber;
		this.artitle = artitle;
		this.arimage = arimage;
		this.arcontent = arcontent;
		this.aruser = aruser;
		this.artime = artime;
		this.arstate = arstate;
		this.clicks = clicks;
		this.caname = caname;
	}


	public String getCaname() {
		return caname;
	}
	public void setCaname(String caname) {
		this.caname = caname;
	}
	public String getArid() {
		return arid;
	}
	public void setArid(String arid) {
		this.arid = arid;
	}
	public int getCaid() {
		return caid;
	}
	public void setCaid(int caid) {
		this.caid = caid;
	}
	public String getArnumber() {
		return arnumber;
	}
	public void setArnumber(String arnumber) {
		this.arnumber = arnumber;
	}
	public String getArtitle() {
		return artitle;
	}
	public void setArtitle(String artitle) {
		this.artitle = artitle;
	}
	public String getArimage() {
		return arimage;
	}
	public void setArimage(String arimage) {
		this.arimage = arimage;
	}
	public String getArcontent() {
		return arcontent;
	}
	public void setArcontent(String arcontent) {
		this.arcontent = arcontent;
	}
	public String getAruser() {
		return aruser;
	}
	public void setAruser(String aruser) {
		this.aruser = aruser;
	}
	public String getArtime() {
		return artime;
	}
	public void setArtime(String artime) {
		this.artime = artime;
	}
	public String getArstate() {
		return arstate;
	}
	public void setArstate(String arstate) {
		this.arstate = arstate;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	
	
}
