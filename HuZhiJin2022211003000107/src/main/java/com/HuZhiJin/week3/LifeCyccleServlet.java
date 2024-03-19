package com.HuZhiJin.week3;

import com.example.huzhijin2022211003000107.HelloServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LifeCyccleServlet extends HttpServlet {

    public LifeCyccleServlet(){
        System.out.println("I am in constructor --> LifeCycleServlet()");
    }
    public void init(){
        System.out.println("I am in init()");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("I am in service() --> doGet()");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("I am in service() --> doPost()");

    }
}
