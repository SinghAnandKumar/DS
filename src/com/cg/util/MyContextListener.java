package com.cg.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;


public class MyContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext application = arg0.getServletContext();
		
		try {
			DataSource ds = ServiceLocator.getDataSource();
			Connection dbConnection = ds.getConnection();
			
			System.out.println("Connection successful ?"+(dbConnection!=null));
			
			if(ds!=null){
				
				application.setAttribute("connector", ds);
			}
		}catch(NamingException | SQLException e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ServletContext application = arg0.getServletContext();
		
	}


}
