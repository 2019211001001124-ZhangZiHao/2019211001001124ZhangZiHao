package com.ZhangZihao.homework.week5;

import com.ZhangZihao.homework.week4.acti.UserTableInsert;
import com.ZhangZihao.homework.week4.acti.UserTableSelect;
import com.ZhangZihao.homework.week4.conn.Conn;
import com.ZhangZihao.homework.week4.table.usertable;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "LoginServlet",
        value = "/LoginServlet"
)
public class LoginServlet extends HttpServlet {

    Conn con;
    UserTableSelect selectWay;

    @Override
    public void init() throws ServletException{
        super.init();
        String dirver = getServletContext().getInitParameter("dirver");
        String url = getServletContext().getInitParameter("url");
        String User = getServletContext().getInitParameter("User");
        String Password = getServletContext().getInitParameter("Password");

        con = new Conn(url,User,Password);
        selectWay = new UserTableSelect(con);
    }

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

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        usertable table = new usertable(name,password);
        selectWay.SelectInDb(table);

        out.println("<html><head>"+
                "<jsp:include page=\"/homework5/header.jsp\"/>");

        out.println("<h1>");
        if(selectWay.fillTable(table))
        {
            out.println("Login Success!!!"+"<br/>"+
                    "Welcome!!!"+"<br/>"+
                    "ID"+table.getID()+':'+table.getUserName());
        }
        else
        {
            out.println("Username or Password Error!!!");
        }
        out.println("</h1>");

        out.println("<jsp:include page=\"/homework5/footer.jsp\"/>");
        selectWay.SelectClear();
    }
}
