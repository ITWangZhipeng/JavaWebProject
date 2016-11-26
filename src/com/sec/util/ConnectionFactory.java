package com.sec.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/26.
 */
public class ConnectionFactory {
    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;
    private static final ConnectionFactory factory = new ConnectionFactory();

    static {
        Properties prop = new Properties();
        try {
            InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            prop.load(in);

        } catch (Exception e) {
            System.out.println("==========配置文件读取错误==========");
        }

        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");

    }

    private ConnectionFactory() {

    }

    private Connection connection;

    public static ConnectionFactory getInstance() {
        return factory;
    }

    public Connection makeConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dburl, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
