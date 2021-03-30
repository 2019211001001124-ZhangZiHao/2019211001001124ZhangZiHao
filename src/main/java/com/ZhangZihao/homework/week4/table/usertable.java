package com.ZhangZihao.homework.week4.table;

import com.ZhangZihao.homework.week4.acti.toSQLs;

import javax.lang.model.element.Name;
import java.sql.Date;

public class usertable {

    String  ID          = null;
    String  UserName    = null;
    String  password    = null;
    String  email       = null;
    String  Gender      = null;
    Date    Birthdate   = null;

    public usertable(String ID, String UserName, String password, String email, String Gender, String Birthdate){
        this.ID = ID;
        this.UserName = UserName;
        this.password = password;
        this.email = email;
        this.Gender = Gender;
        this.Birthdate = Date.valueOf(Birthdate);
    }
    public usertable(String UserName, String password, String email, String Gender, String Birthdate){
        this.UserName = UserName;
        this.password = password;
        this.email = email;
        this.Gender = Gender;
        this.Birthdate = Date.valueOf(Birthdate);
    }
    public usertable(String UserName, String password, String Gender){
        this.UserName = UserName;
        this.password = password;
        this.Gender = Gender;
    }
    public usertable(String UserName,String password){

        this.UserName = UserName;
        this.password = password;
    }
    public usertable(String ID){
        this.ID = ID;
    }
    public usertable(){}

    @Override
    public String toString(){
        return ID+"    "+UserName+"    "+password+"    "+Gender+"    "+Birthdate;
    }
//--------------------
    public String getID() {
        return toSQLs.SQLs(ID);
    }
    public String getUserName() {
        return toSQLs.SQLs(UserName);
    }
    public String getPassword() {
        return toSQLs.SQLs(password);
    }
    public String getEmail() {
        return toSQLs.SQLs(email);
    }
    public String getGender() {
        return toSQLs.SQLs(Gender);
    }
    public String getBirthdate() {
        if(Birthdate==null)
            return null;
        return toSQLs.SQLs(Birthdate.toString());
    }
//-----------------
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public void setBirthdate(String birthdate) {
        Birthdate = Date.valueOf(birthdate);
    }
}
