package com.sec.com.sec.dao.com.sec.dao.impl;

import com.sec.com.sec.dao.UserDao;
import com.sec.entity.User;

import java.sql.*;

/**
 * Created by Administrator on 2016/11/26.
 */
public class UserDaoImpl implements UserDao {
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

    public void selectAll(Connection connection) throws SQLException{
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM test");
        while(rs.next()){
            int id = rs.getInt(1);// 起始位置是1，不是0 String name =
            int WorkId  = rs.getInt(2);
            String username = rs.getString(3);
            String password = rs.getString(4);
            System.out.println("user id=" + id + "， WorkId= " + WorkId + ", username= " + username + ", password= " + password);

        }
    }
}
