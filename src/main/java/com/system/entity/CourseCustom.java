package com.system.entity;

/**
 * @author ：yangzengrui
 * @date ：Created in 9/4/2019 11:08 PM
 * @description：课程扩展类
 */

public class CourseCustom extends Course{

    //所属院系名
    private String collegeName;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
