package com.ZhangZihao.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String way = request.getParameter("way");
        String search = request.getParameter("search");
        if(way.equals("Baidu"))
        {
            response.sendRedirect("https://www.baidu.com/s?wd="+search);
        }
        if(way.equals("Sogou"))
        {
            response.sendRedirect("https://www.sogou.com/web?query="+search);
        }
        if(way.equals("Bing"))
        {
            response.sendRedirect("https://cn.bing.com/search?q="+search);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
