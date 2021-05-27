package com.ZhangZihao.dao;

import com.ZhangZihao.model.Conn;
import com.ZhangZihao.model.Product;
import com.ZhangZihao.model.User;

import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductDao implements  IProductDao{

    String SQLs;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    Product tempProduct;
    List<Product> tempProductList;

    public ProductDao(){
        SQLs="";
        st=null;
        pst=null;
        rs=null;
        tempProduct=new Product();
        tempProductList= new LinkedList<>();
    }

    @Override
    public int save(Product product, Conn con) throws SQLException {

        SQLs = "" +
                " INSERT " +
                " INTO [product] " +
                " (ProductName,ProductDes,Picture,price,CategoryID) " +
                " values(?,?,?,?,?) " +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst.setString(1, product.getProductName());
        pst.setString(2, product.getProductDes());
        if(product.getPicture()!=null)
            pst.setBinaryStream(3, product.getPicture());
        pst.setDouble(4, product.getPrice());
        pst.setInt(5, product.getCategoryId());

        //return n>0?n:0;
        return pst.executeUpdate();

    }//end save

    @Override
    public int delete(Integer productId, Conn con) throws SQLException{
        SQLs = "" +
                " DELETE " +
                " FROM [Product] " +
                " WHERE " +
                " ProductId = ? " +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst.setInt(1,productId);

        return pst.executeUpdate();
    }

    @Override
    public int update(Product instance, Conn con) throws SQLException{

        SQLs = "" +
                " UPDATE [Product] "+
                " SET "             +
                " ProductName = ?, "+
                " ProductDes = ?, " +
                " Picture = ?, "    +
                " price = ?, "      +
                " CategoryID = ? "  +
                " WHERE "           +
                " ProductId = ?"    +
                ";";

        pst = con.getConn().prepareStatement(SQLs);

        pst.setString(1,instance.getProductName());
        pst.setString(2,instance.getProductDes());
        pst.setBinaryStream(3,instance.getPicture());
        pst.setDouble(4,instance.getPrice());
        pst.setInt(5,instance.getCategoryId());

        return pst.executeUpdate();

    }

    @Override
    public Product findById(Integer productId, Conn con) throws SQLException{

        SQLs = "" +
                " SELECT * "             +
                " FROM [Product] "       +
                " WHERE " +
                " ProductId = ? "   +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst=con.getConn().prepareStatement(SQLs);
        pst.setInt(1,productId);
        rs= pst.executeQuery();

        if (rs.next())
            getAllInfo(rs);

        return tempProduct;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Conn con) throws SQLException{

        SQLs = "" +
                " SELECT * "             +
                " FROM [Product] "       +
                " WHERE " +
                " CategoryId = ? "   +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst.setInt(1,categoryId);
        rs= pst.executeQuery();

        tempProductList.clear();
        while (rs.next()){
            getAllInfo(rs);
            tempProductList.add(tempProduct);
            tempProduct=new Product();
        }

        if(tempProductList.isEmpty())
            return null;
        return tempProductList;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Conn con) throws SQLException {

        SQLs = "" +
                " SELECT * "                +
                " FROM [Product] "          +
                " WHERE "                   +
                " price >= ? "              + " AND " +
                " price <= ?"               +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst.setDouble(1,minPrice);
        pst.setDouble(2,maxPrice);
        rs= pst.executeQuery();

        tempProduct=null;
        tempProductList.clear();
        while (rs.next()){
            getAllInfo(rs);
            tempProductList.add(tempProduct);
            tempProduct=new Product();
        }

        if(tempProductList.isEmpty())
            return null;
        return tempProductList;
    }

    @Override
    public List<Product> findAll(Conn con) throws SQLException {

        SQLs = "" +
                " SELECT * "                +
                " FROM [Product] "          +
                ";";
        st= con.getStatement();
        rs= st.executeQuery(SQLs);

        tempProductList.clear();
        while (rs.next()){
            getAllInfo(rs);
            tempProductList.add(tempProduct);
            tempProduct=new Product();
        }

        if(tempProductList.isEmpty())
            return null;
        return tempProductList;
    }

    @Override
    public List<Product> findByProductName(String productName, Conn con) throws SQLException {

        SQLs = "" +
                " SELECT * "             +
                " FROM [Product] "       +
                " WHERE " +
                " ProductName = ? "   +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst.setString(1,productName);
        rs= pst.executeQuery();

        tempProductList.clear();
        while (rs.next()){
            getAllInfo(rs);
            tempProductList.add(tempProduct);
        }

        if(tempProductList.isEmpty())
            return null;
        return tempProductList;
    }

    @Override
    public InputStream getPicture(Integer productId, Conn con) throws SQLException {
        SQLs = "" +
                " SELECT * "             +
                " FROM [Product] "       +
                " WHERE " +
                " ProductId = ? "   +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst=con.getConn().prepareStatement(SQLs);
        pst.setInt(1,productId);
        rs= pst.executeQuery();

        assert rs!=null;
        rs.next();

        return rs.getBlob("picture").getBinaryStream();
    }

    private void getAllInfo(ResultSet rs) throws SQLException{
        tempProduct.setProductId(rs.getInt("ProductId"));
        tempProduct.setProductName(rs.getString("ProductName"));
        tempProduct.setProductDes(rs.getString("ProductDes"));
        tempProduct.setPicture(rs.getBinaryStream("picture"));
        tempProduct.setPrice(rs.getDouble("price"));
        tempProduct.setCategoryId(rs.getInt("CategoryId"));
    }



}