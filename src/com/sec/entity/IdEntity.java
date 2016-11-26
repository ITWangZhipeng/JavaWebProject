package com.sec.entity;

/**
 * Created by Administrator on 2016/11/26.
 */
public abstract class IdEntity {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }
}

