package com.sec.entity;

/**
 * Created by Administrator on 2016/11/26.
 */
public abstract class IdEntity {
    /**
     * 所有表的父类，ID作为主键。
     * 故所有数据库对象都要以IdEntity作为父类
     */
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }
}

