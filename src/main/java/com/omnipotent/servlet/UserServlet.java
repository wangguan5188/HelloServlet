package com.omnipotent.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omnipotent.utils.StringUtil;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 9119111592625404375L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = StringUtil.toString(request.getParameter("action"), "");
		System.out.println("--------------------------------------------------");
		
		System.out.println("action = " + action);
		
		System.out.println("--------------------------------------------------");
		if("toLogin".equals(action)) {
			toLogin(request, response);
		} else if("login".equals(action)) {
			login(request, response);
		} else if("register".equals(action)) {
			register(request, response);
		} else if("toRegister".equals(action)) {
			toRegister(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
		}
	}
	
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = StringUtil.toString(request.getParameter("username"), null);
		String password = StringUtil.toString(request.getParameter("password"), null);
		System.out.println(username + "-" + password);
		System.out.println("登陆成功.");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}
	
	public void toRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳转到注册页面...");
		request.getRequestDispatcher("/WEB-INF/view/user/register.jsp").forward(request, response);
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("注册...");
		request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
	}

}
