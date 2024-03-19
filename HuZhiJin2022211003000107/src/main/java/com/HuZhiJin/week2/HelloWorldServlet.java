package com.HuZhiJin.week2;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {
    public HelloWorldServlet() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date day = new Date();
        out.println("<html><body>");
        out.println("name : Hu ZhiJin");
        out.println("</br>");
        out.println("Student ID:2022211003000107");
        out.println("</br>");
        out.println(df.format(day));
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}