package com.HuZhiJin.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=userdb";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "admin123456";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        // Store the registration information in the database
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "INSERT INTO usertable (username, password, email, gender, birthdate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setString(4, gender);
            statement.setString(5, birthDate);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Display the contents of the usertable in a horizontal table
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "SELECT * FROM usertable";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            PrintWriter writer = response.getWriter();
            writer.println("<table border='1'>");
            writer.println("<h1>User List</h1>");
            writer.println("<tr><th>ID</th><th>Username</th><th>Password</th><th>Email</th><th>Gender</th><th>Birth Date</th></tr>");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                String dbEmail = resultSet.getString("email");
                String dbGender = resultSet.getString("gender");
                String dbBirthDate = resultSet.getString("birthdate");

                writer.println("<tr>");
                writer.println("<td>" + id + "</td>");
                writer.println("<td>" + dbUsername + "</td>");
                writer.println("<td>" + dbPassword + "</td>");
                writer.println("<td>" + dbEmail + "</td>");
                writer.println("<td>" + dbGender + "</td>");
                writer.println("<td>" + dbBirthDate + "</td>");
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

