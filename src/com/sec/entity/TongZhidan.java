package com.sec.entity;

/**
 * Created by Administrator on 2016/11/26.
 */
public class TongZhidan extends IdEntity {
    private int No;
    private String content;
    private String Department;

    public void setNo(int no) {
        No = no;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public int getNo() {
        return No;
    }

    public String getContent() {
        return content;
    }

    public String getDepartment() {
        return Department;
    }

    @Override
    public String toString() {
        return "TongZhidan{" +
                "No=" + No +
                ", content='" + content + '\'' +
                ", Department='" + Department + '\'' +
                ", no=" + getNo() +
                ", department='" + getDepartment() + '\'' +
                '}';
    }
}


