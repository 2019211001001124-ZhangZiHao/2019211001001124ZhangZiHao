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
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16*1024*1024-1) // B--KB--MB 16
public class AddProductServlet extends HttpServlet {

    Conn con;
    ProductDao DAO = new ProductDao();

    @Override
    public void init() throws ServletException{
        super.init();
        Object x=getServletContext().getAttribute("con");
        con = (Conn) x;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryDao DAO = new CategoryDao();
        List<Category> categoryList =null;

        try {
            categoryList = DAO.findAll(con);
            assert categoryList != null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.setAttribute("categoryList",categoryList);

        request.getRequestDispatcher("../WEB-INF/views/admin/addProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName      =   request.getParameter("productName");
        String price_s          =   request.getParameter("price");
        String categoryId_s     =   request.getParameter("categoryId");
        String productDes       =   request.getParameter("productDes");
        {
            assert productName  != null;
            assert price_s      != null;
            assert categoryId_s != null;
            assert productDes   != null;
        }
        double price=Double.parseDouble(price_s);
        int categoryId=Integer.parseInt(categoryId_s);

        InputStream picture = null;
        Part filePart = request.getPart("picture");
        picture = filePart.getInputStream();
        /**/

        Product Product = new Product(productName,productDes,picture,price,categoryId);

        try {
            DAO.save(Product,con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
