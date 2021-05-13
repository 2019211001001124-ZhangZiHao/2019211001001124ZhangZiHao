package com.ZhangZihao;

import com.ZhangZihao.dao.UserDao;
//import com.ZhangZihao.dao.UserTableSelect;
import com.ZhangZihao.model.Conn;
import com.ZhangZihao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "LoginServlet",
        value = "/login"
)
public class LoginServlet extends HttpServlet {

    Conn con;
    UserDao DAO=new UserDao();
//    UserTableSelect selectWay;

    @Override
    public void init() throws ServletException{
        super.init();
        con=(Conn) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60*2);

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String RM = request.getParameter("RM");



        User table = new User(name,password);
        try {
            table=DAO.findByUsernamePassword(con,table.getUserName(), table.getPassword());
        } catch (SQLException E) {
            E.printStackTrace();
        }

        if(table!=null)
        {

            Cookie cUserName = new Cookie("cUserName",name);
            Cookie cPassword = new Cookie("cPassword",password);

            response.addCookie(cUserName);
            response.addCookie(cPassword);
            cUserName.setMaxAge(60*2);
            cPassword.setMaxAge(60*2);

            if(RM!=null && RM.equals("checked"))
            {
                Cookie cRM = new Cookie("cRM",RM);
                response.addCookie(cRM);
                cRM.setMaxAge(60*2);
            }

            session.setAttribute("user",table);
            System.out.println("LMS:"+session.getId());

            request.getRequestDispatcher("./WEB-INF/views/index.jsp").forward(request,response);

        } else
        {
            request.setAttribute("message","Username or Password Error!!!");
            request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
        }
    }
}
