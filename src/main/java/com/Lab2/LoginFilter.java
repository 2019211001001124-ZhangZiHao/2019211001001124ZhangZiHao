package com.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        filterName = "LoginFilter",
        urlPatterns = {"/Lab2/welcome.jsp"}

)
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("I am in LoginFilter--init()");
    }

    public void destroy() {
        System.out.println("I am in LoginFilter--destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req  = (HttpServletRequest)  request;
        HttpServletResponse rep = (HttpServletResponse) response;

        System.out.println("I am in LoginFilter--doFilter()-- request before chain");
        if( req.getSession(false)!=null )
            chain.doFilter(request, response);
        else
            rep.sendRedirect("Lab2/login.jsp");

        System.out.println("I am in LoginFilter--destroy()-- response after chain");
    }
}

/*
        todo 1: map this filter for  - /lab2/welcome.jsp
        todo 2: print i am in LoginFilter--init()
        todo 3: print i am in LoginFilter--destroy()
        todo 4: print i am in LoginFilter--doFilter()-- request before chain
        todo 6: if session not new
        todo 7: forward to lab2/welcome.jsp
        todo 8: else redirect to login.jsp
*/

