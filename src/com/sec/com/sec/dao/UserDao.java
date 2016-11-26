package com.sec.com.sec.dao;

import com.sec.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/26.
 */
public interface UserDao {
    /**
     * User表操作接口
     * @param connection
     * @param user
     * @throws SQLException
     */
    public void save(Connection connection, User user) throws SQLException;
    public void update(Connection connection, Long id, User user) throws SQLException;
    public void delete(Connection connection, User user) throws SQLException;
    public void selectAll(Connection connection) throws SQLException;
    public int checkLogin(Connection connection, String username, String password) throws SQLException;
}
