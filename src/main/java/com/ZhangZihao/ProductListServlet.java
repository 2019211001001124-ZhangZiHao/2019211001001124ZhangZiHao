package com.ZhangZihao;

import com.ZhangZihao.dao.ProductDao;
import com.ZhangZihao.dao.UserDao;
import com.ZhangZihao.model.Conn;
import com.ZhangZihao.model.Product;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/admin/productList")
public class ProductListServlet extends HttpServlet {

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

        try {

            List<Product> list=DAO.findAll(con);
            request.setAttribute("productList",list);

            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("../WEB-INF/views/admin/productList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
