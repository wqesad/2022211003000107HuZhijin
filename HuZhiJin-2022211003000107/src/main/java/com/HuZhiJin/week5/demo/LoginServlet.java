package com.HuZhiJin.week5.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handling GET requests
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Load the database driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the database connection
            String url = "jdbc:sqlserver://localhost:1433;databaseName=userdb;";
            String dbUsername = "sa";
            String dbPassword = "123456";
            try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {

                // Execute the query
                String query = "SELECT * FROM usertable WHERE username = ? AND password = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, username);
                    statement.setString(2, password);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            // User authentication successful
                            // response.getWriter().println("<h1>User Info</h1>");
                            // response.getWriter().println("<h1>Welcome " + username + "</h1>");

                            // Output all user information
                            // String userName = resultSet.getString("username");
                            // String Password = resultSet.getString("password");
                            // String Email = resultSet.getString("email");
                            // String Gender = resultSet.getString("gender");
                            // String userBirthdate = resultSet.getString("birthdate");

                            // response.getWriter().println("<p>Username: " + userName + "</p>");
                            // response.getWriter().println("<p>password: " + Password + "</p>");
                            // response.getWriter().println("<p>Email: " + Email + "</p>");
                            // response.getWriter().println("<p>Gender: " + Gender + "</p>");
                            // response.getWriter().println("<p>Birthdate: " + userBirthdate + "</p>");
                            request.setAttribute("id", resultSet.getInt("id"));
                            request.setAttribute("username", resultSet.getString("username"));
                            request.setAttribute("password", resultSet.getString("password"));
                            request.setAttribute("email", resultSet.getString("email"));
                            request.setAttribute("gender", resultSet.getString("gender"));
                            request.setAttribute("birthDate", resultSet.getString("birthdate"));

                            request.getRequestDispatcher("userInfo.jsp").forward(request, response);
                        } else {
                            // User authentication failed
                            request.setAttribute("message", "Username or Password Error!!!");
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                    }
                }
            } catch (SQLException e) {
                // Handle database errors
                e.printStackTrace(); // Consider logging the error
            }
        } catch (ClassNotFoundException e) {
            // Handle driver not found
            e.printStackTrace(); // Consider logging the error
        }
    }
}
