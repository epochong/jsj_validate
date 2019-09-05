package com.epchong.utils;

import java.sql.*;
import java.util.Properties;

/**
 * @author epochong
 * @date 2019/9/5 15:56
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class JdbcUtils {
    private static String driverName;
    private static String url;
    private static String userName;
    private static String password;

    static {
        Properties properties = CommUtils.loadProperties("db.properties");
        driverName = properties.getProperty("driverClassName");
        url = properties.getProperty("url");
        password = properties.getProperty("password");
        userName = properties.getProperty("userName");
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(connection,statement);
    }
}
