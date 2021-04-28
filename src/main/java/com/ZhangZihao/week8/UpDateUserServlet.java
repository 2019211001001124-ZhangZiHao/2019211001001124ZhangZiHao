package com.ZhangZihao.week8;

import com.ZhangZihao.dao.UserDao;
import com.ZhangZihao.model.User;
import com.ZhangZihao.week4.conn.Conn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpDateUserServlet", value = "/UpDateUser")
public class UpDateUserServlet extends HttpServlet {

    Conn con;
    UserDao DAO=new UserDao();

    @Override
    public void init() throws ServletException{
        super.init();
        Object x=getServletContext().getAttribute("con");
        con = (Conn) x;
//        con=(Conn) getServletContext().getAttribute("con");
//        selectWay=(UserTableSelect) getServletContext().getAttribute("selectWay");
//        insertWay=(UserTableInsert) getServletContext().getAttribute("insertWay");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./WEB-INF/views/upDateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User newUser =new User();

        newUser.setID(          Integer.parseInt(request.getParameter("id"))    );
        newUser.setUserName(    request.getParameter("name")                    );
        newUser.setPassword(    request.getParameter("password")                );
        newUser.setEmail(       request.getParameter("email")                   );
        newUser.setGender(      request.getParameter("sex")                     );
        newUser.setBirthdate(   request.getParameter("birthday")                );

        try {
            DAO.updateUser(con,newUser);
        }catch (SQLException E){
            E.printStackTrace();
        }
        HttpSession session = request.getSession(false);
        assert session!=null;
        session.setAttribute("user",newUser);
        request.getRequestDispatcher("./WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}
