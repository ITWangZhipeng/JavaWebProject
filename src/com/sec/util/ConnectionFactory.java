package com.sec.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/26.
 */
public class ConnectionFactory {
    /**
     * 通过Properties类读取properties文件，从文件中获取数据库驱动信息
     * 通过如下语句连接：
     *  ConnectionFactory cf = ConnectionFactory.getInstance();
     *  Connection conn = cf.makeConnection();
     *或
     * Connection conn = ConnectionFactory.getInstance().makeConnection();
     */
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
        /**
         * 私有的构造方法，采用单例模式
         */
    }

    private Connection connection;

    public static ConnectionFactory getInstance() {
        /**
         * 单例模式只能通过getInstance()方法获得实例
         */
        return factory;
    }

    public Connection makeConnection() {
        /**
         * 方法用于建立连接
         */
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dburl, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
