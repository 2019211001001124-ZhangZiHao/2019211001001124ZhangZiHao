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
        con=(Conn) getServletContext().getAttribute("con");
        selectWay=(UserTableSelect) getServletContext().getAttribute("selectWay");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
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
            /*out.println("Login Success!!!"+"<br/>"+
                    "Welcome!!!"+"<br/>"+
                    "ID"+table.getID()+':'+table.getUserName());*/
            request.setAttribute("ID",table.getID());
            request.setAttribute("UserName",table.getUserName());
            request.setAttribute("Password",table.getPassword());
            request.setAttribute("Email",table.getEmail());
            request.setAttribute("Gender",table.getGender());
            request.setAttribute("Birthdate",table.getBirthdate());

            request.getRequestDispatcher("./homework6/userInfo.jsp").forward(request,response);
        }
        else
        {
//            out.println("Username or Password Error!!!");
            request.setAttribute("message","Username or Password Error!!!");
            request.getRequestDispatcher("./homework5/login.jsp").forward(request,response);
        }
        /*
        out.println("</h1>");

        out.println("<jsp:include page=\"/homework5/footer.jsp\"/>");*/
    }
}
