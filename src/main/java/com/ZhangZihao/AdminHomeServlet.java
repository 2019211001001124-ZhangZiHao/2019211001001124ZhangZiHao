package com.ZhangZihao;

import com.ZhangZihao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "AdminHomeServlet",
        value = "/admin/Home",
        initParams = {
        @WebInitParam(
                name = "adminName",
                value = "adminZZH"
        ),
        @WebInitParam(
                name = "adminPassword",
                value = "123456"
        )
}
)
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*HttpSession Session= request.getSession(false);
        if(Session == null)
        {
            request.setAttribute("message","PLS login as admin first");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
            return;
        }

        User nowUser =(User) Session.getAttribute("user");
        if(nowUser ==null)
        {
            request.setAttribute("message","PLS login as admin first");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
        } else
        {
            if( nowUser.getUserName().equals(getInitParameter("adminName")) && nowUser.getPassword().equals(getInitParameter("adminPassword")))
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request,response);
            else
            {
                request.setAttribute("message","NOT admin");
                request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
            }
        }*///Complete in Filter

        request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
