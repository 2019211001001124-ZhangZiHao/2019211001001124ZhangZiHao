package com.ZhangZihao.week5;

import com.ZhangZihao.dao.UserDao;
//import com.ZhangZihao.dao.UserTableSelect;
import com.ZhangZihao.week4.conn.Conn;
import com.ZhangZihao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        name = "LoginServlet",
        value = "/LoginServlet"
)
public class LoginServlet extends HttpServlet {

    Conn con;
    UserDao DAO=new UserDao();
//    UserTableSelect selectWay;

    @Override
    public void init() throws ServletException{
        super.init();
        con=(Conn) getServletContext().getAttribute("con");
//        selectWay=(UserTableSelect) getServletContext().getAttribute("selectWay");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*        response.setContentType("text/html");
        PrintWriter out = response.getWriter();*/

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User table = new User(name,password);

        try {
            table=DAO.findByUsernamePassword(con,table.getUserName(), table.getPassword());
        } catch (SQLException E) {
            E.printStackTrace();
        }
//        selectWay.SelectInDb(table);

/*        out.println("<html><head>"+
                "<jsp:include page=\"/homework5/header.jsp\"/>");

        out.println("<h1>");*/
        if(table!=null)//selectWay.fillTable(table)
        {

//            request.setAttribute("user",table);
            String RM = request.getParameter("RM");
            if(RM!=null && RM.equals("checked"))
            {
                Cookie cUserName = new Cookie("cUserName",table.getUserName());
                Cookie cPassword = new Cookie("cPassword",table.getPassword());
                Cookie cRM = new Cookie("cRM",RM);

                cUserName.setMaxAge(60*2);
                cPassword.setMaxAge(60*2);
                cRM.setMaxAge(60*2);

                response.addCookie(cUserName);
                response.addCookie(cPassword);
                response.addCookie(cRM);
            }

            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*2);
            session.setAttribute("user",table);
            System.out.println("LMS:"+session.getId());

            request.getRequestDispatcher("./WEB-INF/views/userInfo.jsp").forward(request,response);
        }
        else
        {
//            out.println("Username or Password Error!!!");
            request.setAttribute("message","Username or Password Error!!!");
            request.getRequestDispatcher("./WEB-INF/views/login.jsp").forward(request,response);
        }
        /*
        out.println("</h1>");

        out.println("<jsp:include page=\"/homework5/footer.jsp\"/>");*/
    }
}
