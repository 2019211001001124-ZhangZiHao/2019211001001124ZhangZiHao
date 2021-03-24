package com.ZhangZihao.homework.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("?,error access mode ");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name =       request.getParameter("name");
        String password =   request.getParameter("password");
        String email =      request.getParameter("email");
        String sex =        request.getParameter("sex");
        String birthday =   request.getParameter("birthday");

        out.println("<html><body>");
        out.println("<div>");
        out.println("name:"+name+"</br>");
        out.println("password:"+password+"</br>");
        out.println("email:"+email+"</br>");
        out.println("sex:"+sex+"</br>");
        out.println("birthday:"+birthday+"</br>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
