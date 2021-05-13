//Obsolete class
package com.ZhangZihao.dao;

import com.ZhangZihao.model.Conn;
import com.ZhangZihao.model.User;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UserTableSelect {
    Conn con;
    ResultSet rs;
    ResultSetMetaData rsmd;
    String selectSQL = "";
    public UserTableSelect(){
        con = new Conn();
    }
    public UserTableSelect(Conn con){
        this.con = con;
    }
    public UserTableSelect(String address,String Name,String password){
        con = new Conn(address,Name,password);
    }

    private ResultSet doSelect(User table){
        selectSQL= ""+
                "SELECT * FROM [usertable] "+
                "WHERE " +
                "\"ID\" > 0";
        if(table.getID()!=0)
            selectSQL+=" AND "+"ID = "+table.getID();
        if(table.getUserName()!=null)
            selectSQL+=" AND "+"UserName = "+table.getUserName();
        if(table.getPassword()!=null)
            selectSQL+=" AND "+"Password = "+table.getPassword();
        if(table.getEmail()!=null)
            selectSQL+=" AND "+"Email = "+table.getEmail();
        if(table.getGender()!=null)
            selectSQL+=" AND "+"Gender = "+table.getGender();
        if(table.getBirthdate()!=null)
            selectSQL+=" AND "+"UserName = "+table.getBirthdate();
        selectSQL+=";";

        try {
            return con.getStatement().executeQuery(selectSQL);
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return null;
    }
    public void resultSQL(User table, PrintWriter out) throws SQLException
    {
        rs=doSelect(table);
        assert rs != null;
        rsmd=rs.getMetaData();
        int ColumnCount=rsmd.getColumnCount();//结果列数
        for(int i=1;i<=ColumnCount;i++)
            out.print(String.format("%-"+rsmd.getPrecision(i)+"s\t", rsmd.getColumnName(i)));//表头
        out.println();

        while(rs.next())
        {
            for(int i=1;i<=ColumnCount;i++)
                out.print(String.format("%-"+rsmd.getPrecision(i)+"s\t", rs.getString(i))); //格式化
            out.println();
        }
    }
    public void SelectInDb(User table){
        rs=doSelect(table);
    }
    public boolean fillTable(User table)//仅考虑结果唯一
    {
        try {
            if(!rs.next())
                return false;
            table.setID(rs.getInt("ID"));
            table.setUserName(rs.getString("UserName"));
            table.setPassword(rs.getString("Password"));
            table.setEmail(rs.getString("Email"));
            table.setGender(rs.getString("Gender"));
            table.setBirthdate(rs.getString("Birthdate"));
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return true;
    }
    public void SelectClear(){
        rs=null;
    }

    public void close(){
        System.out.println("bye");
        con.close();
    }
}
