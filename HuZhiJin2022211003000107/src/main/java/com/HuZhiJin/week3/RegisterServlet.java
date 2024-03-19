package com.HuZhiJin.week3;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("I am in service() --> doGet()");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username= request.getParameter("name");
        String password= request.getParameter("Password");
        String email= request.getParameter("Email");
        String Gender= request.getParameter("sex");
        String birthday= request.getParameter("birthday");

        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("username:"+username);
        writer.println("<br>password:"+password);
        writer.println("<br>email:"+email);
        writer.println("<br>Gender:"+Gender);
        writer.println("<br>birthday:"+birthday);
        writer.println("</html></body>");
        writer.close();
    }
}
