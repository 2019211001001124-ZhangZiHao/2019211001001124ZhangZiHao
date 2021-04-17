//Obsolete class
package com.ZhangZihao.dao;

import com.ZhangZihao.week4.conn.Conn;
import com.ZhangZihao.model.User;

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

    public void doInsert(User table){
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
        } catch (SQLException E) {
            E.printStackTrace();
        }
    }

    public void close(){
        System.out.println("bye");
        con.close();
    }
}
