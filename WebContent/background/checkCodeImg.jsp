<%@ page language="java" contentType="image/jpeg; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ page import="javax.imageio.ImageIO"%>

<%!
	public Color getColor(){
		Random ran = new Random();
		int a[] = new int[3];
		for(int i = 0;i < 3;i++)
			a[i] = ran.nextInt(256);
		
		return new Color(a[0],a[1],a[2]);		//red green blue
	}
	public String getNum(){
		int num = (int)(Math.random()*9000+1000);
		return String.valueOf(num);
	}


%>

<%
	//禁止缓存
	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-control","no-cache");
	response.setHeader("Expires","0");
	
	//绘制验证码
	BufferedImage image = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
	//画笔
	Graphics graphics = image.getGraphics();
	graphics.fillRect(0,0,80,30);
	//绘制干扰线条
	for(int i = 0;i < 40;i++){
		Random ran = new Random();
		int xBegin = ran.nextInt(80);
		int yBegin = ran.nextInt(30);
		int xEnd = ran.nextInt(xBegin+1);
		int yEnd = ran.nextInt(yBegin+1);
		graphics.setColor(getColor());
		//绘制线条
		graphics.drawLine(xBegin,yBegin,xEnd,yEnd);
	}
	
	//绘制验证码
	graphics.setFont(new Font("seif",Font.BOLD,20));
	graphics.setColor(Color.black);
	String checkCode = getNum();
	StringBuffer sb = new StringBuffer();
	for(int i = 0;i < checkCode.length();i++)
		sb.append(checkCode.charAt(i)+" ");
	graphics.drawString(sb.toString(),15,20);		//绘制验证码
	
	//将验证码真实值保存起来
	session.setAttribute("checkCode",checkCode);
	
	//真实的产生图片
	ImageIO.write(image,"jpeg",response.getOutputStream());
	
	//关闭
	out.clear();
	out = pageContext.pushBody();		//把图片放入路径
%>