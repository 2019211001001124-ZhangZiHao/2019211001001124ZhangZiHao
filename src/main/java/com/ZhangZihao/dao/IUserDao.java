package com.ZhangZihao.dao;

import com.ZhangZihao.model.User;
import com.ZhangZihao.week4.conn.Conn;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public interface IUserDao {
    public boolean saveUser(Conn con, User user) throws SQLException;
    public boolean deleteUser(Conn con, User user) throws SQLException;
    public boolean updateUser(Conn con, User user) throws SQLException;

    public User findById(Conn con, Integer id) throws SQLException;
    public User findByUsernamePassword(Conn con, String username,String password) throws SQLException;
    public List<User> findByUsername(Conn con, String username) throws SQLException;
    public List<User> findByPassword(Conn con, String password) throws SQLException;
    public List<User> findByEmail(Conn con,String email) throws SQLException;
    public List<User> findByGender(Conn con,String gender) throws SQLException;
    public List<User> findByBirthdate(Conn con, Date birthDate) throws SQLException;
    public List<User> findAllUser(Conn con) throws SQLException;


}
