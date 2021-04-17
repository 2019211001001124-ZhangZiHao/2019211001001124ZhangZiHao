package com.ZhangZihao.week4;

import com.ZhangZihao.dao.UserDao;
//import com.ZhangZihao.dao.UserTableInsert;
//import com.ZhangZihao.dao.UserTableSelect;
import com.ZhangZihao.week4.conn.Conn;
import com.ZhangZihao.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.annotation.*;

@WebServlet(
        name = "Servlet",
        value = "/register",
//        urlPatterns = "/ToMyDb",
        initParams = {
                @WebInitParam(
                        name = "address",
                        value = "jdbc:sqlserver://localhost:1314;DatabaseName=userdb"
                ),
                @WebInitParam(
                        name = "User",
                        value = "ZZH"
                ),
                @WebInitParam(
                        name = "password",
                        value = "zzh"
                )
        }
        )
public class registerServlet extends HttpServlet {

    Conn con;
//    UserTableInsert insertWay;
//    UserTableSelect selectWay;
    UserDao DAO=new UserDao();

    String name;
    String password;
    String email;
    String Gender;
    String birthday;

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
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        name =       request.getParameter("name");
        password =   request.getParameter("password");
        email =      request.getParameter("email");
        Gender =        request.getParameter("sex");
        birthday =   request.getParameter("birthday");
        User tableI = new User(name,password,email,Gender,birthday);
        try {
            DAO.saveUser(con,tableI);
        }catch (SQLException E){
            E.printStackTrace();
        }
//        insertWay.doInsert(tableI);

        response.sendRedirect("./homework5/login.jsp");

        /*User tableS = new User();
        tableS.setUserName(name);
        tableS.setPassword(password);
        selectWay.SelectInDb(tableS);
        selectWay.fillTable(tableS);
        selectWay.SelectClear();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("" +
                "<html>\n" +
                "<head>\n" +
                "<jsp:include page=\"/homework5/header.jsp\"/>" +
                "<table frame=\"box\" rules=\"all\">\n" +
                "    <th>ID</th>\n" +
                "    <th>UserName</th>\n" +
                "    <th>Password</th>\n" +
                "    <th>Email</th>\n" +
                "    <th>Gender</th>\n" +
                "    <th>Birthdate</th>\n" +
                "    <tr>\n" +
                "        <td>\n" +
                "            "+tableS.getID()+"\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            "+tableS.getUserName()+"\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            "+tableS.getPassword()+"\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            "+tableS.getEmail()+"\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            "+tableS.getGender()+"\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            "+tableS.getBirthdate()+"\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<jsp:include page=\"/homework5/footer.jsp\"/>");*/
    }

/*    public void destroy(){
        super.destroy();
    }*/
}
