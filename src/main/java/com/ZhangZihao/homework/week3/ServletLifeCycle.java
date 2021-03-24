package com.ZhangZihao.homework.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLifeCycle", value = "/ServletLifeCycle")
public class ServletLifeCycle extends HttpServlet {
    @Override
    public void init(){
        try {
            super.init();
            } catch (ServletException e) {
            e.printStackTrace();
        }
        System.out.println("Hey!!!!!!!!!!!!!!!");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am here!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("where are you?");
    }

    @Override
    public void destroy(){
        super.destroy();

        System.out.println("No!!!!!!!!!!!!!!!!!!!");
    }
}
