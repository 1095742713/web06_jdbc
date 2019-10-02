package Tool;

import sun.misc.Resource;

import java.sql.*;
import java.util.ResourceBundle;

public class  jdbctool{

    // 数据库基本四项
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 0.给成员变量赋值
    static {
        try {
            // sun公司专门提供了一个读取src目录下的properties文件的工具类
            ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
            driver = resourceBundle.getString("jdbc.driver");
            url = resourceBundle.getString("jdbc.url");
            username = resourceBundle.getString("jdbc.username");
            password = resourceBundle.getString("jdbc.password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1.注册驱动，只注册一次 static{}
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
            throw new RuntimeException("初始化驱动失败...");
        }
    }

    // 2.提供方法获取连接 static
    public static Connection getConnection() throws  SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // 3.提供方法释放资源 static
    public static void releaseResource(ResultSet resultSet, Statement statement, Connection connection) {
        // 释放结果集对象
        if (resultSet != null) {
            try {
               resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 释放执行对象
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 释放连接对象
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 释放资源方法重载
    public static void releaseResource(Statement statement, Connection connection) {
        releaseResource(null, statement, connection);
    }

}