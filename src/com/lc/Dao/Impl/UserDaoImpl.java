package com.lc.Dao.Impl;

import com.lc.DButils.DButils;
import com.lc.Dao.UserDao;
import com.lc.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    @Override
    public boolean Loginyz(User user) {
        DButils dButils = new DButils();
        connection = dButils.getConnection();
        String sql = "select userid,password from users where userid=? and password =?";
        try {
            preparedStatement = dButils.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
