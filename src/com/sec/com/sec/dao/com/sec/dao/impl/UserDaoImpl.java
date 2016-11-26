package com.sec.com.sec.dao.com.sec.dao.impl;

import com.sec.com.sec.dao.UserDao;
import com.sec.entity.User;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;

/**
 * Created by Administrator on 2016/11/26.
 */
public class UserDaoImpl implements UserDao {
    /**
     * 密码错误：1
     * 用户名错误：2
     * 登录成功：3
     */
    public static final int WRONG_PWD = 1;
    public static final int WRONG_USERNAME = 2;
    public static final int LOGIN_SUCCESS = 3;


    @Override
    public void save(Connection connection, User user) throws SQLException {
        PreparedStatement ps = connection.prepareCall("INSERT INTO test(WorkID, username, password) VALUES (?,?,?);");
        ps.setInt(1, user.getWorkId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.execute();
    }

    @Override
    public void update(Connection connection, Long id, User user) throws SQLException {
        String updateSql = "UPDATE test SET username = ?, password = ?, WorkId = ?  WHERE id = ?;";
        PreparedStatement ps = connection.prepareCall(updateSql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setInt(3, user.getWorkId());
        ps.setLong(4, id);
        ps.execute();
    }

    @Override
    public void delete(Connection connection, User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE  FROM test WHERE id = ?;");
        ps.setLong(1, user.getId());
        ps.execute();
    }

    public void selectAll(Connection connection) throws SQLException {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM test");
        while (rs.next()) {
            int id = rs.getInt(1);// 起始位置是1，不是0 String name =
            int WorkId = rs.getInt(2);
            String username = rs.getString(3);
            String password = rs.getString(4);
            System.out.println("user id=" + id + "， WorkId= " + WorkId + ", username= " + username + ", password= " + password);
        }
    }

    @Override
    public int checkLogin(Connection connection, String username, String password) throws SQLException {
        String checkUsername = "SELECT * FROM test WHERE username=\"" + username + "\";";
        System.out.println(checkUsername);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(checkUsername);
        System.out.println("密码错误：1" +
                "用户名错误：2" +
                "登陆成功：3" +
                "");
        if (rs.next()) {
            String pwd = rs.getString(4);
            if (password.equals(pwd)) {
                return LOGIN_SUCCESS;
            } else {
                return WRONG_PWD;
            }
        } else {
            return WRONG_USERNAME;
        }
    }
}
