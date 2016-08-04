package com.omnipotent.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;

@WebFilter(filterName="MyFilter", urlPatterns={"/*"}, initParams={@WebInitParam(name="encoding", value="UTF-8")})
public class MyFilter implements Filter {

	@SuppressWarnings("unused")
	private String filterURL;

	// FilterConfig可用于访问Filter的配置信息
	private FilterConfig config;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		filterURL = filterConfig.getInitParameter("filterURL");
		System.out.println("MyFilter init...");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		// 获取该Filter的配置参数
		String encoding = config.getInitParameter("encoding");
		// 设置request编码用的字符集
		request.setCharacterEncoding(encoding);
		
		System.out.println("--------------------------------------------------");
		String requestURI = request.getRequestURI();
		System.out.println("Request URI : " + requestURI);
		System.out.println("--------------------------------------------------");
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		// this.config = null;
		System.out.println("MyFilter destroy...");
	}

}
