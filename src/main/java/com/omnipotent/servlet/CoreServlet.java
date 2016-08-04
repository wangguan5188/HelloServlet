package com.omnipotent.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omnipotent.utils.StringUtil;

@WebServlet(name="CoreServlet", urlPatterns={"/coreServlet"})
public class CoreServlet extends HttpServlet {

	private static final long serialVersionUID = 7595340239426842224L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// super.doGet(request, response);
		
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// super.doPost(request, response);
		
		System.out.println("--------------------------------------------------");
		String action = StringUtil.toString(request.getParameter("action"), "");
		
		System.out.println("action = " + action);
		
		System.out.println("--------------------------------------------------");
	}

}
