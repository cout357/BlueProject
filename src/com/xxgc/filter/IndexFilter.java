package com.xxgc.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xxgc.dao.ArticleDAO;
import com.xxgc.model.Article;

public class IndexFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		ArticleDAO aDAO = new ArticleDAO();
		ArrayList<Article> articles = aDAO.findAll();
		request.setAttribute("articles", articles);
		System.out.println("拦截首页");
		chain.doFilter(request, response);
		System.out.println("放行首页");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
