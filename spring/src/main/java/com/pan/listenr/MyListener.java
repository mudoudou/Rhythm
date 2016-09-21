package com.pan.listenr;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyListener implements ServletContextListener  {

  
    public MyListener() {
    }


	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Listener die");  
		  
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Listener init");  
		  
	}
	
}
