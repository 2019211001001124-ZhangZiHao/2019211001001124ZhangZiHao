package com.ZhangZihao.homework.week4.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    Connection conn=null;
    Statement stmt=null;
    static{
        // 加载驱动确认
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//驱动确认
            }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Conn(){
        connection("jdbc:sqlserver://localhost:1314;DatabaseName=userdb","ZZH","zzh");
    }
    public Conn(String address,String User,String password){
        connection(address,User,password);
    }

    void connection(String address,String User,String password)
    {
        try {
            conn=DriverManager.getConnection(address,User,password);
            stmt=conn.createStatement();//创建sql响应对象
            }catch(SQLException e){
            e.printStackTrace();
            this.close();
        }
    }

    public Statement getStatement() {
        return stmt;
    }

    public void close()
    {
        try
        {
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

}
