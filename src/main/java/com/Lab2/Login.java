package com.Lab2;


public class Login {

    String  userName    = null;
    String  password    = null;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName.trim();
    }
    public String getPassword() {
        return password.trim();
    }
}
