package com.HuZhiJin.week6.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        Connection con = (Connection) context.getAttribute("con");
        if (con != null) {
            try {
                con.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                // Handle database errors
                e.printStackTrace();
            }
        }
        context.removeAttribute("con");
    }

    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established.");
            context.setAttribute("con", con);
        } catch (SQLException e) {
            // Handle database errors
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Handle driver not found
            e.printStackTrace();
        }
    }
}


