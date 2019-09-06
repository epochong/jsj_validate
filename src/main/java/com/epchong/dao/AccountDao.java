package com.epchong.dao;

import com.epchong.po.User;
import com.epchong.utils.JdbcUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author epochong
 * @date 2019/9/5 16:27
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class AccountDao {
    public boolean register(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        Connection connection = null;
        PreparedStatement statement = null;
        connection = JdbcUtils.getConnection();
        String sql = "insert into user(userName,password) values(?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,userName);
            statement.setString(2,DigestUtils.md5Hex(password));
            int res = statement.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public User userLogin(String userName,String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        connection = JdbcUtils.getConnection();
        User user = new User();
        String sql = "select * from user where userName = ? and password = ?";
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1,userName);
            statement.setString(2,DigestUtils.md5Hex(password));
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = getUser(resultSet);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection,statement,resultSet);
        }
        return null;
    }
    public static User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setPassword(resultSet.getString("password"));
        user.setUserName(resultSet.getString("userName"));
        return user;
    }
}
