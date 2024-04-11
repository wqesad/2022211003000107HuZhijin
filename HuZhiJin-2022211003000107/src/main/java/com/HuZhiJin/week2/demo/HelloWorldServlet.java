package com.HuZhiJin.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HelloWorldServlet extends HttpServlet {

    public HelloWorldServlet() {
    }
    public void doGet(HttpServletRequest request, HttpServletResponse reponse)
            throws IOException {

        PrintWriter out=reponse.getWriter();
        out.println("<body><html>");
        out.println("name : Kuang Yafei"+"<br>");
        out.println("Student Id: 2022211003000108"+"<br>");
        out.println("</body></html>");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date day = new Date();
        out.println("<html><body>");
        out.println("Date and Time: " + df.format(day));
        out.println("</body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse reponse){

    }
}
