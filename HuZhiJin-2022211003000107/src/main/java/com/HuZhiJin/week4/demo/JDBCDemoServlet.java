package com.HuZhiJin.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//@WebServlet(
//        urlPatterns = {"/jdbc"},
//        initParams = {
//                @WebInitParam(name = "driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//                @WebInitParam(name = "url", value = "jdbc:sqlserver://localhost:1433;databaseName=userdb;"),
//                @WebInitParam(name = "username", value = "sa"),
//                @WebInitParam(name = "password", value = "123456"),
//        },
//        loadOnStartup = 1
//)
public class JDBCDemoServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(JDBCDemoServlet.class.getName());
    private static final long serialVersionUID = 1L;
    private Connection con;

    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            logger.info("Database connection established.");
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Failed to connect to the database.", e);
            throw new ServletException("Database connection failed", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql = "SELECT * FROM usertable";
        try (PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>User List</title></head>");
            out.println("<body>");
            out.println("<h1>User List</h1>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Username</th>");
            out.println("<th>Password</th>");
            out.println("<th>Email</th>");
            out.println("<th>Gender</th>");
            out.println("<th>Birthdate</th>");
            out.println("</tr>");

            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt("id") + "</td>");
                out.println("<td>" + resultSet.getString("username") + "</td>");
                out.println("<td>" + resultSet.getString("password") + "</td>");
                out.println("<td>" + resultSet.getString("email") + "</td>");
                out.println("<td>" + resultSet.getString("gender") + "</td>");
                out.println("<td>" + resultSet.getDate("birthdate") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQL error occurred", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching user data");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handling POST requests if needed
    }

    @Override
    public void destroy() {
        super.destroy();
        if (con != null) {
            try {
                con.close();
                logger.info("Database connection closed.");
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error closing database connection", e);
            }
        }
    }
}


