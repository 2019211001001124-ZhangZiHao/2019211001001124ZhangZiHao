package com.ZhangZihao.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        filterName = "Filter_admin",
        urlPatterns = "/admin/*",
        dispatcherTypes = DispatcherType.REQUEST,
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
public class adminHomeFilter implements Filter {

//    private String filterName;
    private String adminName;
    private String adminPassword;
    public void init(FilterConfig config) throws ServletException {
        System.out.println("now i am here(filter)");

//        filterName = config.getFilterName();
        adminName = config.getInitParameter("adminName");
        adminPassword = config.getInitParameter("adminPassword");
    }

    public void destroy() {
        System.out.println("bye(filter)");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest Hrequest = (HttpServletRequest) request;
        HttpServletResponse Hresponse= (HttpServletResponse) response;

        String url = Hrequest.getRequestURI();

        System.out.println("请求的url：" + url);

        int idx = url.lastIndexOf("/");
        String endWith = url.substring(idx + 1);
        if (!endWith.equals("login")) {

            System.out.println("不是登录页面，拦截");

            switch (Login_status(Hrequest))
            {
                case 0:{
                    Hrequest.setAttribute("message","PLS login first");
                    Hrequest.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(Hrequest,Hresponse);
                    chain.doFilter(request, response);
                    break;
                }
                case 2:{
                    Hrequest.setAttribute("message","NOT admin");
                    Hrequest.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(Hrequest,Hresponse);
                    chain.doFilter(request, response);
                    break;
                }
                default:{
                    chain.doFilter(request, response);
                    break;
                }
            }
        }

    }

    private int Login_status(HttpServletRequest request){

        assert request!=null;

        String account = "";
        String pwd = "";

        Cookie[] cookies = request.getCookies();

        if (cookies != null && cookies.length > 0)
        {
            for (Cookie cookie:cookies)
            {
                if (cookie.getName().equals("cUserName"))
                    account = cookie.getValue();

                if (cookie.getName().equals("cPassword"))
                    pwd = cookie.getValue();
            }
        }//cookies 读取

        if (account.equals("") || pwd.equals(""))//未登入
            return 0;
        if((account.equals(adminName) && pwd.equals(adminPassword)))//管理员
            return 1;
        return 2;//一般用户
    }


}
