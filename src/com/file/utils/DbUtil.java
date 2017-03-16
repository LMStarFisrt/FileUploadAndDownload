package com.file.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * Created by dadisdad on 2017/3/16.
 */
public class DbUtil {

    private static final String driver;
    private static final String url;
    private static final String user;
    private static final String password;

    private static Connection conn=null;

    static {
        Properties properties= null;
        try {
            properties = PropertyUtil.getProperties("jdbc.properties");
        } catch (IOException e) {
            System.err.println("无法找到数据库资源配置文件");
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        user=properties.getProperty("user");
        password=properties.getProperty("password");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }

}
