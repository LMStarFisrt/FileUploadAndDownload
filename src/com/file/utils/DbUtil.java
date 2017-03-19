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

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    private static Connection conn=null;

    public static Connection getConn() throws IOException,ClassNotFoundException,SQLException {
        Properties properties = PropertyUtil.getProperties("jdbc.properties");
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        user=properties.getProperty("user");
        password=properties.getProperty("password");
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void close() throws SQLException{
        conn.close();
    }

}
