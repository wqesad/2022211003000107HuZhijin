package com.HuZhiJin.week6.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");

        if (txt == null || txt.isEmpty()) {
            // 如果搜索文本为空，重定向到主页（index.jsp）
            response.sendRedirect("index.jsp");
        } else {
            redirectSearchEngine(response, txt, search);
        }
    }

    private void redirectSearchEngine(HttpServletResponse response, String txt, String search) throws IOException {
        String redirectUrl = "";
        switch (search) {
            case "baidu":
                redirectUrl = "https://www.baidu.com/s?wd=" + txt;
                break;
            case "bing":
                redirectUrl = "https://cn.bing.com/search?q=" + txt;
                break;
            case "google":
                redirectUrl = "https://www.google.com/search?q=" + txt;
                break;
            default:
                // 默认情况下重定向到谷歌搜索
                redirectUrl = "https://www.google.com/search?q=" + txt;
                break;
        }
        response.sendRedirect(redirectUrl);
    }
}

