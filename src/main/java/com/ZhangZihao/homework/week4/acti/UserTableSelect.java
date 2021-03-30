package com.ZhangZihao.homework.week4.acti;

import com.ZhangZihao.homework.week4.conn.Conn;
import com.ZhangZihao.homework.week4.table.usertable;

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

    private ResultSet doSelect(usertable table){
        selectSQL= ""+
                "SELECT * "							+
                "FROM [usertable] "+
                "WHERE " +
                "\"ID\" > 0";
        if(table.getID()!=null)
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public void resultSQL(usertable table,PrintWriter out) throws SQLException
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
    public void fillTable(usertable table)//仅考虑结果唯一
    {
        rs=doSelect(table);
        assert rs != null;
        try {
            rs.next();
            table.setID(rs.getString("ID"));
            table.setUserName(rs.getString("UserName"));
            table.setPassword(rs.getString("Password"));
            table.setEmail(rs.getString("Email"));
            table.setGender(rs.getString("Gender"));
            table.setBirthdate(rs.getString("Birthdate"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void destroy(){
        System.out.println("bye");
        con.close();
    }
}
