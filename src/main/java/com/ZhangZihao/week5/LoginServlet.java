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
            /*out.println("Login Success!!!"+"<br/>"+
                    "Welcome!!!"+"<br/>"+
                    "ID"+table.getID()+':'+table.getUserName());*/
            request.setAttribute("ID",table.getID());
            request.setAttribute("UserName",table.getUserName());
            request.setAttribute("Password",table.getPassword());
            request.setAttribute("Email",table.getEmail());
            request.setAttribute("Gender",table.getGender());
            request.setAttribute("Birthdate",table.getBirthdate());

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
