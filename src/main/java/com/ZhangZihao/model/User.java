package com.ZhangZihao.model;

import com.ZhangZihao.week4.acti.toSQLs;

import java.sql.Date;

public class User {

    int     ID          = 0;
    String  UserName    = null;
    String  Password    = null;
    String  Email       = null;
    String  Gender      = null;
    Date    Birthdate   = null;

    public User(int ID, String UserName, String password, String email, String Gender, String Birthdate){
        this.ID = ID;
        this.UserName = UserName;
        this.Password = password;
        this.Email = email;
        this.Gender = Gender;
        this.Birthdate = Date.valueOf(Birthdate);
    }
    public User(String UserName, String password, String email, String Gender, String Birthdate){
        this.UserName = UserName;
        this.Password = password;
        this.Email = email;
        this.Gender = Gender;
        this.Birthdate = Date.valueOf(Birthdate);
    }
    public User(String UserName, String password, String Gender){
        this.UserName = UserName;
        this.Password = password;
        this.Gender = Gender;
    }
    public User(String UserName, String password){

        this.UserName = UserName;
        this.Password = password;
    }
    public User(int ID){
        this.ID = ID;
    }
    public User(){}

    @Override
    public String toString(){
        return "User{"                              +
                "id=" +             ID              +
                ", UserName=" +     getUserName()   +
                ", Password=" +     getPassword()   +
                ", Email=" +        getEmail()      +
                ", Gender=" +       getGender()     +
                ", Birthdate=" +    getBirthdate()  +
                "};";
    }
//--------------------
public int getID() {
    return ID;
}
    public String getUserName() {
        return UserName;
    }
    public String getPassword() {
        return Password;
    }
    public String getEmail() {
        return Email;
    }
    public String getGender() {
        return Gender;
    }
    public String getBirthdate() {
        if(Birthdate==null)
            return null;
        return Birthdate.toString();
    }
/*public int getID() {
    return ID;
}
    public String getUserName() {
        return toSQLs.SQLs(UserName);
    }
    public String getPassword() {
        return toSQLs.SQLs(Password);
    }
    public String getEmail() {
        return toSQLs.SQLs(Email);
    }
    public String getGender() {
        return toSQLs.SQLs(Gender);
    }
    public String getBirthdate() {
        if(Birthdate==null)
            return null;
        return toSQLs.SQLs(Birthdate.toString());
    }*/
//-----------------
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public void setPassword(String password) {
        this.Password = password;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public void setBirthdate(String birthdate) {
        Birthdate = Date.valueOf(birthdate);
    }
}
