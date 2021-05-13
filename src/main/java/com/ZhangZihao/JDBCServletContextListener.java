package com.ZhangZihao;

//import com.ZhangZihao.dao.UserTableInsert;
//import com.ZhangZihao.dao.UserTableSelect;
import com.ZhangZihao.model.Conn;

import javax.servlet.*;
import javax.servlet.annotation.*;


@WebListener
public class JDBCServletContextListener implements ServletContextListener{

    ServletContext  SCT = null;

    Conn con = null;
//    UserTableInsert insertWay = null;
//    UserTableSelect selectWay = null;

    public JDBCServletContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        SCT = sce.getServletContext();
        String driver = SCT.getInitParameter("driver");
        String url = SCT.getInitParameter("url");
        String User = SCT.getInitParameter("User");
        String Password = SCT.getInitParameter("Password");

        con = new Conn(url,User,Password);
//        insertWay = new UserTableInsert(con);
//        selectWay = new UserTableSelect(con);

        SCT.setAttribute("con",con);
//        SCT.setAttribute("insertWay",insertWay);
//        SCT.setAttribute("selectWay",selectWay);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */

        SCT.removeAttribute("con");
        SCT.removeAttribute("insertWay");
        SCT.removeAttribute("selectWay");

//        con.close();
//        insertWay.close();
//        selectWay.close();
    }

}
