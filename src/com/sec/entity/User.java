package com.sec.entity;

/**
 * Created by Administrator on 2016/11/25.
 */
public class User extends IdEntity {
    private String username;
    private String password;
    private int WorkId;
  
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWorkId(int workId) {
        WorkId = workId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getWorkId() {
        return WorkId;
    }

    @Override
    public String toString() {
        return "com.sec.entity.User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", WorkId=" + WorkId +
                ",id=" + super.getId() +
                '}';
    }
}