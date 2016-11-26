package com.sec.test;

import com.sec.com.sec.dao.UserDao;
import com.sec.com.sec.dao.com.sec.dao.impl.UserDaoImpl;
import com.sec.entity.User;
import com.sec.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/26.
 */
public class UserDaoTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            UserDao userDao = new UserDaoImpl();
            User qxw = new User();
//            qxw.setUsername("秦小伟");
//            qxw.setPassword("123456");
//            qxw.setWorkId(10433234);
//            qxw.setId(5);
//            userDao.delete(conn, qxw);
            userDao.selectAll(conn);

            conn.commit();
        }catch(Exception e){
            try {
                conn.rollback();
                System.out.println("==========插入失败==========");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
