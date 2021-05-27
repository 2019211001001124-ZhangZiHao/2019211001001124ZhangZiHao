package com.ZhangZihao;

import com.ZhangZihao.dao.ProductDao;
import com.ZhangZihao.model.Conn;
import com.ZhangZihao.model.Product;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "getImg", value = "/getImg")
public class getImg extends HttpServlet {

    Conn con;
    ProductDao DAO;

    @Override
    public void init() throws ServletException{
        super.init();

        con=(Conn) getServletContext().getAttribute("con");
        DAO=new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InputStream instream = null;
        String s_id=request.getParameter("id");
        assert s_id!=null;
        int id=Integer.parseInt(s_id);

        try {
            instream = DAO.getPicture(id,con);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        response.setContentType("image/png");
        int read;
        while ((read=instream.read())!=-1)
            response.getOutputStream().write((char)read);

        instream.close();

        response.getOutputStream().flush();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
