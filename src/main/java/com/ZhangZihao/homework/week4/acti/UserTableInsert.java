package com.ZhangZihao.homework.week4.acti;

import com.ZhangZihao.homework.week4.conn.Conn;
import com.ZhangZihao.homework.week4.table.usertable;

import java.sql.SQLException;

public class UserTableInsert {
    Conn con;
    String insertSQL = "";
    public UserTableInsert() {
        con = new Conn();
    }
    public UserTableInsert(Conn con) {
        this.con = con;
    }
    public UserTableInsert(String address,String Name,String password){
        con = new Conn(address,Name,password);
    }

    public void doInsert(usertable table){
        insertSQL= ""+
                "INSERT INTO [usertable] "	+
                "VALUES("					+
                table.getUserName()		    +','+
                table.getPassword()		    +','+
                table.getEmail()            +','+
                table.getGender()		    +','+
                table.getBirthdate()		+
                ");";

        try {
            con.getStatement().execute(insertSQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(){
        System.out.println("bye");
        con.close();
    }
}
