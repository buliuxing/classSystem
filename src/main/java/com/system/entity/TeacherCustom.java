package com.system.entity;

/**
 * @author ：yangzengrui
 * @date ：Created in 9/4/2019 11:16 PM
 * @description：teacher扩展类
 */

public class TeacherCustom extends Teacher {

    //所属院校
    private String collegeName;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
