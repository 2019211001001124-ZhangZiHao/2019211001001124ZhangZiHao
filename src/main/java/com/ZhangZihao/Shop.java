package com.ZhangZihao;

import com.ZhangZihao.dao.CategoryDao;
import com.ZhangZihao.dao.ProductDao;
import com.ZhangZihao.model.Category;
import com.ZhangZihao.model.Conn;
import com.ZhangZihao.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Shop", value = "/shop")
public class Shop extends HttpServlet {

    Conn con;
    CategoryDao DAO_c;
    ProductDao DAO_p;

    @Override
    public void init() throws ServletException{
        super.init();

        con=(Conn) getServletContext().getAttribute("con");
        DAO_c=new CategoryDao();
        DAO_p=new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList=null;
        List<Product> productList=null;

        try {
            categoryList=DAO_c.findAll(con);
            productList=DAO_p.findAll(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assert categoryList!=null;
        assert productList!=null;
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("productList",productList);


        request.getRequestDispatcher("./WEB-INF/views/shop.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
