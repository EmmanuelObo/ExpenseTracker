package com.emmaobo.expensetracker.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class InitializeListener
 *
 */

public class InitializeListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitializeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
    	sce.getServletContext().setAttribute("context", context);
    }
	
}
