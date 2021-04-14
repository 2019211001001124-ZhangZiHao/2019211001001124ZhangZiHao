package com.ZhangZihao.homework.week4;

import com.ZhangZihao.homework.week4.acti.UserTableInsert;
import com.ZhangZihao.homework.week4.acti.UserTableSelect;
import com.ZhangZihao.homework.week4.conn.Conn;
import com.ZhangZihao.homework.week4.table.usertable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.*;

@WebServlet(
        name = "ServletR",
        value = "/ToMyDb",
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
    UserTableInsert insertWay;
    UserTableSelect selectWay;

    String name;
    String password;
    String email;
    String Gender;
    String birthday;

    @Override
    public void init() throws ServletException{
        super.init();
        con=(Conn) getServletContext().getAttribute("con");
        selectWay=(UserTableSelect) getServletContext().getAttribute("selectWay");
        insertWay=(UserTableInsert) getServletContext().getAttribute("insertWay");

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
        usertable tableI = new usertable(name,password,email,Gender,birthday);
        insertWay.doInsert(tableI);

        response.sendRedirect("./homework5/login.jsp");

        /*usertable tableS = new usertable();
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
