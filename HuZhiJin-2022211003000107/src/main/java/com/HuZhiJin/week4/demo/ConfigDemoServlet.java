package com.HuZhiJin.week4.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "ConfigDemoServlet",
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name1", value = "KuangYafei"),
                @WebInitParam(name = "studentId1", value = "2022211003000108")
        }
)
public class ConfigDemoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 获取Servlet配置参数
        String name = getServletConfig().getInitParameter("name1");
        String studentId = getServletConfig().getInitParameter("studentId1");

        out.println("<html><body>");
        out.println("<h2>Task 1-Get init parameters from web.xml</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Student ID: " + studentId + "<br>");

        // 添加Task2部分
        out.println("<h2>Task 2-Get init parameters from @WebServlet</h2>");
        out.println("Name1: " + name + "<br>");
        out.println("Student ID1: " + studentId + "<br>");

        out.println("</body></html>");
    }
}
