package com.ZhangZihao.week8;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/LogOut")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(false).invalidate();
        String message = "Logged out now";
        request.setAttribute("message",message);
        request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
