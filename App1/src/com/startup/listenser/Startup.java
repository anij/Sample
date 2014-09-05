package com.startup.listenser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Startup implements ServletContextListener{
	
	public static String STR_APP_ABSOLUTE_PATH;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		STR_APP_ABSOLUTE_PATH = arg0.getServletContext().getRealPath("/");
		System.out.println("App Absolute Path: " +STR_APP_ABSOLUTE_PATH);
		
	}

}
