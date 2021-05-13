package com.ZhangZihao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "ConfigServlet",
        urlPatterns = "/config",
        initParams = {
                @WebInitParam(
                        name = "Name",
                        value = "ZhangZihao"
                ),
                @WebInitParam(
                        name = "StudentId",
                        value = "2019211001001124"
                )
        }
)
public class ConfigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Name = getInitParameter("Name");
        String StudentId = getInitParameter("StudentId");

        response.setContentType("text/html");
        PrintWriter Config = response.getWriter();

        Config.println("<html><head>");
        Config.println("</head><body>");
        Config.println("Name:"+Name+"<br>");
        Config.println("StudentId:"+StudentId+"<br>");
        Config.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
