package com.omnipotent.listener;

import javax.servlet.*;
import javax.servlet.annotation.*;

/**
 * Description: <br/>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
 * Copyright (C), 2001-2016, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
	
	//应用启动时，该方法被调用。
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("应用服务启动...");
	}

	//应用关闭时，该方法被调用。
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("应用服务停止...");
	}
	
}
