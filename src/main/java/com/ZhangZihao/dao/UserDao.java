package com.ZhangZihao.dao;

import com.ZhangZihao.model.User;
import com.ZhangZihao.model.Conn;

import java.sql.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class UserDao implements IUserDao{
    String SQLs;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    User tempUser;
    List<User> tempUserList;


    public UserDao(){
        SQLs="";
        st=null;
        pst=null;
        rs=null;
        tempUser=new User();
        tempUserList=new LinkedList<>();

    }

    @Override
    public boolean saveUser(Conn con, User user) throws SQLException {
        SQLs= ""+
                "INSERT INTO [usertable] "	+
                "VALUES(?,?,?,?,?) ;";

        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setString(1,user.getUserName());
            pst.setString(2,user.getPassword());
            pst.setString(3,user.getEmail());
            pst.setString(4,user.getGender());
            pst.setString(5,user.getBirthdate());
            if(pst.execute());
                return true;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(Conn con, User user) throws SQLException {
        SQLs= ""+
                "DELETE FROM [usertable]" +
                "WHERE " +
                "ID > 0  AND " +
                "ID = ? AND " +
                "UserName = ?  AND " +
                "Password = ? ;";

        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setInt(1,user.getID());
            pst.setString(2,user.getUserName());
            pst.setString(3,user.getPassword());
            if(pst.execute())
                return true;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(Conn con, User user) throws SQLException {
        SQLs= ""+
                "UPDATE [usertable] " +
                "SET " +
                "UserName = ? ,"+
                "Password = ? ,"+
                "Email = ? ,"+
                "Gender = ? ,"+
                "Birthdate = ? "+
                "WHERE " +
                "ID > 0  AND " +
                "ID = ? AND " +
                "UserName = ?  AND " +
                "Password = ? ;";

        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setString(1,user.getUserName());
            pst.setString(2,user.getPassword());
            pst.setString(3,user.getEmail());
            pst.setString(4,user.getGender());
            pst.setString(5,user.getBirthdate());

            pst.setInt(6,user.getID());
            pst.setString(7,user.getUserName());
            pst.setString(8,user.getPassword());
            if(pst.execute())
                return true;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(Conn con, Integer id) throws SQLException {
        SQLs= ""+
                "SELECT * FROM [usertable] "+
                "WHERE " +
                "ID > 0  AND " +
                "ID = ? ;";
        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setInt(1,id);
            ResultSet rs= pst.executeQuery();

            if (rs.next())
                getAllInfo(rs);
            return tempUser;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByUsernamePassword(Conn con, String username, String password) throws SQLException {
        SQLs= ""+
                "SELECT * FROM usertable "+
                "WHERE " +
                "ID > 0  AND " +
                "UserName = ? AND " +
                "Password = ? ;";

        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setString(1,username);
            pst.setString(2,password);
            ResultSet rs= pst.executeQuery();
            if(!rs.next())
                return null;
            getAllInfo(rs);

            return tempUser;

        } catch (SQLException E) {
            E.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findByUsername(Conn con, String username) throws SQLException {
        tempUserList.clear();

        SQLs= ""+
                "SELECT * FROM [usertable] "+
                "WHERE " +
                "ID > 0  AND " +
                "UserName = ? ;";
        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setString(1,username);
            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                getAllInfo(rs);
                tempUserList.add(tempUser);
                tempUser=new User();
            }
            return tempUserList;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findByPassword(Conn con, String password) throws SQLException {
        tempUserList.clear();

        SQLs= ""+
                "SELECT * FROM [usertable] "+
                "WHERE " +
                "ID > 0  AND " +
                "Password = ? ;";
        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setString(1,password);
            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                getAllInfo(rs);
                tempUserList.add(tempUser);
                tempUser=new User();
            }
            return tempUserList;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findByEmail(Conn con, String email) throws SQLException {
        tempUserList.clear();

        SQLs= ""+
                "SELECT * FROM [usertable] "+
                "WHERE " +
                "ID > 0  AND " +
                "Email = ? ;";
        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setString(1,email);
            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                getAllInfo(rs);
                tempUserList.add(tempUser);
                tempUser=new User();
            }
            return tempUserList;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findByGender(Conn con, String gender) throws SQLException {
        tempUserList.clear();

        SQLs= ""+
                "SELECT * FROM [usertable] "+
                "WHERE " +
                "ID > 0  AND " +
                "Gender = ? ;";
        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setString(1,gender);
            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                getAllInfo(rs);
                tempUserList.add(tempUser);
                tempUser=new User();
            }
            return tempUserList;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findByBirthdate(Conn con, Date birthDate) throws SQLException {
        tempUserList.clear();

        SQLs= ""+
                "SELECT * FROM [usertable] "+
                "WHERE " +
                "ID > 0  AND " +
                "BirthDate = ? ;";
        try {
            pst=con.getConn().prepareStatement(SQLs);
            pst.setDate(1,birthDate);
            ResultSet rs= pst.executeQuery();

            while (rs.next()){
                getAllInfo(rs);
                tempUserList.add(tempUser);
                tempUser=new User();
            }
            return tempUserList;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAllUser(Conn con) throws SQLException {
        tempUserList.clear();

        SQLs= ""+
                "SELECT * FROM [usertable] "+
                "WHERE " +
                "ID > 0  ;";
        try {
            rs=con.getStatement().executeQuery(SQLs);

            while (rs.next()){
                getAllInfo(rs);
                tempUserList.add(tempUser);
                tempUser=new User();
            }
            return tempUserList;
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return null;
    }

    private void getAllInfo(ResultSet rs) throws SQLException{
        tempUser.setID(rs.getInt("ID"));
        tempUser.setUserName(rs.getString("UserName"));
        tempUser.setPassword(rs.getString("Password"));
        tempUser.setEmail(rs.getString("Email"));
        tempUser.setGender(rs.getString("Gender"));
        tempUser.setBirthdate(rs.getString("Birthdate"));
    }
    public String getSQLs(){
        return SQLs;
    }

}
