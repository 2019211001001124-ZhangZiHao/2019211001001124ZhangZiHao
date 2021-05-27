package com.ZhangZihao.dao;

import com.ZhangZihao.model.Category;
import com.ZhangZihao.model.Conn;
import com.ZhangZihao.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CategoryDao {

    String SQLs;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    Category tempCategory;
    List<Category> tempCategoryList;

    public CategoryDao(){
        SQLs="";
        st=null;
        pst=null;
        rs=null;
        tempCategory=new Category();
        tempCategoryList= new ArrayList<>();
    }

    public int save(Category category, Conn con) throws SQLException {

        SQLs = "" +
                " INSERT " +
                " INTO [Category] " +
                " (CategoryName,Des,Active) " +
                " values(?,?,?) " +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst.setString(1, category.getCategoryName());
        pst.setString(2, category.getDes());
        pst.setString(2, category.getActive());
        //return n>0?n:0;
        return pst.executeUpdate();

    }//end save

    public int delete(Integer categoryId, Conn con) throws SQLException{
        SQLs = "" +
                " DELETE " +
                " FROM [Category] " +
                " WHERE " +
                " CategoryId = ? " +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst.setInt(1,categoryId);

        return pst.executeUpdate();
    }

    public int update(Category instance, Conn con) throws SQLException{

        SQLs = "" +
                " UPDATE [Category] "+
                " SET "             +
                " CategoryName = ?, "+
                " Des = ?, " +
                " Active = ? "    +
                " WHERE "           +
                " CategoryId = ?"    +
                ";";

        pst = con.getConn().prepareStatement(SQLs);

        pst.setString(1,instance.getCategoryName());
        pst.setString(2,instance.getDes());
        pst.setString(3,instance.getActive());
        pst.setInt(4,instance.getCategoryId());

        return pst.executeUpdate();

    }

    public Category findById(Integer categoryId, Conn con) throws SQLException{

        SQLs = "" +
                " SELECT * "             +
                " FROM [Category] "      +
                " WHERE " +
                " CategoryId = ? "   +
                ";";
        pst = con.getConn().prepareStatement(SQLs);

        pst=con.getConn().prepareStatement(SQLs);
        pst.setInt(1,categoryId);
        rs= pst.executeQuery();

        if (rs.next())
            getAllInfo(rs);

        return tempCategory;
    }
    public List<Category> findAll(Conn con) throws SQLException {

        SQLs = "" +
                " SELECT * "                +
                " FROM [Category] "          +
                ";";
        st= con.getStatement();
        rs= st.executeQuery(SQLs);

        tempCategoryList.clear();
        while (rs.next()){
            getAllInfo(rs);
            tempCategoryList.add(tempCategory);
            tempCategory=new Category();
        }

        if(tempCategoryList.isEmpty())
            return null;
        return tempCategoryList;
    }

    private void getAllInfo(ResultSet rs) throws SQLException{
        tempCategory.setCategoryId(rs.getInt("CategoryId"));
        tempCategory.setCategoryName(rs.getString("CategoryName"));
        tempCategory.setDes(rs.getString("Des"));
        tempCategory.setActive(rs.getString("Active"));
    }
}
